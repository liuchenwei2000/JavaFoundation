/**
 * 
 */
package syntax;

/**
 * break��ʾ��
 * <p>
 * �ޱ�ǩ��break:
 * ֻ����ֹ���ڲ��switch��for��while��do-while��</br>
 * �б�ǩ��break:
 * ������ֹ��ǩ��������顣
 * <p>
 * breakҲ���Ժ��ܻᱻִ�е�finally���һ�����ʹ�ã�����Java���û�б�Ҫʹ��goto����ˡ�
 * 
 * @author ����ΰ
 *
 * �������ڣ�2007-9-11
 */
public class BreakDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] array = { { 32, 87, 3, 589 }, { 12, 1076, 2000, 8 },
				{ 622, 127, 77, 955 } };
		int searchfor = 12;

		int i;
		int j = 0;
		boolean foundIt = false;

		search: for (i = 0; i < array.length; i++) {
			for (j = 0; j < array[i].length; j++) {
				if (array[i][j] == searchfor) {
					foundIt = true;
					// ���� break; ��ֻ��ֹjѭ��
					break search;
				}
			}
		}

		if (foundIt) {
			System.out.println("Found " + searchfor + " at " + i + "," + j);
		} else {
			System.out.println(searchfor + " not in the array");
		}
	}
}