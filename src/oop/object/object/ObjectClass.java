/**
 * 
 */
package object;

/**
 * Object�෽��ʾ��
 * 
 * @author ����ΰ
 *
 * �������ڣ�2007-11-9
 */
public class ObjectClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Object obj = new Object();
		// ���ض��������ʱ��
		System.out.println(obj.getClass());
		// ���ظö�����ַ�����ʾ(Ϊ��ȫ·��+@+16����hashCode)
		System.out.println(obj.toString());
		// toString()��ʽ�淶��
		// ������֣������һ�Է���������������ֵ��
		// �磺getClass().getName() + "[name=" + name + ",age=" + age + "]";
	}
}