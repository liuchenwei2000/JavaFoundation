/**
 * 
 */
package syntax;

/**
 * �ݹ���ʾ��
 * <p>
 * �ݹ��㷨��һ��Ҫ��
 * <li>1�������������if-else������switch���
 * <li>2��������һ����֧����еݹ����
 * <li>3��������һ����֧���û�еݹ����(ֹͣ����)
 *
 * @author ����ΰ
 *
 * �������ڣ�2008-3-21
 */
public class Recursion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 6;
		System.out.println(n + "!" + " = " + fatorial(n));
	}

	/**
	 * �׳˷������ݹ�ʵ��
	 */
	public static int fatorial(int n) {
		if (n == 0 || n == 1)
			return 1;
		else
			return n * fatorial(n - 1);
	}
}