/**
 * 
 */
package puzzler;

import java.math.BigDecimal;

/**
 * 浮点数的表示和计算
 * <p>
 * 注：浮点数(float和double不能进行%运算)
 * 
 * @author 刘晨伟
 *
 * 创建日期：2007-11-6
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
		 * 输出：2.0 - 1.1 = 0.8999999999999999
		 * Java对浮点数的表示和运算不是很精确，所以对于某些操作会产生这种不如意的结果。
		 */
		System.out.println(a + " - " + b + " = " + result);
		
		/** 解决方法 */
		/*
		 * 输出：2.0 - 1.1 = 0.9
		 * 解决方法就是用BigDecimal来描述浮点数，并且构造浮点数对象的时候。
		 * 只用BigDecimal(String)这个构造方法而不是用BigDecimal(double)。
		 */
		BigDecimal aa = new BigDecimal(a + "");
		BigDecimal bb = new BigDecimal(b + "");
		result = aa.subtract(bb).doubleValue();
		System.out.println(a + " - " + b + " = " + result);
	}
}