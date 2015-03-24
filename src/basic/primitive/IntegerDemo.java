/**
 * 
 */
package primitive;

/**
 * int包装类演示
 * <p>
 * 其他整数类型如short、byte和long的包装类的方法都相似
 * <p>
 * int型数据的字节长度为4，一共是32位(bit)。
 * 第一位用于表示正负号，其他位的数字组成它所代表的值。
 * int型数据的最大值，是除了第一位为0(表示正数)以外，其他位都是1的数，也就是 2<sup>31</sup>-1，最小值是-2<sup>31</sup>。
 * 
 * @author 刘晨伟
 *
 * 创建日期：2007-11-13
 */
public class IntegerDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * Integer.parseInt方法使用第二个参数指定的基数(默认为10)，将字符串参数解析为有符号的整数(原始类型)
		 * 参数字符串的第一个字符只能是数字或者是'-'(负号)，其他必须是指定基数的数字(如2为基数时只能用0和1)
		 * 否则会有NumberFormatException
		 */
		int i = Integer.parseInt("-101");
		System.out.print(i + " ");
		i = Integer.parseInt("-101", 2);
		System.out.print(i + " ");
		/*
		 * Integer.valueOf方法使用和perseInt方法相似，只不过返回的类型是一个包装类对象(即Integer)。
		 */
		Integer in = Integer.valueOf("-101");
		System.out.print(in + " ");
		in = Integer.valueOf("-101", 2);
		System.out.print(in + " ");
		/*
		 * Integer.toString方法用第二个参数指定的基数返回第一个参数的字符串表示形式
		 * 如果基数超过了[Character.MIN_RADIX,Character.MAX_RADIX]这个范围则改用10
		 */
		String s = Integer.toString(-101, 10);
		System.out.print(s + " ");
		s = Integer.toString(-5, 2);
		System.out.print(s + " ");
		/*
		 * Integer类还提供了将整数表示为二进制、八进制和十六进制字符串形式的方法
		 */
		s = Integer.toBinaryString(15);// 二进制
		System.out.print(s + " ");
		s = Integer.toOctalString(15);// 八进制
		System.out.print(s + " ");
		s = Integer.toHexString(15);// 十六进制
		System.out.print(s + " ");
	}
}