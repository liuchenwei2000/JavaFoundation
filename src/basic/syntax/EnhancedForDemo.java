/**
 * 
 */
package syntax;

/**
 * forѭ������һ�ֱ�����ʽ
 * 
 * @author ����ΰ
 *
 * �������ڣ�2007-9-10
 */
public class EnhancedForDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] n = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
		// �Ƽ��ı�����ʽ������item�洢����ĵ�ǰԪ��
		for (int item : n) {
			System.out.print(item + " ");
		}
	}
}