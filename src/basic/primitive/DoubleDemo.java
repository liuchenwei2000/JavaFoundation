/**
 * 
 */
package primitive;

/**
 * double包装类演示
 * <p>
 * 其他浮点数类型如float的包装类的方法都相似
 * 
 * @author 刘晨伟
 *
 * 创建日期：2007-11-13
 */
public class DoubleDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * Double类中的常量NaN(Not a Number)表示不是一个数
		 * 这个常量用来获取一个NaN值，不是用来测试一个值是否是NaN
		 * 并且 NaN == NaN 一直返回false，因为NaN不是一个数
		 * 如果判断一个数是否是NaN应该使用isNaN方法
		 */
		Double d = 3.2;
		if (!d.isNaN())
			System.out.println(d + " is a number");
		if (Double.isNaN(0.0 / 0.0))
			System.out.println("0.0/0.0 is not a number");
		if (Double.NaN != Double.NaN)
			System.out.println("Double.NaN != Double.NaN");
		/*
		 * isInfinite方法用来判断一个double是否是无穷大
		 */
		d = 1.0 / 0.0;
		if (d.isInfinite())
			System.out.println("1.0 / 0.0 is infinite");
		if (Double.isInfinite(d))
			System.out.println("1.0 / 0.0 is infinite");
		/*
		 * intValue用来返回浮点数的整数值(相当于强行转换成int)
		 */
		d = 3.6;
		System.out.println(d.intValue());
		d = -3.6;
		System.out.println(d.intValue());
	}
}