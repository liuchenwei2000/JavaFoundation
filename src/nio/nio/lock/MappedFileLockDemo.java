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
 * ӳ���ļ�������ʾ��
 * <p>
 * �ļ�ӳ��ͨ��Ӧ���ڼ�����ļ�����˿�����Ҫ����˾޴���ļ����в��ּ������Ա��������̿����޸��ļ���δ�������Ĳ��֡�
 * ���磬���ݿ������������˶���û�����ͬʱ���ʵ�����
 * 
 * @author ����ΰ
 *
 * �������ڣ�2009-7-26
 */
public class MappedFileLockDemo {
	
	private static final String FILE_NAME = "files/nio.lock/test.dat";
	
	/** �ļ���С 2M */
	private static final int FILE_SIZE = 2 * IConst.M;

	private static FileChannel channel;

	/**
	 * �������������̣߳��ֱ�����ļ��Ĳ�ͬ���֣�ÿ���̶߳����޸������������ǲ��ֵ����ݡ�
	 * ֤�����������̿����޸��ļ���δ�����̼߳����Ĳ��֡�
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		try {
			channel = new RandomAccessFile(FILE_NAME, "rw").getChannel();
			MappedByteBuffer mbb = channel.map(FileChannel.MapMode.READ_WRITE, 0, FILE_SIZE);
			for (int i = 0; i < FILE_SIZE; i++) {
				mbb.put((byte) 'x');
			}
			
			// �����ļ��� 0 - 0 + FILE_SIZE / 4 ����
			new LockAndModify(mbb, 0, 0 + FILE_SIZE / 4).start();
			
			// �����ļ��� FILE_SIZE / 2 �� FILE_SIZE / 2 + FILE_SIZE / 4 ����
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
	 * ���̻߳����������ָ���Ĳ��֣�Ȼ�����޸��ⲿ�ּ���������
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
			 * slice()�����µ��ֽڻ���������������mbb���������ݵĹ��������С�
			 * �»����������ݽ���mbb�������ĵ�ǰλ��(position)��ʼ��mbb���������ݵĸ������»��������ǿɼ��ģ���֮��Ȼ��
			 * ��������������λ�á����޺ͱ��ֵ���໥�����ġ�
			 */
			buffer = mbb.slice();
		}

		public void run() {
			try {
				FileLock lock = channel.lock(start, end, false);
				System.out.println("Locked: " + start + " to " + end);
				// �޸ļ����Ļ�����
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