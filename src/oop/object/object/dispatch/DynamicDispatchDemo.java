/**
 * 
 */
package object.dispatch;

/**
 * ��̬������ʾ
 * <p>
 * Javaͨ����������(override)֧�ֶ�̬���ɡ�
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2010-6-11
 */
public class DynamicDispatchDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "abc";
		Object o = "abc";
		// ����o�ľ�̬������Object�����ǵ���equals()����ʱ�����ǵ���������ʵ����String��equals()����
		System.out.println("o.equals(s)? " + o.equals(s));
	}
}