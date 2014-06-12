/**
 * 
 */
package util;

import java.util.Calendar;

/**
 * ������Ļ������� 
 * <p>
 * ע��Calendar����һ�������� ��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2007-8-28
 */
public class CalendarDemo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String months[] = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul",
				"Aug", "Sep", "Oct", "Nov", "Dec" };
		Calendar calendar = Calendar.getInstance();// ʹ��Ĭ��ʱ�������Ի������һ������
		// �������
		System.out.print("Date : ");
		int monthID = Calendar.MONTH;// ָʾ�·ݵ�get��set���ֶ�����(��YEAR=1,MONTH=2)
		int month = calendar.get(monthID);// ���ظ��������ֶε�ֵ(��һ��=0������=1)
		System.out.print(months[month]);
		System.out.print("  " + calendar.get(Calendar.DATE));
		System.out.print("  " + calendar.get(Calendar.YEAR));
		System.out.println();
		// ���ʱ��
		System.out.print("Time : ");
		System.out.print(calendar.get(Calendar.HOUR) + ":");
		System.out.print(calendar.get(Calendar.MINUTE) + ":");
		System.out.print(calendar.get(Calendar.SECOND));
		System.out.println();
		// ����ʱ��
		calendar.set(Calendar.HOUR, 11);// �������������ֶ�����Ϊ����ֵ
		calendar.set(Calendar.MINUTE, 11);
		calendar.set(Calendar.SECOND, 11);
		System.out.print("Updated time : ");
		System.out.print(calendar.get(Calendar.HOUR) + ":");
		System.out.print(calendar.get(Calendar.MINUTE) + ":");
		System.out.print(calendar.get(Calendar.SECOND));
		System.out.println();
	}
}