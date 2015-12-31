/**
 * 
 */
package inner.use;

/**
 * 内部类解决多重继承(类)演示
 * <p>
 * 解决问题：</br>
 * 必须在一个类中以某种方式继承两个类，这样的话就只能使用内部类来达到这种实现。
 * 
 * @author 刘晨伟
 *
 * 创建日期：2008-4-16
 */
public class InheritMultiClasses {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Z z = new Z();
		takesD(z);
		takesE(z.makeE());
	}

	private static void takesD(D d) {
	}

	private static void takesE(E e) {
	}
}

class D {
}

abstract class E {
}

class Z extends D {
	
	E makeE() {
		return new E() {
		};
	}
}
