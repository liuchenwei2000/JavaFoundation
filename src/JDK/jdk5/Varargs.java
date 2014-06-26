/**
 * 
 */
package jdk5;

/**
 * �����Ŀɱ������ʹ�������Խ��ܿɱ���Ŀ�Ĳ���
 * 
 * @author ����ΰ
 *
 * �������ڣ�2007-9-11
 */
public class Varargs<T> {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Varargs<Object> v = new Varargs<Object>();
		v.print("a", "b", "c", "d");
		Object[] s = { "e", "f", "g", "h" };
		v.print(s);
	}
	
	/**
	 * ��ʽ��method(type... param)
	 * 
	 * �ɱ���������Ǻ��������е����һ���������÷������Խ���������Ŀ(��0)��type���Ͳ�����
	 * ����Ҳ���Խ���type���͵�������Ϊ������
	 */
	private void print(T... objects) {
		// ʵ�����β�objects�������һ������
		for (int i = 0; i < objects.length; i++) {
			System.out.print(objects[i] + " ");
		}
		System.out.println();
	}
	
	// �ڷ������ع����У��������Դ������е�T...��T[]��һ����
//	private void print(T[] objects) {
//		// ...
//	}
}