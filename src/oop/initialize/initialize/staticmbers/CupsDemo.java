/**
 * 
 */
package initialize.staticmbers;

/**
 * ��ʾ��
 * 
 * @author ����ΰ
 *
 * �������ڣ�2007-8-28
 */
public class CupsDemo {
	
	// static Cups x=new Cups();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Inside main()");
		Cups.c1.f(99);
		// ��Ϊ�ڳ�ʼ�������д���������Cup����
		System.out.println("��ǰ����Cup�������� " + Cup.getCounter());
		// ���Ϊ��
		// Inside main()
		// Cup(1)
		// Cup(2)
		// f(99)
		// ��ǰ����Cup�������� 2
	}
}