/**
 * 
 */
package polymorphism;

/**
 * 构造器中的多态方法演示
 * <p>
 * 如果在一个构造器的内部调用正在构造对象的某个动态绑定方法，就要用到那个方法被覆盖后的定义。
 * 然而这个调用的效果可能相当难于预料，因为被覆盖的方法在对象被完全构造之前就会被调用。
 * <p>
 * 在任何构造器内部，整个对象可能只是部分形成，只能知道该对象已经开始进行初始化。
 * 如果构造器只是在构造对象过程中的一个步骤，并且该对象所属的类是这个构造器所属的类的子类，
 * 那么子类在当前构造器正在被调用的时刻仍旧是没有被初始化的，然而一个动态绑定的方法调用却会向外深入到继承层次结构内部，
 * 它可以调用子类里的方法。如果在构造器内部这样做，那么就会调用某个方法，而这个方法所操纵的成员可能还没有进行初始化。
 * <p>
 * 因此，编写构造器的一个准则：
 * 用尽可能简单的方法是对象进入正常状态，尽量避免调用其他方法。
 * 在构造器中能够安全调用的方法是基类的final方法(还有private方法，默认是final的)。
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