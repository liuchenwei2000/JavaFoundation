/**
 * 
 */
package puzzler;

/**
 * ĳ������finally��return���֮��Ŀ�������
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2008-5-5
 */
public class FinallyAfterReturn {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i = 1; i < 4; i++) {
			test(i);
		}
	}

	/**
	 * ��Ϊfinally�Ӿ��ܻᱻִ�У�������һ��������
	 * ���ԴӶ���㷵�أ����ҿ��Ա�֤��Ҫ���������Ծɻ�ִ��
	 */
	private static void test(int i) {
		try {
			System.out.println("in try : ");
			System.out.println(" i == 1");
			if (i == 1)
				return;
			System.out.println(" i == 2");
			if (i == 2)
				return;
			System.out.println(" i == 3");
			if (i == 3)
				return;
		} finally {
			System.out.println("in finally");
		}
	}
}