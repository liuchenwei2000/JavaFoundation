/**
 * 
 */
package generic;

/**
 * ������ʾ��
 * 
 * @author ����ΰ
 *
 * �������ڣ�2007-9-14
 */
public class GenericTypeDemo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int i = 5;
		Integer[] ia = { 1, 2, 3, 4, 5, 6, 7 };
		// ����ʵ��ʱ��Ҫָ�����͵ľ��������Ա��ڱ�����
		GenericType<Integer> gt1 = new GenericType<Integer>();
		gt1.set(i);
		System.out.println(gt1.get());
		GenericType.print(ia);
		gt1.testNumber(i);

		String s = "String";
		String[] sa = { "a", "b", "c", "d", "e" };
		GenericType<String> gt2 = new GenericType<String>();
		gt2.set(s);
		System.out.println(gt2.get());
		GenericType.print(sa);
		gt2.test(i);
		gt2.testComparable(s);
		gt2.testNumberAndComparable(i);
	}
}

/**
 * GenericType<T,T>���ֱ�﷽ʽ�ǲ��Եģ�������Ҫ��������������Ҫ����GenericType<T,U>��
 */
class GenericType<T> {
	
	private T t;

	public void set(T t) {
		this.t = t;
	}

	public T get() {
		return t;
	}

	/*
	 * public static void print(T[] t){
	 * 	// T���ܺͷǷ��;�̬����һ��ʹ��(��Ϊ���Ǻ�ʵ����ص�)
	 * 	}
	 */
	
	/**
	 * ��������(��֧�ֻ�������)
	 */
	public static <T> void print(T[] t) {
		for (T item : t) {
			System.out.print(item + " ");
		}
		System.out.println();
	}
	
	/**
	 * ����Ҳ���Զ��岢ʹ�÷���
	 * <p>
	 * U���Զ������һ�����ͣ�������T
	 */
	public <U> void test(U u) {
		System.out.println("T : " + t.getClass().getName());
		System.out.println("U : " + u.getClass().getName());
	}
	
	/**
	 * �����趨���Ͱ�ĳһ����(�ӿ�)ʹ����ֻ���ܸ����ͻ��������ࡣ</br>
	 * Ҳ��������������ʱ��������Ͱ��磺</br>
	 * public class GenericsType<T extends String>
	 */
	public <U extends Number> void testNumber(U u) {
		System.out.println("U extends Number : " + u.getClass().getSimpleName());
	}
	
	/**
	 * ʵ��ĳ���ӿ�ҲҪ�ùؼ���extends������implements</br>
	 * ͬ��Ҳ��������������ʱ��������Ͱ󶨵��ӿڡ�
	 */
	public <U extends Comparable<?>> void testComparable(U u) {
		System.out.println("U extends Comparable : " + u.getClass().getSimpleName());
	}
	
	/**
	 * Ҳ����ͬʱ�̳�һ�����һ���ӿڣ���'&'�������ӡ�
	 */
	public <U extends Number & Comparable<?>> void testNumberAndComparable(U u) {
		System.out.println("U extends Number & Comparable : " + u.getClass().getSimpleName());
	}
}