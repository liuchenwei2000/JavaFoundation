/**
 * 
 */
package jdk7;

/**
 * 1������������ֵ
 * <p>
 * Java SE 7���������Զ�������ʽ������ֵ��ʾ��ʽ��������ʹ��ʮ����һ���������ʹ�ö�������ʽ������ֵ����ʾ��ֵ��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014��12��19��
 */
public class BinaryLiterals {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// ����������ֵ��0b��0B��ͷ�������ִ�Сд
		int anInt2 = 0B101;
		System.out.println(anInt2);
		// һ��8λ��byteֵ��
		byte aByte = 0b100001;
		System.out.println(aByte);
		// һ��16λ��shortֵ��
		short aShort = 0b1010010100101;
		System.out.println(aShort);
		// һ��32λ��intֵ��
		int anInt1 = 0b101000010100010110100101000101;
		System.out.println(anInt1);
		// һ��64λ��longֵ(ע��ĩβ�ĺ�׺L)
		long aLong = 0b101000010L;
		System.out.println(aLong);
	}
}
