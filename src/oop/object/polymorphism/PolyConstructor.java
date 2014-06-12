/**
 * 
 */
package polymorphism;

/**
 * 构造器中的多态方法演示
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2008-4-10
 */
public class PolyConstructor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Circle(5);
	}
}

class Shape {

	Shape() {
		System.out.println("Shape() before draw()");
		draw();
		System.out.println("Shape() after draw()");
	}

	void draw() {
		System.out.println("Shape.draw()");
	}
}

class Circle extends Shape {
	
	private int radius = 1;

	Circle(int r) {
		this.radius = r;
		System.out.println("Circle.Circle().radius = " + radius);
	}

	void draw() {
		System.out.println("Circle.draw().radius = " + radius);
	}
}