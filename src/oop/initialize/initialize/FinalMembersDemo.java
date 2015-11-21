/**
 * 
 */
package initialize;

/**
 * final 修饰字段的初始化示例
 * 
 * @author 刘晨伟
 *
 * 创建日期：2007-11-8
 */
public class FinalMembersDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Circle circle = new Circle(1);
		System.out.println(circle.getArea());
	}
}

/**
 * 圆类
 * <p>
 * 一个字段被final修饰需要满足：</br>
 * <li>1，字段所代表对象的属性是不可变的；
 * <li>2，当对象被创建的时候该字段的值是可得的；
 * <li>3，当对象被创建的时候该字段就可以被赋值初始化。
 */
class Circle {

	/** final static 修饰的字段在类初始化的时候就应该被初始化 */
	private static final double PI = getPI();
	/** final 单独修饰的字段在对象被创建的时候就应该被初始化 */
	private final double r;

	public Circle(int r) {
		this.r = r;
	}

	private static double getPI() {
		return Math.PI;
	}

	public double getR() {
		return r;
	}

	/**
	 * 面积
	 */
	public double getArea() {
		return PI * r * r;
	}
}
