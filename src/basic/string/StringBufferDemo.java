/**
 * 
 */
package string;

/**
 * String��StringBuffer������
 * <p>
 * String: 
 * ����������String�����е��ַ����Ĳ��ɸı� �� ��ζ��Stringʵ��һ�������� �������ݽ����ܱ��ı䣬
 * Ȼ��������ΪString���õı������Ա��ı䣬��ָ���������ַ�������
 * <p>
 * StringBuffer: 
 * ��ʾ�ɱ䳤�ĺͿ�д���ַ������С�
 * <p>
 * ʹ������: 
 * �����ַ������޸ıȽ�Ƶ����ʱ��(������forѭ����)�� ʹ��StringBuffer��StringЧ��Ҫ�ߡ�
 * <p>
 * StringBuffer��StringBuilder�ķ���һ�㶼�����Ƶģ� ���������ʾ�����Բο�StringBuilderDemo�ࡣ
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2007-8-28
 */
public class StringBufferDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// a����ַ������󱻴����ҷ����ڴ�,�Ժ󲻿ɸı�.s��ָ��a��һ������.
		String s = "a";
		// b����ַ������󱻴����ҷ����ڴ�,�Ժ󲻿ɸı�.s����ָ��b
		s = "b";
		StringBuffer sb = new StringBuffer();
		sb.append("a");// ����һ��StingBuffer���󲢷����ڴ�,��a׷�ӵ����ڴ���
		sb.append("b");// ��b׷�ӵ����ڴ���
		System.out.println("String = " + s);
		System.out.println("StringBuffer = " + sb);
	}
}