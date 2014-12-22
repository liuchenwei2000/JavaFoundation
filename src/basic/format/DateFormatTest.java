/**
 * 
 */
package format;

import java.util.Date;

/**
 * ����ʱ���ʽ��ʾ��
 * <p>
 * ��ʽ������ʱ���ת������t�����滹���Ը�����ת������
c	���������ں�ʱ��	Mon Veb 09 18:05:19 PST 2004
F	ISO 8601����		2004-02-09
D	������ʽ���ڣ���/��/�꣩02/09/2004
T	24Сʱʱ��		18:05:19
r	12Сʱʱ��		06:05:19 PM
R	24Сʱʱ��û����	18:05
Y	4λ���ֵ��꣨ǰ�油0��	2004
m	��λ���ֵ��£�ǰ�油0��	02
d	��λ���ֵ��գ�ǰ�油0��	09
H	��λ���ֵ�Сʱ��ǰ�油0��23
M	��λ���ֵķ��ӣ�ǰ�油0��05
S	��λ���ֵ����ӣ�ǰ�油0��59
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014��12��22��
 */
public class DateFormatTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Date date = new Date();
		// c	���������ں�ʱ��
		System.out.printf("���������ں�ʱ��=%tc %n", date);
		// F	ISO 8601����
		System.out.printf("ISO 8601����=%tF %n", date);
		// D	������ʽ���ڣ���/��/�꣩
		System.out.printf("������ʽ���ڣ���/��/�꣩=%tD %n", date);
		// T	24Сʱʱ��
		System.out.printf("24Сʱʱ��=%tT %n", date);
		// r	12Сʱʱ��
		System.out.printf("12Сʱʱ��=%tr %n", date);
		// R	24Сʱʱ��û����
		System.out.printf("24Сʱʱ��û����=%tR %n", date);
		// Y	4λ���ֵ��꣨ǰ�油0��
		System.out.printf("4λ���ֵ��꣨ǰ�油0��=%tY %n", date);
		// m	��λ���ֵ��£�ǰ�油0��
		System.out.printf("��λ���ֵ��£�ǰ�油0��=%tm %n", date);
		// d	��λ���ֵ��գ�ǰ�油0��
		System.out.printf("��λ���ֵ��գ�ǰ�油0��=%td %n", date);
		// H	��λ���ֵ�Сʱ��ǰ�油0��
		System.out.printf("��λ���ֵ�Сʱ��ǰ�油0��=%tH %n", date);
		// M	��λ���ֵķ��ӣ�ǰ�油0��
		System.out.printf("��λ���ֵķ��ӣ�ǰ�油0��=%tM %n", date);
		// S	��λ���ֵ����ӣ�ǰ�油0��
		System.out.printf("��λ���ֵ����ӣ�ǰ�油0��=%tS %n", date);
		// ���� 2014-12-22 14:47:51
		System.out.printf("%tF %tT", date, date);
	}
}
