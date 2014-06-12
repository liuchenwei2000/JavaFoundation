package lang;

import java.math.BigInteger;

/**
 * BigInteger��ʾ��
 * <p>
 * ������ֵ�������ڽ�ֹ�����������Ľ��ڼ����У���Ϊ������ֵ���ö�����ϵͳ��ʾ��
 * ���ڶ�����ϵͳ���޷���ȷ�ı�ʾ����1/10������ʮ�����޷���ȷ��ʾ1/3һ����
 * ���ʹ�û�����int��double���ܹ�������Ҫ�Ļ�������ʹ��BigInteger��BigDecimal�ദ�������ݣ�
 * ���ǿ��Դ������ⳤ�ȵ���ֵʵ�����⾫�ȵ����㡣
 * <p>
 * BigDecimal���BigInteger���÷�������ͬ
 * 
 * @author ����ΰ
 *
 * �������ڣ�2009-6-5
 */
public class BigIntegerDemo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// ����(12345678987654321 + 1) * 2
		BigInteger a = new BigInteger("12345678987654321");
		BigInteger result = a.add(BigInteger.valueOf(1)).multiply(
				BigInteger.valueOf(2));
		System.out.println("(12345678987654321 + 1) * 2 = " + result);
		// ����(12345678987654321 - 1 ) / 2
		result = a.subtract(BigInteger.valueOf(1))
				.divide(BigInteger.valueOf(2));
		System.out.println("(12345678987654321 - 1) / 2 = " + result);
		// ����12345678987654321 mod 11
		result = a.mod(BigInteger.valueOf(11));
		System.out.println("12345678987654321 mod 11 = " + result);
		// �Ƚ�����BigInteger�Ĵ�С
		BigInteger b = new BigInteger("123456789876543210");
		if (a.compareTo(b) >= 0) {
			System.out.println(a + " >= " + b);
		} else {
			System.out.println(a + " < " + b);
		}
	}
}