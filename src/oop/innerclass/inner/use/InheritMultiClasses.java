/**
 * 
 */
package inner.use;

/**
 * �ڲ��������ؼ̳�(��)��ʾ
 * <p>
 * ������⣺</br>
 * ������һ��������ĳ�ַ�ʽ�̳������࣬�����Ļ���ֻ��ʹ���ڲ������ﵽ����ʵ�֡�
 * 
 * @author ����ΰ
 *
 * �������ڣ�2008-4-16
 */
public class InheritMultiClasses {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Z z = new Z();
		takesD(z);
		takesE(z.makeE());
	}

	private static void takesD(D d) {
	}

	private static void takesE(E e) {
	}
}

class D {
}

abstract class E {
}

class Z extends D {
	
	E makeE() {
		return new E() {
		};
	}
}