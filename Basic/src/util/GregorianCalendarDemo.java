/**
 * 
 */
package util;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * 标准阳历类的基本方法
 * <p>
 * GregorianCalendar是Calendar的一个具体子类，提供了世界上大多数国家使用的标准日历系统。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2007-8-28
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
		// 输出日期
		System.out.print("Date : ");
		System.out.print(months[gcalendar.get(Calendar.MONTH)]);
		System.out.print("  " + gcalendar.get(Calendar.DATE));
		System.out.print("  " + year);
		System.out.println();
		// 输出时间
		System.out.print("Time : ");
		System.out.print(gcalendar.get(Calendar.HOUR) + ":");
		System.out.print(gcalendar.get(Calendar.MINUTE) + ":");
		System.out.print(gcalendar.get(Calendar.SECOND));
		System.out.println();
		// 判断是否是闰年
		if (gcalendar.isLeapYear(year)) {
			System.out.println(year + " is a leap year.");
		} else {
			System.out.println(year + " is not a leap year.");
		}
	}
}
