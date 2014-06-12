/**
 * 
 */
package util;

import java.text.*;
import java.util.*;

/**
 * SimpleDateFormat��Ļ�������
 * <p>
 * ����ѡ���κ��û����������-ʱ���ʽ��ģʽ��������DateFormat��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2007-8-28
 */
public class SimpleDateFormatDemo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat sdf;
		sdf = new SimpleDateFormat("hh:mm:ss");// �Զ�����ʾʱ��ģʽ
		System.out.println(sdf.format(date));
		sdf = new SimpleDateFormat("dd MM yyyy hh:mm:ss zzz");// �Զ�����ʾģʽ
		System.out.println(sdf.format(date));
		sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSSS");// �Զ�����ʾģʽ
		System.out.println(sdf.format(date));
		sdf = new SimpleDateFormat("E MM dd yyyy");// �Զ�����ʾģʽ
		System.out.println(sdf.format(date));
	}
}