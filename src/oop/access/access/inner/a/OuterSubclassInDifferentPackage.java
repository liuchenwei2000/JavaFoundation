/**
 * 
 */
package access.inner.a;

import access.inner.Outer;

/**
 * �ڲ����������ķ��ʿ�����ʾ
 * 
 * @author ����ΰ
 *
 * �������ڣ�2009-7-13
 */
public class OuterSubclassInDifferentPackage extends Outer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Outer extend = new OuterSubclassInDifferentPackage();
		// Outer.ProtectedInner���������ǿɼ���
		// protected�ڲ������������ⲿ��ļ̳�
		Outer.ProtectedInner protectedIn = extend.getProtectedInner();
		// ֻ�ܷ���Outer.ProtectedInner��public��Ա�ͷ���
		// protected�ڲ���ķ����������ⲿ��ļ̳�
		protectedIn.publicField = 0;
		protectedIn.publicMethod();
	}
}