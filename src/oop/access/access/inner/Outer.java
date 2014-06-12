/**
 * 
 */
package access.inner;

/**
 * �ⲿ��
 * <p>
 * ��Java�У�������һ���ڲ���Ķ���ʱ���˶��������������ⲿ����󱣳�����ϵ��
 * ��˸��ڲ��������Է������ⲿ���������г�Ա������private��Ա��
 * �����ڲ���������������Ķ���ķ��ʣ����ճ���ķ���Ȩ�޿��ơ�
 * <p>
 * ������Ҫ̽�ֵ��ǣ��ⲿ���Լ�������Ķ��������η��ʵ�ĳ���ڲ�����󣬼��ڲ���Ŀɼ������⡣
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2009-7-13
 */
@SuppressWarnings("unused")
public class Outer {

	/**
	 * ���ۣ�</br>
	 * һ���ڲ��࣬�����Ǻ��ַ���Ȩ�ޣ�����еĳ�Ա�ͷ���Ҳ�����Ǻ��ַ���Ȩ�ޣ�
	 * ���ⲿ����(ע�⣺���Ƕ���)��ʹ��ʱ�������ⲿ������������ȫ�ɼ��ġ�
	 */
	public static void main(String[] args) {
		Outer out = new Outer();
		// ����ͨ�����ַ�ʽ�����ڲ����ʵ����
		// 1��ʹ���ⲿ���� new һ���ڲ���ʵ��
		// ���Եõ� private �ڲ����ʵ�������ҿ��Է�������private��Ա��private����
		// ��Ȼdefault��protected��public�ĳ�Ա�ͷ���Ҳ�����Է���
		Outer.PrivateInner privateInner = out.new PrivateInner();
		privateInner.privateField = 0;
		privateInner.privateMethod();

		// 2��ʹ���ⲿ�෽��getInnerInstance()
		// Ҳ���Է��������ڲ�������г�Ա�ͷ���
		Outer.PrivateInner privateInner2 = out.getPrivateInner();
		privateInner2.privateField = 0;
		privateInner2.privateMethod();
	}

	/******************************************
	 * ���ⲿ�����ṩ�˵õ��ڲ���ʵ����public����
	 ******************************************/
	
	public PrivateInner getPrivateInner() {
		return new PrivateInner();
	}

	public DefaultInner getDefaultInner() {
		return new DefaultInner();
	}

	public ProtectedInner getProtectedInner() {
		return new ProtectedInner();
	}

	public PublicInner getPublicInner() {
		return new PublicInner();
	}

	/********************************************************************
	 * �����ĸ��ڲ���ֱ���в�ͬ�ķ���Ȩ�޿���(private,default,protected,public)
	 * ����ÿ���඼ʵ���˹��нӿ�IAccessable�����ڲ��������ĸ���ͬ����Ȩ�޵ĳ�Ա�ͷ���
	 ********************************************************************/
	
	/**
	 * private�ڲ���
	 */
	private class PrivateInner implements IAccessable {

		private int privateField;
		int defaultField;
		protected int protectedField;
		public int publicField;

		private void privateMethod() {
		}

		void defaultMethod() {
		}

		protected void protectedMethod() {
		}

		public void publicMethod() {
		}
	}

	/**
	 * default�ڲ���
	 */
	class DefaultInner implements IAccessable {

		private int privateField;
		int defaultField;
		protected int protectedField;
		public int publicField;

		private void privateMethod() {
		}

		void defaultMethod() {
		}

		protected void protectedMethod() {
		}

		public void publicMethod() {
		}
	}

	/**
	 * protected�ڲ���
	 */
	protected class ProtectedInner implements IAccessable {

		private int privateField;
		int defaultField;
		protected int protectedField;
		public int publicField;

		public ProtectedInner(){}
		
		private void privateMethod() {
		}

		void defaultMethod() {
		}

		protected void protectedMethod() {
		}

		public void publicMethod() {
		}
	}

	/**
	 * public�ڲ���
	 */
	public class PublicInner implements IAccessable {

		private int privateField;
		int defaultField;
		protected int protectedField;
		public int publicField;

		private void privateMethod() {
		}

		void defaultMethod() {
		}

		protected void protectedMethod() {
		}

		public void publicMethod() {
		}
	}
}