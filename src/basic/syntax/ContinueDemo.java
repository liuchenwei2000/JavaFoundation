/**
 * 
 */
package syntax;

/**
 * continue��ʾ��
 * <p>
 * �ޱ�ǩ��continue��
 * �������ڲ�ѭ����continue֮�����䣬ֱ���ж�booleanֵ�����Ƿ����ѭ����</br>
 * �б�ǩ��continue��
 * ֱ��������ǩ�����ѭ������ʼλ��
 * <p>
 * continueҲ���Ժ��ܻᱻִ�е�finally���һ�����ʹ��
 * ����Java���û�б�Ҫʹ��goto�����
 * 
 * @author ����ΰ
 *
 * �������ڣ�2007-9-11
 */
public class ContinueDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String searchMe = "Look for a substring in me";
		String substring = "sub";
		boolean foundIt = false;

		int max = searchMe.length() - substring.length();

		test: for (int i = 0; i <= max; i++) {
			int n = substring.length();
			int j = i;
			int k = 0;
			while (n-- != 0) {
				if (searchMe.charAt(j++) != substring.charAt(k++)) {
					// ����continue������whileѭ����ʼ��
					continue test;
				}
			}
			foundIt = true;
			break test;
		}
		System.out.println(foundIt ? "Found it" : "Didn't find it");
	}
}