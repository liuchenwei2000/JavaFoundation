/**
 * 
 */
package util;

import java.util.*;
import java.text.*;

/**
 * DateFormat类的基本方法 
 * <p>
 * 提供了格式化和解析日期和时间功能的抽象类。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2007-8-28
 */
public class DateFormatDemo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Date date = new Date();
		DateFormat df;
		/*
		 * getDateInstance()方法 
		 * 返回一个DateFormat类的实例 ，这个对象可以格式化日期信息。
		 * 
		 * getDateInstance(int Style,Locale locale) 
		 * Style代表日期显示的不同方式，locale代表显示日期所用的国家语言
		 */
		df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.FRANCE);
		System.out.println("FRANCE : " + df.format(date));
		df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.CANADA);
		System.out.println("CANADA : " + df.format(date));
		df = DateFormat.getDateInstance(DateFormat.FULL, Locale.CHINA);
		System.out.println("CHINA : " + df.format(date));
	}
}