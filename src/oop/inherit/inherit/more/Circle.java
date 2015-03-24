/**
 * 
 */
package inherit.more;

/**
 * 圆类 
 * <p>
 * 一个类实现的是一个继承自其他接口的接口 ，则该类必须实现这个接口和其所有父接口的所有方法。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2007-8-2
 */
public class Circle implements IFigure {
	
	private double r;// 半径

	public Circle(double r) {
		this.r = r;
	}

	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}

	@Override
	public void draw() {
		System.out.println("This is circle!");
	}

	@Override
	public double getArea() {
		return r * r * Math.PI;
	}

	@Override
	public double getGirth() {
		return 2 * r * Math.PI;
	}
}