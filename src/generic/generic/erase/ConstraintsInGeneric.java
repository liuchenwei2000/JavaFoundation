/**
 * 
 */
package generic.erase;

import generic.Pair;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * ���͵�Լ�����������ʾ
 * 
 * @author ����ΰ
 *
 * �������ڣ�2009-8-3
 */
public class ConstraintsInGeneric {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		testPrimitiveType();
		testRTTI();
		testException();
		testArray();
		testGenericInstance();
		testStatic();
	}

	/**
	 * 1����������
	 * <p>
	 * ���������Ͳ����滻�������ͣ�û��Pair<double>��ֻ��Pair<Double>����ԭ�������Ͳ�����
	 * ����֮��Pair�����Object���͵��ֶΣ���Object���ܴ洢double(��������)ֵ��
	 * �����û������͵İ�װ������������⡣
	 */
	private static void testPrimitiveType() {
		// ����������б����
		// Pair<double> pair = new Pair<double>();
		Pair<Double> pair = new Pair<Double>();
		pair.setFirst(0.1);
		pair.setSecond(0.2);
	}
	
	/**
	 * 2������ʱ���Ͳ�ѯ
	 * <p>
	 * JVM�еĶ�������һ���ض��ķǷ������ͣ�������е�����ʱ���Ͳ�ѯRTTI(�� instanceof �� getClass())ֻ����ԭ������(��Pair.class)��
	 */
	private static void testRTTI() {
		Pair<String> pair = new Pair<String>();
		// ����������б����
		// boolean b = pair instanceof Pair<String>;
		boolean b = pair instanceof Pair;
		// ǿ������ת��
		Pair<String> p = (Pair<String>) pair;
		Pair<Double> pair2 = new Pair<Double>();
		b = p.getClass() == pair2.getClass();
		System.out
				.println("Pair<String> and Pair<Double> are the same class type:"
						+ p.getClass() + " ? " + b);
	}
	
	/**
	 * 3���쳣
	 * <p>
	 * �����׳�Ҳ���ܲ�������Ķ���ʵ���Ϸ����಻�ܼ̳�Throwable��
	 * ֻ�����ڷ������쳣������ʹ�÷��͡�
	 */
	private static void testException() {
		// ��������չThrowable�ǲ��Ϸ���
		// public class Problem<T> extends Exception{}
		class InnerClass {
			
			/** ������catch�Ӿ���ʹ�����ͱ���(����) */
//			public <T extends Throwable> void doWork(Class<T> t) {
//				try {
//					// ...
//				} catch (T e)// ����ᱨ��
//				{
//					// ...
//				}
//			}

			/**
			 * �ڷ������쳣����(throws)�п���ʹ�����ͱ���(����)
			 */
			public <T extends Throwable> void doWork(T t) throws T // ���ǿ��Ե�
			{
				try {
					throw new RuntimeException("exception in InnerClass.doWork(T t)");
				} catch (Throwable cause) {
					t.initCause(cause);
					throw t;
				}
			}
		}
		try {
			// ���÷�ʽ
			new InnerClass().doWork(new RuntimeException());
		} catch (Exception e) {
			System.out.println("catch exception in InnerClass.doWork(T):");
			System.out.println(e.getCause().getMessage());
		}
	}
	
	/**
	 * 4������
	 * <p>
	 * �����������������͵����飬���Ҫ�ռ����������Ͷ���ʹ��ArrayList<Pair<String>>�ȫ��Ч��
	 */
	private static void testArray() {
		/* 
		 * �����������������͵����飬�磺
		 * 
		 * Pair<String>[] table = new Pair<String>[10];
		 * 
		 * ��Ϊ�����Ͳ���֮��table������ΪPair[]�����Խ���ת��ΪObject[]:
		 * 
		 * Object[] objs = table;
		 * 
		 * �����ܹ���ס����Ԫ�����ͣ������ͼ����һ���������͵�Ԫ�أ��ͻ��׳�ArrayStoreException�쳣��
		 * 
		 * objs[0] = "hello"; �� objs[0] = new Pair<Double>();
		 * 
		 * ���ܹ�ͨ������ģ�����ͨ������洢�ļ�⣬����Ȼ�ᵼ�����ʹ�����˽�ֹʹ�ò��������͵����顣
		 */
		List<Pair<String>> list = new ArrayList<Pair<String>>();
		list.add(new Pair<String>());
		// ����������б����
		// list.add("string");
		// list.add(new Pair<Double>());
	}
	
	/**
	 * 5���������͵�ʵ����
	 * <p>
	 * ����ʵ������������(����new T()���췽ʽ)������ͨ������Class.newInstance��
	 * Array.newInstance�������������÷��乹�췺�Ͷ���ͷ������顣
	 */
	private static void testGenericInstance() {
		
		class Pair2<T> {
			
			private T first;
			private T[] second;

			@SuppressWarnings("unchecked")
			public Pair2(T t) {
				/*
				 * ����������б����
				 * 
				 * ���Ͳ�����T�ı��Object�����ұ���϶���ϣ������new Object(); 
				 * ���Ƶģ����ܽ���һ���������飺T[] second = new T[2]; 
				 * ���Ͳ������÷������ǹ���һ��Object[2]���顣
				 */
				// first = new T();
				// second[] = new T[2];
				try {
					// ͨ������Class.newInstance��Array.newInstance����
					first = (T) (t.getClass().newInstance());
					second = (T[]) Array.newInstance(t.getClass(), 2);
					System.out.println("Pair2<T>.first class = "
							+ first.getClass());
					System.out.println("Pair2<T>.second class = "
							+ second.getClass());
					System.out.println("Pair2<T>.second length = "
							+ second.length);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		new Pair2<String>(new String());
	}
	
	/**
	 * 6����̬������
	 * <p>
	 * �����ھ�̬�ֶλ򷽷����������ͱ���(����)��
	 */
	private static void testStatic() {
		
		class Singleton<T> {
			// ����������б����
//			private static T instance;
			// ����������б����
//			public static T getInstance() {
//				return instance;
//			}
		}
		new Singleton<String>();
	}
}