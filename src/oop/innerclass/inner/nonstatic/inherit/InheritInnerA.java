/**
 * 
 */
package inner.nonstatic.inherit;

/**
 * �ڲ���ļ̳з�ʽ֮һ
 * <p>
 * ����½������ڲ�����ⲿ�಻�Ǹ��ڲ�����ⲿ������࣬�������ڲ��಻����һ���ڲ������һ��һ�����ʱ��
 * �����ڲ���ͨ��super���ù��췽����ʱ������ṩһ�����ڲ����ⲿ���������á�
 * <p>
 * <strong>�ڲ���̳лᵼ�½ṹ���Ҳ��׶���Ӧ�����������</strong>
 * 
 * @author ����ΰ
 *
 * �������ڣ�2007-8-6
 */
public class InheritInnerA extends Outer.Inner {
	
	/**
	 * ���췽������ֻ�Ǵ���һ��ָ���ⲿ����������
	 * �������ڹ��췽����ʹ�ã�XXX.super();(ȱʡ���췽������᲻��ͨ��)
	 */ 
	InheritInnerA(Outer o) {
		o.super();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Outer o = new Outer();
		InheritInnerA ii = new InheritInnerA(o);
		System.out.println(ii);
	}
}