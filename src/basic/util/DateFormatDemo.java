/**
 * 
 */
package util;

import java.util.*;
import java.text.*;

/**
 * DateFormat��Ļ������� 
 * <p>
 * �ṩ�˸�ʽ���ͽ������ں�ʱ�书�ܵĳ����ࡣ
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2007-8-28
 */
public class DateFormatDemo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Date date = new Date();
		DateFormat df;
		/*
		 * getDateInstance()���� 
		 * ����һ��DateFormat���ʵ�� �����������Ը�ʽ��������Ϣ��
		 * 
		 * getDateInstance(int Style,Locale locale) 
		 * Style����������ʾ�Ĳ�ͬ��ʽ��locale������ʾ�������õĹ�������
		 */
		df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.FRANCE);
		System.out.println("FRANCE : " + df.format(date));
		df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.CANADA);
		System.out.println("CANADA : " + df.format(date));
		df = DateFormat.getDateInstance(DateFormat.FULL, Locale.CHINA);
		System.out.println("CHINA : " + df.format(date));
	}
}