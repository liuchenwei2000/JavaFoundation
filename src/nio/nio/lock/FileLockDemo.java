/**
 * 
 */
package nio.lock;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;

/**
 * 文件锁机制
 * <p>
 * 多个同时运行的程序需要修改同一个文件时，程序之间需要某种通信，否则该文件很容易被损坏。
 * 文件锁控制对文件或者文件一部分字节的访问。
 * <p>
 * 文件锁机制允许同步访问某个作为共享资源的文件。
 * 竞争同一文件的两个线程可能在不同的Java虚拟机上，或者一个是Java线程，另一个是操作系统中其他的本地线程。
 * 文件锁对其他的操作系统进程是可见的，因为Java的文件加锁直接映射到了本地操作系统的加锁工具。
 * 
 * @author 刘晨伟
 *
 * 创建日期：2009-5-13
 */
public class FileLockDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String filePath = "files/nio.lock/file.txt";
		
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(filePath);
			
			// lock 一直处于阻塞状态直到该锁可用
			// FileLock lock = fos.getChannel().lock();
			
			// tryLock 立即返回，返回该锁或者是null(如果该锁不可用)
			FileLock lock = fos.getChannel().tryLock();
			
			// 可以用下面的方法实现锁定文件的一部分
			// FileLock lock = channel.tryLock(long start, long size, boolean shared);
			// 当shared标志为false时为排他锁，独占锁定，锁住该文件的读写。
	        // 当shared标志为true时则为共享锁，它允许多个进程来读文件，但是防止任何进程获取排他锁。
			// 不是所有的操作系统都支持共享锁。因此，尽管请求一个共享锁，获得的很可能是一个排他锁。
			
			if (lock != null) {
				// isShared判断此锁定是否为共享锁 
				System.out.println("lock is shared：" + lock.isShared());
				System.out.println("locked file");
				Thread.sleep(10000);
				// 在释放锁之前手工删除该文件OS会报错
				lock.release();
				System.out.println("released lock");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
