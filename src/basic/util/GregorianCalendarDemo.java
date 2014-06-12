/**
 * 
 */
package util;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * ��׼������Ļ�������
 * <p>
 * GregorianCalendar��Calendar��һ���������࣬�ṩ�������ϴ��������ʹ�õı�׼����ϵͳ��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2007-8-28
 */
public class GregorianCalendarDemo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String months[] = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul",
				"Aug", "Sep", "Oct", "Nov", "Dec" };
		GregorianCalendar gcalendar = new GregorianCalendar();
		int year = gcalendar.get(Calendar.YEAR);
		// �������
		System.out.print("Date : ");
		System.out.print(months[gcalendar.get(Calendar.MONTH)]);
		System.out.print("  " + gcalendar.get(Calendar.DATE));
		System.out.print("  " + year);
		System.out.println();
		// ���ʱ��
		System.out.print("Time : ");
		System.out.print(gcalendar.get(Calendar.HOUR) + ":");
		System.out.print(gcalendar.get(Calendar.MINUTE) + ":");
		System.out.print(gcalendar.get(Calendar.SECOND));
		System.out.println();
		// �ж��Ƿ�������
		if (gcalendar.isLeapYear(year))
			System.out.println(year + " is a leap year.");
		else
			System.out.println(year + " is not a leap year.");
	}
}