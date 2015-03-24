/**
 * 
 */
package nio.lock;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

import nio.IConst;

/**
 * 映射文件加锁演示类
 * <p>
 * 文件映射通常应用于极大的文件，因此可能需要对如此巨大的文件进行部分加锁，以便其他进程可以修改文件中未被加锁的部分。
 * 例如，数据库就是这样，因此多个用户可以同时访问到它。
 * 
 * @author 刘晨伟
 *
 * 创建日期：2009-7-26
 */
public class MappedFileLockDemo {
	
	private static final String FILE_NAME = "files/nio.lock/test.dat";
	
	/** 文件大小 2M */
	private static final int FILE_SIZE = 2 * IConst.M;

	private static FileChannel channel;

	/**
	 * 本例中有两个线程，分别加锁文件的不同部分，每个线程都会修改其所加锁的那部分的内容。
	 * 证明了其他进程可以修改文件中未被该线程加锁的部分。
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		try {
			channel = new RandomAccessFile(FILE_NAME, "rw").getChannel();
			MappedByteBuffer mbb = channel.map(FileChannel.MapMode.READ_WRITE, 0, FILE_SIZE);
			for (int i = 0; i < FILE_SIZE; i++) {
				mbb.put((byte) 'x');
			}
			
			// 加锁文件的 0 - 0 + FILE_SIZE / 4 部分
			new LockAndModify(mbb, 0, 0 + FILE_SIZE / 4).start();
			
			// 加锁文件的 FILE_SIZE / 2 到 FILE_SIZE / 2 + FILE_SIZE / 4 部分
			new LockAndModify(mbb, FILE_SIZE / 2, FILE_SIZE / 2 + FILE_SIZE / 4).start();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(channel != null) {
				try {
					TimeUnit.SECONDS.sleep(3);
					channel.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 本线程会加锁缓冲区指定的部分，然后再修改这部分加锁的内容
	 */
	private static class LockAndModify extends Thread {

		private ByteBuffer buffer;
		private int start, end;

		private LockAndModify(ByteBuffer mbb, int start, int end) {
			this.start = start;
			this.end = end;
			
			mbb.limit(end);
			mbb.position(start);
			
			/*
			 * slice()创建新的字节缓冲区，其内容是mbb缓冲区内容的共享子序列。
			 * 新缓冲区的内容将从mbb缓冲区的当前位置(position)开始，mbb缓冲区内容的更改在新缓冲区中是可见的，反之亦然。
			 * 这两个缓冲区的位置、界限和标记值是相互独立的。
			 */
			buffer = mbb.slice();
		}

		public void run() {
			try {
				FileLock lock = channel.lock(start, end, false);
				System.out.println("Locked: " + start + " to " + end);
				// 修改加锁的缓冲区
				while (buffer.position() < buffer.limit() - 1) {
					buffer.put((byte) (buffer.get() + 1));
				}
				lock.release();
				System.out.println("Released: " + start + " to " + end);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}