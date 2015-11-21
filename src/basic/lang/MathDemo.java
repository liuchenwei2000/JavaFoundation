/**
 * 
 */
package lang;

/**
 * Math类的一般方法
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2007-8-28
 */
public class MathDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double a = -5.8;
		System.out.println(a + "的绝对值： " + Math.abs(a));
		double b = 2.5;
		System.out.println(b + "的四舍五入： " + Math.round(b));
		System.out.println(b + "的顶整数： " + Math.ceil(b));
		System.out.println(b + "的底整数： " + Math.floor(b));
		System.out.println(b + "的平方根： " + Math.sqrt(b));
		System.out.println(b + "的立方根： " + Math.cbrt(b));
		System.out.println(b + "的最接近的整数的double值： " + Math.rint(b));
		a = -1;
		b = 2;
		System.out.println(a + "和" + b + "中较大的是：" + Math.max(a, b));
		System.out.println(a + "和" + b + "中较小的是：" + Math.min(a, b));
		System.out.println(b + "的" + a + "次方： " + Math.pow(b, a));
		System.out.println("产生的0到1随机数是： " + Math.random());
	}
}
