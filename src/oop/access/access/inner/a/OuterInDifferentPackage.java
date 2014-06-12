/**
 * 
 */
package access.inner.a;

import access.inner.IAccessable;
import access.inner.Outer;

/**
 * �ڲ������������ķ��ʿ�����ʾ
 * 
 * @author ����ΰ
 *
 * �������ڣ�2009-7-13
 */
public class OuterInDifferentPackage {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Outer out = new Outer();
		// ֻ�ܷ���public�ڲ���
		Outer.PublicInner publicInner = out.new PublicInner();
		// ֻ�ܷ���public��Ա��public����
		publicInner.publicField = 0;
		publicInner.publicMethod();

		Outer.PublicInner publicInner2 = out.getPublicInner();
		publicInner2.publicField = 0;
		publicInner2.publicMethod();

		// ʹ�ýӿ���������Է��������ĸ��ڲ����public����
		IAccessable accessable;
		accessable = out.getPrivateInner();
		accessable.publicMethod();
		accessable = out.getDefaultInner();
		accessable.publicMethod();
		accessable = out.getProtectedInner();
		accessable.publicMethod();
		accessable = out.getPublicInner();
		accessable.publicMethod();
	}
}