/**
 * 
 */
package exception.inherit;

/**
 * 异常与继承演示
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2007-8-9
 */
public class ExceptionInheritDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Father s = new Son();
			s.test();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

/**
 * 父类
 */
class Father {
	
	public Father() throws Exception {
	}

	public void test() throws Exception {
		System.out.println("No Exception!");
	}
}

/**
 * 子类
 */
class Son extends Father {
	
	/**
	 * 异常限制对构造器不起作用，Son的构造器会抛出任何异常。 
	 * 因为基类的构造器必须以某种方式被调用 ，所以子类构造器的异常说明必须包含基类构造器的异常说明，但是不能捕获基类构造器抛出的异常。
	 */
	public Son() throws Exception {
	}

	/**
	 * 当覆盖方法的时候，只能抛出在基类方法的异常说明里列出的异常 ，
	 * 或者是这些异常的子类异常，也可以不抛出任何异常(默认抛出父类该方法声明的异常)。
	 * 这样可以使得当基类使用的代码应用到其子类对象的时候一样能够工作。
	 */
	public void test() {
		System.out.println("Exception!");
		throw new RuntimeException();
	}
}