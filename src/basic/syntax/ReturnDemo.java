/**
 * 
 */
package syntax;

/**
 * return�ؼ���ʾ��
 * <p>
 * return���������ã�
 * <li>1��ָ��һ����������ʲôֵ(void�ͷ�void)
 * <li>2�����µ�ǰ�����˳��������Ǹ�ֵ</br>
 * 
 * �����void������û��return������ڸ÷����Ľ�β������һ����ʽ��return��
 * ������ǰ�˳�ĳ��void��������ʹ��return��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2007-9-11
 */
public class ReturnDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
		invokeSearch(a, 4);
	}

	/**
	 * ����search����
	 */
	private static void invokeSearch(int a[], int n) {
		System.out.println("before invoking search()");
		search(a, n);
		System.out.println("after invoking search()");
	}

	private static void search(int a[], int n) {
		if (a.length == 0)
			return;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == n) {
				System.out.println("find index = " + i);
				return;
			}
		}
	}
}