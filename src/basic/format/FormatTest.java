/**
 * 
 */
package format;

/**
 * ��ʽ��ʾ��
 * <p>
 * Java5��ʼ֧�ָ�ʽ���ַ������ܣ�ÿһ����%�ַ���ʼ�ġ���ʽ˵��������������Ӧ�Ĳ����滻��
 * ��ʽ˵����β����ת������ָ������ʽ����ֵ���ͣ���f��ʾ��������s��ʾ�ַ�����
 * �� %s Ϊ����%�Ǹ�ʽ˵������s��ת������
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014��12��22��
 */
public class FormatTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.printf("Name is %s%nAge is %d%nGrade is %c%nPassed? %b%n", "Tom Green", 14, 'A', true);
		String formattedString = String.format("This is a %s", "book");
		// ����ʹ��String�ľ�̬��������һ����ʽ�����ַ�����
		System.out.println(formattedString);

		// ������ӡ����ʾ����%-12s�� - ��ʾ����루Ĭ���Ҷ��룩12��ʾ�ַ�������
		String format = "%-12s %-8s %4s %12s%n";
		System.out.printf(format, "Code", "Name", "Age", "Meesage");
		for (int i = 1; i < 10; i++) {
			System.out.printf(format, "Code" + i, "Name" + i, i + 20, "Meesage"
					+ i);
		}
	}
}
