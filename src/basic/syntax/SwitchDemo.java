/**
 * 
 */
package syntax;

/**
 * switch���Ŀ�������
 * <p>
 * switch��Ĳ���ֻ����byte,short,char,int����ذ�װ��(Integer��)�Լ�ö�����͡�
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2007-9-10
 */
public class SwitchDemo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int month = 2;
		int year = 2000;
		int numDays = 0;

		switch (month) {
		// switch��佫��ƥ��ֵ��case��ǩ��ʼִ��ֱ������break��䣬����ִ�е�switch���Ľ�����Ϊֹ
		// ���û��ƥ���case��ǩ������default�Ӿ�Ļ�����ִ������Ӿ�
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			numDays = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			numDays = 30;
			break;
		case 2:
			numDays = isLeapYear(year) ? 29 : 28;
			break;
		// �����е�case����ƥ��ʱִ��default
		default:
			System.out.println("Invalid month.");
			// �����break����ʡ�ԣ���Ϊ����ִ�е��˾�����switch����
			break;
		}
		System.out.println("Number of Days = " + numDays);
	}
	
	/**
	 * �жϲ�������Ƿ�������
	 * 
	 * @param year
	 *            ���
	 */
	private static boolean isLeapYear(int year) {
		return ((year % 4 == 0) && !(year % 100 == 0)) || (year % 400 == 0);
	}
}