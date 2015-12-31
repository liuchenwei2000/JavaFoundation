/**
 * 
 */
package initialize;

/**
 * 构造器的在继承体系下的调用顺序演示
 * <p>
 * 基类的构造器总是在子类的构造过程中被调用，而且按照继承层次逐渐向上链接，
 * 以使每个基类的构造器都能得到调用，这样做是有意义的。
 * 因为构造器具有一项特殊任务：检查对象是否被正确地构造，子类只能访问它自己的成员，
 * 不能访问基类中的成员(通常是private的)。只有基类的构造器才具有恰当的知识和权限来对自己的元素进行初始化，
 * 因此必须令所有构造器都得到调用，否则就不可能正确构造完整对象。
 * 这正是编译器为什么要强制每个子类都必须调用基类构造器的原因。在子类的构造器中，
 * 如果没有明确指定调用某个基类构造器，则编译器会调用基类的默认构造器(无参构造器)。
 * 如果不存在默认构造器，编译器就会报错。若某个类没有构造器编译器会自动为它生成一个默认构造器。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2007-8-1
 */
public class Constructor extends PortableLunch {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Sandwich();
		// 输出为：
		// Meal()
		// Lunch()
		// PortableLunch()
		// Bread()
		// Cheese()
		// Lettuce()
		// Sandwich()
	}
}

/**
 * 复杂对象调用构造方法的顺序：</br>
 * <li>1，调用基类构造方法。
 * 这个步骤会不断地反复的递归下去：</br>
 * 首先是构造这种层次结构的根，然后下一层的子类，直到最底层的子类。
 * <li>2，按声明顺序调用成员的初始化方法。
 * <li>3，调用子类构造方法的主体。
 */
class Sandwich extends PortableLunch {
	
	@SuppressWarnings("unused")
	private Bread b = new Bread();
	@SuppressWarnings("unused")
	private Cheese c = new Cheese();
	@SuppressWarnings("unused")
	private Lettuce l = new Lettuce();

	public Sandwich() {
		System.out.println("Sandwich()");
	}
}

class Meal {
	Meal() {
		System.out.println("Meal()");
	}
}

class Bread {
	Bread() {
		System.out.println("Bread()");
	}
}

class Cheese {
	Cheese() {
		System.out.println("Cheese()");
	}
}

class Lettuce {
	Lettuce() {
		System.out.println("Lettuce()");
	}
}

class Lunch extends Meal {
	Lunch() {
		System.out.println("Lunch()");
	}
}

class PortableLunch extends Lunch {
	PortableLunch() {
		System.out.println("PortableLunch()");
	}
}
