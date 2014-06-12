/**
 * 
 */
package inner.use;

/**
 * �ڲ��������ؼ̳�(�ӿ�)��ʾ
 * <p>
 * ������⣺</br>
 * ������һ��������ĳ�ַ�ʽʵ�������ӿڡ�
 * <li>�������1��ʹ�õ�һ��
 * <li>�������2��ʹ���ڲ���
 * 
 * @author ����ΰ
 *
 * �������ڣ�2008-4-16
 */
public class InheritMultiInterfaces {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		X x = new X();
		Y y = new Y();
		takesA(x);
		takesB(x);
		takesA(y);
		takesB(y.makeB());
	}

	private static void takesA(A a) {
	}

	private static void takesB(B a) {
	}
}

interface A {
}

interface B {
}

/**
 * ʹ�õ�һ����ʵ�������ӿ�
 */
class X implements A, B {
}

/**
 * ʹ���ڲ������ﵽһ����ʵ�������ӿڵ�Ŀ��
 */
class Y implements A {
	
	B makeB() {
		// �����ڲ���ʵ����B�ӿ�
		return new B() {
		};
	}
}