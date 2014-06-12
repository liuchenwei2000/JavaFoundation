/**
 * 
 */
package syntax.keywords;

/**
 * volatileʾ��
 * <p>
 * volatile��������ÿ�α��̷߳���ʱ����ǿ�ȴӹ����ڴ����ض��ó�Ա������ֵ��
 * ���ң�����Ա���������仯ʱ��ǿ���߳̽��仯ֵ��д�������ڴ档
 * �������κ�ʱ�̣�������ͬ���߳����ǿ���ĳ����Ա������ͬһ��ֵ��
 * ��ĳЩ��Ա�������ܹ�ʹ��synchronized���Ʋ���ʱ��ʹ��volatile���Ρ�
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2007-12-13
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