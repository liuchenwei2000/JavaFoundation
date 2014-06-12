/**
 * 
 */
package access;

/**
 * Ĭ��(�޲�)������������ʾ
 * <p>
 * ������ʾ�������Զ����ɵ�Ĭ�Ϲ������ķ��ʿ��Ʒ����������ʿ��Ʒ��Ĺ�ϵ��
 * 
 * @author ����ΰ
 *
 * �������ڣ�2009-7-13
 */
public class DefaultConstructorAccessDemo {

	/**
	 * ��ӡ���£� 
	 * Class PrivateClass is : private 
	 * Constructor PrivateClass() is : private
	 * 
	 * Class ProtectedClass is : protected 
	 * Constructor ProtectedClass() is : protected
	 * 
	 * Class DefaultClass is : default 
	 * Constructor DefaultClass() is : default
	 * 
	 * Class PublicClass is : public 
	 * Constructor PublicClass() is : public
	 */
	public static void main(String[] args) {
		ModifierPrinter.printModifier(PrivateClass.class);
		ModifierPrinter.printModifier(ProtectedClass.class);
		ModifierPrinter.printModifier(DefaultClass.class);
		ModifierPrinter.printModifier(PublicClass.class);
	}

	private class PrivateClass {
	}

	protected class ProtectedClass {
	}

	class DefaultClass {
	}

	public class PublicClass {
	}
}