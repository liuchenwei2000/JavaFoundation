/**
 * 
 */
package util;

import java.util.Date;

/**
 * Date类的基本方法 
 * <p>
 * Date类的很多方法现在都已经被 Calendar 类和 DateFormat 类的方法取代。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2007-8-28
 */
public class DateDemo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 分配Date对象并初始化此对象，以表示分配它的时间(精确到毫秒) date
		Date date = new Date();
		System.out.println(date);
		// 返回自1970年1月1日00:00:00GMT以来此Date对象表示的毫秒数
		long msed = date.getTime();
		System.out.println("Milliseconds since Jan.1,1970 GMT = " + msed);
	}
}