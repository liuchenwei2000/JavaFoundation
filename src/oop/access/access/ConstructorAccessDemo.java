/**
 * 
 */
package access;

/**
 * 构造器访问演示
 * <p>
 * 类名的访问控制符修饰表示该类的可见性，类构造器的访问控制符表示该构造器的可见性。
 * 
 * @author 刘晨伟
 *
 * 创建日期：2009-7-13
 */
public class ConstructorAccessDemo {

	/**
	 * 打印如下： 
	 * Class PrivateClass is : private 
	 * Constructor PrivateClass() is : public
	 * 
	 * Class ProtectedClass is : protected 
	 * Constructor ProtectedClass() is : public
	 * 
	 * Class DefaultClass is : default 
	 * Constructor DefaultClass() is : public
	 * 
	 * Class PublicClass is : public 
	 * Constructor PublicClass() is : private
	 */
	public static void main(String[] args) {
		ModifierPrinter.printModifier(PrivateClass.class);
		ModifierPrinter.printModifier(ProtectedClass.class);
		ModifierPrinter.printModifier(DefaultClass.class);
		ModifierPrinter.printModifier(PublicClass.class);
	}

	/**
	 * 只有本类(ConstructorAccessDemo)可以使用PrivateClass。
	 * 所以尽管PrivateClass构造器修饰符是public，但对于非本类调用也是不可见的。
	 */
	private class PrivateClass {
		@SuppressWarnings("unused")
		public PrivateClass(){}
	}

	/**
	 * 同包类或者非同包本类(ConstructorAccessDemo)子类可以使用ProtectedClass。
	 * 所以将其构造器修饰为public，这样对于同包类的使用没有什么影响，可以new ProtectedClass()。
	 * 但是对于非同包子类来说，这就意味着其可以使用new ProtectedClass()来创建实例。
	 * 如果不是public修饰，而使用默认的修饰符(即包级修饰符)来修饰构造器。
	 * 那么非同包子类就不能调用new ProtectedClass()来创建实例了。
	 */
	protected class ProtectedClass {
		public ProtectedClass(){}
	}

	/**
	 * 只有同包类可以使用DefaultClass，所以将其构造器修饰为public和默认的default是一样的效果。
	 */
	class DefaultClass {
		public DefaultClass(){}
	}
	
	/**
	 * 所有的类都可以使用PublicClass，所以将其其构造器修饰为private
	 * 意味着非本类不可以使用new来创建PublicClass实例。
	 */
	public class PublicClass {
		private PublicClass(){}
	}
}