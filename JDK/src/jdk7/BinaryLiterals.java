/**
 * 
 */
package jdk7;

/**
 * 1，二进制字面值
 * <p>
 * Java7 中新增了以二进制形式的字面值表示方式，
 * 可以像使用十进制一样，方便地使用二进制形式的字面值来表示数值。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014年12月19日
 */
public class BinaryLiterals {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 二进制字面值以0b或0B开头，不区分大小写
		int anInt2 = 0B101;
		System.out.println(anInt2);
		// 一个8位的byte值：
		byte aByte = 0b100001;
		System.out.println(aByte);
		// 一个16位的short值：
		short aShort = 0b1010010100101;
		System.out.println(aShort);
		// 一个32位的int值：
		int anInt1 = 0b101000010100010110100101000101;
		System.out.println(anInt1);
		// 一个64位的long值(注意末尾的后缀L)
		long aLong = 0b101000010L;
		System.out.println(aLong);
	}
}
