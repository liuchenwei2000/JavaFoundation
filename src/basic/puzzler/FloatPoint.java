/**
 * 
 */
package puzzler;

import java.math.BigDecimal;

/**
 * �������ı�ʾ�ͼ���
 * <p>
 * ע��������(float��double���ܽ���%����)
 * 
 * @author ����ΰ
 *
 * �������ڣ�2007-11-6
 */
public class FloatPoint {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double a = 2;
		double b = 1.1;
		double result = a - b;
		/*
		 * �����2.0 - 1.1 = 0.8999999999999999
		 * Java�Ը������ı�ʾ�����㲻�Ǻܾ�ȷ�����Զ���ĳЩ������������ֲ�����Ľ����
		 */
		System.out.println(a + " - " + b + " = " + result);
		
		/** ������� */
		/*
		 * �����2.0 - 1.1 = 0.9
		 * �������������BigDecimal�����������������ҹ��측���������ʱ��
		 * ֻ��BigDecimal(String)������췽����������BigDecimal(double)��
		 */
		BigDecimal aa = new BigDecimal(a + "");
		BigDecimal bb = new BigDecimal(b + "");
		result = aa.subtract(bb).doubleValue();
		System.out.println(a + " - " + b + " = " + result);
	}
}