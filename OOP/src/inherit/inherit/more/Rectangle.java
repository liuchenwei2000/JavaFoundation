/**
 * 
 */
package inherit.more;

/**
 * 矩形类
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2007-8-2
 */
public class Rectangle implements IFigure {
	
	private double length;// 长
	private double width;// 宽

	public Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	@Override
	public void draw() {
		System.out.println("This is rectangle!");
	}

	@Override
	public double getArea() {
		return length * width;
	}

	@Override
	public double getGirth() {
		return 2 * (length + width);
	}
}
