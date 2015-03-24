/**
 * 
 */
package inner;

/**
 * �ڲ����.this��.new�﷨
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2008-4-13
 */
public class InnerClassSyntax {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DotThis dt = new DotThis();
		DotThis.Inner dti = dt.getInner();
		dti.getOuter().f();
		
		DotNew dn = new DotNew();
		@SuppressWarnings("unused")
		// ���봴��ĳ���ڲ���Ķ��󣬱�����new���ʽ���ṩ�����ⲿ���������ã�Ҳ����outer.new��
		// ��ӵ���ⲿ�����֮ǰ�ǲ��ܴ����ڲ������ģ���Ϊ�ڲ������ᰵ�������ӵ����������ⲿ������ϡ�
		// ���������������Ƕ���ࣨ��̬�ڲ��ࣩ�Ͳ���Ҫ���ⲿ���������á�
		DotNew.Inner dni = dn.new Inner();
	}
}

class DotThis {
	
	void f() {
		System.out.println("DotThis.f()");
	}

	public class Inner {
		/**
		 * �����Ҫ���ɶ��ⲿ���������ã�����ʹ���ⲿ��.this����� ��
		 * ���������������Զ��ؾ�����ȷ�����͡�������ڱ����ھͱ����ģ�û���κ����п�����
		 */
		public DotThis getOuter() {
			return DotThis.this;
			// ���ֻ��this���᷵��Inner�Ķ���
		}
	}

	public Inner getInner() {
		return new Inner();
	}
}

class DotNew {
	
	public class Inner {
	}
}