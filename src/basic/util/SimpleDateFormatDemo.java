/**
 * 
 */
package util;

import java.text.*;
import java.util.*;

/**
 * SimpleDateFormat类的基本方法
 * <p>
 * 可以选择任何用户定义的日期-时间格式的模式，父类是DateFormat。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2007-8-28
 */
public class SimpleDateFormatDemo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat sdf;
		sdf = new SimpleDateFormat("hh:mm:ss");// 自定义显示时间模式
		System.out.println(sdf.format(date));
		sdf = new SimpleDateFormat("dd MM yyyy hh:mm:ss zzz");// 自定义显示模式
		System.out.println(sdf.format(date));
		sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSSS");// 自定义显示模式
		System.out.println(sdf.format(date));
		sdf = new SimpleDateFormat("E MM dd yyyy");// 自定义显示模式
		System.out.println(sdf.format(date));
	}
}