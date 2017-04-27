/**
 * 
 */
package util;

import java.util.Calendar;

/**
 * 日历类的基本方法 
 * <p>
 * 注：Calendar类是一个抽象类。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2007-8-28
 */
public class CalendarDemo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String months[] = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul",
				"Aug", "Sep", "Oct", "Nov", "Dec" };
		Calendar calendar = Calendar.getInstance();// 使用默认时区和语言环境获得一个日历
		// 输出日期
		System.out.print("Date : ");
		int monthID = Calendar.MONTH;// 指示月份的get和set的字段数字(如YEAR=1,MONTH=2)
		int month = calendar.get(monthID);// 返回给定日历字段的值(如一月=0，二月=1)
		System.out.print(months[month]);
		System.out.print("  " + calendar.get(Calendar.DATE));
		System.out.print("  " + calendar.get(Calendar.YEAR));
		System.out.println();
		// 输出时间
		System.out.print("Time : ");
		System.out.print(calendar.get(Calendar.HOUR) + ":");
		System.out.print(calendar.get(Calendar.MINUTE) + ":");
		System.out.print(calendar.get(Calendar.SECOND));
		System.out.println();
		// 自设时间
		calendar.set(Calendar.HOUR, 11);// 将给定的日历字段设置为给定值
		calendar.set(Calendar.MINUTE, 11);
		calendar.set(Calendar.SECOND, 11);
		System.out.print("Updated time : ");
		System.out.print(calendar.get(Calendar.HOUR) + ":");
		System.out.print(calendar.get(Calendar.MINUTE) + ":");
		System.out.print(calendar.get(Calendar.SECOND));
		System.out.println();
	}
}
