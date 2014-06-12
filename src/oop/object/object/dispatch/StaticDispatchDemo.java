/**
 * 
 */
package object.dispatch;

/**
 * ��̬������ʾ
 * <p>
 * Javaͨ����������(overload)֧�־�̬���ɡ�
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2010-6-11
 */
public class StaticDispatchDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StaticDispatchDemo demo = new StaticDispatchDemo();
		Horse wh = new WhiteHorse();
		Horse bh = new BlackHorse();
		/*
		 * ��ӡ������£�
		 * ride a horse.
		 * ride a horse.
		 * 
		 * ���ζ�ride()�����ĵ��ô�����ǲ�ͬ�Ĳ�����Ҳ����wh��bh��
		 * ������Ȼ���в�ͬ����ʵ���ͣ��������ǵľ�̬���Ͷ���һ����(Horse)��
		 * ���صķ����ķ����Ǹ��ݾ�̬���ͽ��еģ�������ɹ������ڱ���ʱ�ھ�����ˡ�
		 */
		demo.ride(wh);
		demo.ride(bh);
	}

	/** ride()���������������������ض��� **/
	
	public void ride(Horse horse) {
		System.out.println("ride a horse.");
	}

	public void ride(WhiteHorse horse) {
		System.out.println("ride a white horse.");
	}

	public void ride(BlackHorse horse) {
		System.out.println("ride a black horse.");
	}
}

abstract class Horse {
}

class WhiteHorse extends Horse {
}

class BlackHorse extends Horse {
}