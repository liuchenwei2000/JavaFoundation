/**
 * 
 */
package inner.nonstatic.inherit;

/**
 * �ڲ���ļ̳з�ʽ֮��
 * <p>
 * <strong>�ڲ���̳лᵼ�½ṹ���Ҳ��׶���Ӧ�����������</strong>
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2007-11-12
 */
public class InheritInnerB extends Outer {
	
	class ExtendedInner extends Inner {

	}

	// ������ʹ�õ�һ���ⲿ����󱻴�����ʱ���ڲ�������ܹ���ʼ������Ϊ�ڲ��������Ҫ��һ���ⲿ�����
	Inner inner = new ExtendedInner();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InheritInnerB ii = new InheritInnerB();
		System.out.println(ii);
	}
}