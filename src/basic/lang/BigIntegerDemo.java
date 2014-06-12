package lang;

import java.math.BigInteger;

/**
 * BigInteger演示类
 * <p>
 * 浮点数值不适用于禁止出现舍入误差的金融计算中，因为浮点数值采用二进制系统表示，
 * 而在二进制系统中无法精确的表示分数1/10，就像十进制无法精确表示1/3一样。
 * 如果使用基本的int和double不能够满足需要的话，可以使用BigInteger和BigDecimal类处理超大数据，
 * 它们可以处理任意长度的数值实现任意精度的运算。
 * <p>
 * BigDecimal类和BigInteger类用法基本相同
 * 
 * @author 刘晨伟
 *
 * 创建日期：2009-6-5
 */
public class BigIntegerDemo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 运算(12345678987654321 + 1) * 2
		BigInteger a = new BigInteger("12345678987654321");
		BigInteger result = a.add(BigInteger.valueOf(1)).multiply(
				BigInteger.valueOf(2));
		System.out.println("(12345678987654321 + 1) * 2 = " + result);
		// 运算(12345678987654321 - 1 ) / 2
		result = a.subtract(BigInteger.valueOf(1))
				.divide(BigInteger.valueOf(2));
		System.out.println("(12345678987654321 - 1) / 2 = " + result);
		// 运算12345678987654321 mod 11
		result = a.mod(BigInteger.valueOf(11));
		System.out.println("12345678987654321 mod 11 = " + result);
		// 比较两个BigInteger的大小
		BigInteger b = new BigInteger("123456789876543210");
		if (a.compareTo(b) >= 0) {
			System.out.println(a + " >= " + b);
		} else {
			System.out.println(a + " < " + b);
		}
	}
}