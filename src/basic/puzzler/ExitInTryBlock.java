/**
 * 
 */
package puzzler;

/**
 * ��try������System.exit(0)���ʱ�Ŀ�������ʾ��
 * 
 * @author ����ΰ
 *
 * �������ڣ�2007-11-7
 */
public class ExitInTryBlock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * System.exit(0)��������ֹͣһ���߳�Ȼ���Ƴ������ 
		 * ������������ȥִ��finally�е��κβ���
		 */
		try {
			System.out.println("Goodbye!");
			System.exit(0);
		} finally {
			System.out.println("finally");
		}
	}
}