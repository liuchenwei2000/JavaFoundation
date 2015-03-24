/**
 * 
 */
package rtti;

import java.util.Random;

/**
 * ���ʼ��
 * <p>
 * ��ʹ��".class"��������Class���������ʱ�������Զ��س�ʼ����Class����
 * <p>
 * Ϊ��ʹ���������׼������ʵ�ʰ����������裺
 * <li>1������ 
 * ����ʹ���������ִ�еģ��ò��轫����class�ļ�������һ��Class����
 * <li>2������ 
 * �����ӽ׶ν���֤���е��ֽ��룬Ϊ��̬�����洢�ռ䣬 �����������Ļ�������������ഴ���Ķ���������������á�
 * <li>3����ʼ�� 
 * ���������г��࣬������ʼ����ִ�о�̬��ʼ�����;�̬��ʼ���顣
 * 
 * @author ����ΰ
 *
 * �������ڣ�2008-5-9
 */
public class ClassInitialization {

	/**
	 * ��ʼ����Ч��ʵ���˾����ܵ�"����"��
	 * ʹ�� .class �﷨����ȡ��������ò���������ʼ������  Class.forName() �����ͽ����˳�ʼ����
	 */
	@SuppressWarnings( { "unused" })
	public static void main(String[] args) throws Exception {
		Class<?> initable = Initable.class;
		System.out.println("After creating Initable ref");
		/*
		 * ���һ��static finalֵ��"�����ڳ���"��������Initable.staticFinal��
		 * ��ô���ֵ����Ҫ��Initable����г�ʼ���Ϳ��Ա���ȡ��
		 * 
		 * ���ֻ�ǽ�һ��������Ϊstatic final�ģ���������ȷ��������Ϊ��
		 * ����Initable.staticFinal2�ķ��ʽ�ǿ�ƽ�����ĳ�ʼ������Ϊ�����Ǳ����ڳ�����
		 * 
		 * ���һ��static����final�ģ���ô��������ʱ����Ҫ����������ȡ֮ǰ��
		 * Ҫ�Ƚ�������(Ϊ��������洢�ռ�)�ͳ�ʼ��(��ʼ���ô洢�ռ�)�������ڶ�Initable2.staticNonFinal�ķ���һ����
		 */
		// ���ᴥ����ʼ��
		System.out.println(Initable.staticFinal);
		// �ᴥ����ʼ��
		System.out.println(Initable.staticFinal2);
		// �ᴥ����ʼ��
		System.out.println(Initable2.staticNonFinal);
		Class<?> initable3 = Class.forName("rtti.Initable3");
		System.out.println("After creating Initable3 ref");
		System.out.println(Initable3.staticNonFinal);
	}
}

class Initable{
	
	static final int staticFinal = 47;
	static final int staticFinal2 = new Random().nextInt(1000);
	
	static {
		System.out.println("Initializing Initable");
	}
}

class Initable2 {
	
	static int staticNonFinal = 147;
	
	static {
		System.out.println("Initializing Initable2");
	}
}

class Initable3 {
	
	static int staticNonFinal = 74;
	
	static {
		System.out.println("Initializing Initable3");
	}
}