/**
 * 
 */
package initialize;

/**
 * 继承中的初始化顺序
 * <p>
 * <li>1，自动调用父类的构造方法</br>
 * (若有super则调用super指明的构造方法，若没有则自动调用父类无参构造函数)
 * <li>2，初始化每一个字段(没有显式初始化的就用默认值初始化)和初始化语句块</br>
 * (数值型的默认值为0，boolean型默认值为false，char型默认值为'\u0000'，Object默认值为null)
 * <li>3，按顺序执行构造方法的其他语句
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2007-8-1
 */
public class InitSequence {
	
	/**
	 * 初始化的实际过程： </br>
	 * <li>1，在其他任何事物发生之前，将分配给对象的存储空间初始化成二进制的零 。
	 * <li>2，如Sandwich类中所述的那样进行初始化 。
	 * 注：</br>
	 * 在父类的构造方法中调用的方法是动态绑定的，但是在构造方法中尽量不调用其他方法(要避免)。
	 */
	public static void main(String[] args) {
		new Son();
		new Son(20);
		// 输入为：
//		Father() before show()
//		Son.show(),age = 0
//		Father() after show()
//		Son.Son(),age = 10
//		Father(int) before show()
//		Son.show(),age = 0
//		Father(int) after show()
//		Son.Son(int),age = 20
	}
}

abstract class Father {
	
	Father() {
		System.out.println("Father() before show()");
		show();
		System.out.println("Father() after show()");
	}

	Father(int n) {
		System.out.println("Father(int) before show()");
		show();
		System.out.println("Father(int) after show()");
	}
	
	abstract void show();
}

class Son extends Father {
	
	private int age = 10;

	Son() {
		System.out.println("Son.Son(),age = " + age);
	}

	Son(int n) {
		super(n);
		age = n;
		System.out.println("Son.Son(int),age = " + age);
	}

	void show() {
		System.out.println("Son.show(),age = " + age);
	}
}