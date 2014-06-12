/**
 * 
 */
package syntax.keywords;

/**
 * volatile示例
 * <p>
 * volatile修饰域，在每次被线程访问时，都强迫从共享内存中重读该成员变量的值。
 * 而且，当成员变量发生变化时，强迫线程将变化值回写到共享内存。
 * 这样在任何时刻，两个不同的线程总是看到某个成员变量的同一个值。
 * 当某些成员变量不能够使用synchronized控制并发时可使用volatile修饰。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2007-12-13
 */
public class VolatileDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Thread tg1 = new Thread(new Runnable() {

			public void run() {
				while (true) {
					General.one();
//					Synchronized.one();
//					Volatile.one();
				}
			}

		});
		Thread tg2 = new Thread(new Runnable() {

			public void run() {
				while (true) {
					General.two();
//					Synchronized.two();
//					Volatile.two();
				}
			}

		});
		tg1.start();
		tg2.start();
	}
}

class General {
	
	static int i = 0, j = 0;

	static void one() {
		i++;
		j++;
	}

	static void two() {
		System.out.println("i=" + i + " j=" + j);
	}
}

class Synchronized {
	
	static int i = 0, j = 0;

	static synchronized void one() {
		i++;
		j++;
	}

	static synchronized void two() {
		System.out.println("i=" + i + " j=" + j);
	}
}

class Volatile {
	
	static volatile int i = 0, j = 0;

	static void one() {
		i++;
		j++;
	}

	static void two() {
		System.out.println("i=" + i + " j=" + j);
	}
}