/**
 * 
 */
package util;

import java.util.Date;

/**
 * Date��Ļ������� 
 * <p>
 * Date��ĺܶ෽�����ڶ��Ѿ��� Calendar ��� DateFormat ��ķ���ȡ����
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2007-8-28
 */
public class DateDemo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// ����Date���󲢳�ʼ���˶����Ա�ʾ��������ʱ��(��ȷ������) date
		Date date = new Date();
		System.out.println(date);
		// ������1970��1��1��00:00:00GMT������Date�����ʾ�ĺ�����
		long msed = date.getTime();
		System.out.println("Milliseconds since Jan.1,1970 GMT = " + msed);
	}
}