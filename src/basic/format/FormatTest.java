/**
 * 
 */
package format;

import java.util.Formatter;

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
		// JavaSE5 ֧�ֵ����ָ�ʽ�������ʽ
		System.out.printf("Name is %s%nAge is %d%nGrade is %c%nPassed? %b%n", "Tom Green", 14, 'A', true);
		System.out.format("Name is %s%nAge is %d%nGrade is %c%nPassed? %b%n", "Tom Green", 14, 'A', true);
		
		// ����ʹ��String�ľ�̬��������һ����ʽ�����ַ�����
		String formatted = String.format("This is a %s", "book");
		System.out.println(formatted);

		// ������ӡ����ʾ����%-12s�� - ��ʾ����루Ĭ���Ҷ��룩12��ʾ�ַ�������
		String formatStr = "%-12s %-8s %4s %12s%n";
		System.out.printf(formatStr, "Code", "Name", "Age", "Meesage");
		for (int i = 1; i < 10; i++) {
			System.out.printf(formatStr, "Code" + i, "Name" + i, i + 20, "Meesage" + i);
		}
		
		// �����µĸ�ʽ�����ܶ��� Formatter �ദ��ʵ���� String.format()����Ҳ��ʹ�� Formatter ʵ�ֵġ�
		// ���Խ����Ŀ�ĵش��ݽ�ȥ������ PrintStream��OutputStream��File�ȣ�
		Formatter formatter = new Formatter(System.out);
		formatter.format("Formatted by %s", "Formatter");
		formatter.close();
	}
}
