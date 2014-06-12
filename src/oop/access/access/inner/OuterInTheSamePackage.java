/**
 * 
 */
package access.inner;

/**
 * �ڲ���ͬ��������ķ��ʿ�����ʾ
 * 
 * @author ����ΰ
 *
 * �������ڣ�2009-7-13
 */
public class OuterInTheSamePackage {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	       Outer out = new Outer();
	       // ʹ�� new �ķ�ʽ�ò��� Outer.PrivateInner ��ʵ��
	       // ��ΪOuter.PrivateInner���ڱ����ǲ��ɼ���
	       // Outer.PrivateInner privateInner = out.new PrivateInner();
	       
	       // ʹ�� new �ķ�ʽ�õ� Outer.DefaultInner ��ʵ��
	       Outer.DefaultInner defaultInner = out.new DefaultInner();
	       // ���ǲ��ܹ�����DefaultInner��private��Ա��private����
	       // defaultInner.privateField = 0;
	       // defaultInner.privateMethod();
	       // ֻ���Է���DefaultInner�ķ�private���εĳ�Ա�ͷ�������ͻ�������Ȩ�޿�����һ�µ�
	       defaultInner.defaultField = 0;
	       defaultInner.defaultMethod();
	 
	       // ʹ���ⲿ�෽��getInnerInstance()Ҳ�޷��õ�Outer.PrivateInner ��ʵ��
	       // ��Ȼ���Ե���public getPrivateInner()�����������޷��õ�Outer.PrivateInner����
	       // Outer.PrivateInner privateInner2 = out.getPrivateInner();
	       
	       // ����ͨ���ӿڵ����÷��ʵ�private�ڲ����public����
	       // ͬ��ʹ��default��protected��public���ڲ�����󶼿��Է������public����
	       IAccessable privateInner = out.getPrivateInner();
	       privateInner.publicMethod();
	}
}