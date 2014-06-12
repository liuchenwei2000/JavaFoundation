/**
 * 
 */
package initialize.constructor;

/**
 * 构造器的在继承体系下的调用顺序演示
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2007-8-1
 */
public class Sandwich extends PortableLunch {
	
	@SuppressWarnings("unused")
	private Bread b = new Bread();
	@SuppressWarnings("unused")
	private Cheese c = new Cheese();
	@SuppressWarnings("unused")
	private Lettuce l = new Lettuce();

	public Sandwich() {
		System.out.println("Sandwich()");
	}

	/**
	 * 复杂对象调用构造方法的顺序：</br>
	 * <li>1，调用基类构造方法。
	 * 这个步骤会不断地反复的递归下去：</br>
	 * 首先是构造这种层次结构的根，然后下一层的子类，直到最底层的子类。
	 * <li>2，按声明顺序调用成员的初始化方法
	 * <li>3，调用子类构造方法的主体
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