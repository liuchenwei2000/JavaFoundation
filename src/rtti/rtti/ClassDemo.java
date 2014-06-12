/**
 * 
 */
package rtti;

import inherit.difference.Animal;
import inherit.difference.IRunnable;

/**
 * Class����ʾ
 * <p>
 * Class��������ָ��ĳ��Class�����������������ʵ��������������������Щʵ�������з������룬����������ľ�̬��Ա��
 * Class����÷�����getClass()��newInstance()��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2007-8-5
 */
public class ClassDemo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Human human = new Human();
		// ���һ��Class����ķ���������
		// 1,����һ�������ṩ������Ӧ�������
		Class<?> cl = human.getClass();
		System.out.println(cl.getName());
		// 2,ʹ�þ�̬forName()����������һ���ַ�����Ӧ�������
		String className = "rtti.Human";
		try {
			// ����classNameû�м�����������������
			cl = Class.forName(className);
			System.out.println(cl.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 3,ʹ�������泣��,�� T.class ��������������
		// �������������򵥣����Ҹ���ȫ����Ϊ���ڱ���ʱ�ͻ��ܵ����
		// �����������˶�forName()�����ĵ��ã�����Ҳ����Ч
		// �����泣����������Ӧ������ͨ���࣬Ҳ����Ӧ���ڽ�ڡ������Լ�������������
		cl = int[].class;
		System.out.println(cl.getName());
		// JVMΪÿ�����͹���һ��Class���󣬿�������  == ʵ�����������ȽϵĲ���
		if (cl == int[].class)
			System.out.println("cl is int[].class");

		/*
		 * ��̬�������һ��ʵ���ķ��� 
		 * 
		 * ����������ᴴ��һ��ָ�������ʵ�� �����õ����޲ι��췽��,����ʼ���½�����
		 */
		try {
			/*
			 * һ�㽫forName��newInstance���ʹ��
			 * �����ַ������������������һ�����������õ���Ĭ�ϵĹ�����(û�в����Ĺ�����)��
			 * �����û���޲ι���������׳�InstantiationException��
			 * ��������޲ι���������private������׳� IllegalAccessException�����ʾΥ����Java��ȫ���ơ�
			 */
			// ���ַ�ʽֻ��ʹ��Object�����ö���
			Object obj = Class.forName(className).newInstance();
			System.out.println(obj);
			// ʹ���˷��͵ķ�ʽ����ֱ��ʹ�þ�ȷ�������ö���
			Class<Human> clazz = Human.class;
			Human hm = clazz.newInstance();
			System.out.println(hm);
			// ����ʹ��Class<Animal>������clazz.getSuperclass()
			Class<? super Human> supers = clazz.getSuperclass();
			Object base = supers.newInstance();// ֻ��ʹ��Object������
			System.out.println(base);
			/*
			 * ������򱻵��õ���Ĺ������ṩ��������Ҫʹ��Constructor���е�newInstance������
			 */
			
			// class.getInterfaces()�������ص���Class����ֱ��ʵ�ֵĽӿڣ������丸��ʵ�ֵĽӿ�
			Class<?>[] itfs = Human.class.getInterfaces();
			for (Class<?> itf : itfs) {
				System.out.println("Human.class directly implements " + itf.getName());
			}
			// �ж�Class��������ʾ����(�ӿ�)��ָ����Class��������ʾ����(�ӿ�)�Ƿ���ͬ
			// (���Ƿ���Class�����ĳ���(���ӿ�))
			boolean isRunnable = IRunnable.class.isAssignableFrom(Human.class);
			if (isRunnable) {
				System.out.println("Human.class implements "
						+ IRunnable.class.getName());
			} else {
				System.out.println("Human.class not implements "
						+ IRunnable.class.getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String toString(){
		return "ClassDemo ����" + super.toString();
	}
}

interface Sexable {

	public static final int MALE = 0;// ����
	public static final int FEMALE = 1;// ����
}

class Human extends Animal implements Sexable {
}