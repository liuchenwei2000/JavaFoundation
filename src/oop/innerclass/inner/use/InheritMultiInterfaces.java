/**
 * 
 */
package inner.use;

/**
 * 内部类解决多重继承(接口)演示
 * <p>
 * 解决问题：</br>
 * 必须在一个类中以某种方式实现两个接口。
 * <li>解决方案1：使用单一类
 * <li>解决方案2：使用内部类
 * 
 * @author 刘晨伟
 *
 * 创建日期：2008-4-16
 */
public class InheritMultiInterfaces {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		X x = new X();
		Y y = new Y();
		takesA(x);
		takesB(x);
		takesA(y);
		takesB(y.makeB());
	}

	private static void takesA(A a) {
	}

	private static void takesB(B a) {
	}
}

interface A {
}

interface B {
}

/**
 * 使用单一类来实现两个接口
 */
class X implements A, B {
}

/**
 * 使用内部类来达到一个类实现两个接口的目的
 */
class Y implements A {
	
	B makeB() {
		// 匿名内部类实现了B接口
		return new B() {
		};
	}
}
