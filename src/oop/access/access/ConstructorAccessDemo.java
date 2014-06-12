/**
 * 
 */
package access;

/**
 * ������������ʾ
 * <p>
 * �����ķ��ʿ��Ʒ����α�ʾ����Ŀɼ��ԣ��๹�����ķ��ʿ��Ʒ���ʾ�ù������Ŀɼ��ԡ�
 * 
 * @author ����ΰ
 *
 * �������ڣ�2009-7-13
 */
public class ConstructorAccessDemo {

	/**
	 * ��ӡ���£� 
	 * Class PrivateClass is : private 
	 * Constructor PrivateClass() is : public
	 * 
	 * Class ProtectedClass is : protected 
	 * Constructor ProtectedClass() is : public
	 * 
	 * Class DefaultClass is : default 
	 * Constructor DefaultClass() is : public
	 * 
	 * Class PublicClass is : public 
	 * Constructor PublicClass() is : private
	 */
	public static void main(String[] args) {
		ModifierPrinter.printModifier(PrivateClass.class);
		ModifierPrinter.printModifier(ProtectedClass.class);
		ModifierPrinter.printModifier(DefaultClass.class);
		ModifierPrinter.printModifier(PublicClass.class);
	}

	/**
	 * ֻ�б���(ConstructorAccessDemo)����ʹ��PrivateClass��
	 * ���Ծ���PrivateClass���������η���public�������ڷǱ������Ҳ�ǲ��ɼ��ġ�
	 */
	private class PrivateClass {
		@SuppressWarnings("unused")
		public PrivateClass(){}
	}

	/**
	 * ͬ������߷�ͬ������(ConstructorAccessDemo)�������ʹ��ProtectedClass��
	 * ���Խ��乹��������Ϊpublic����������ͬ�����ʹ��û��ʲôӰ�죬����new ProtectedClass()��
	 * ���Ƕ��ڷ�ͬ��������˵�������ζ�������ʹ��new ProtectedClass()������ʵ����
	 * �������public���Σ���ʹ��Ĭ�ϵ����η�(���������η�)�����ι�������
	 * ��ô��ͬ������Ͳ��ܵ���new ProtectedClass()������ʵ���ˡ�
	 */
	protected class ProtectedClass {
		public ProtectedClass(){}
	}

	/**
	 * ֻ��ͬ�������ʹ��DefaultClass�����Խ��乹��������Ϊpublic��Ĭ�ϵ�default��һ����Ч����
	 */
	class DefaultClass {
		public DefaultClass(){}
	}
	
	/**
	 * ���е��඼����ʹ��PublicClass�����Խ����乹��������Ϊprivate
	 * ��ζ�ŷǱ��಻����ʹ��new������PublicClassʵ����
	 */
	public class PublicClass {
		private PublicClass(){}
	}
}