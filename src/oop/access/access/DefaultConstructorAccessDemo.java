/**
 * 
 */
package access;

/**
 * 默认(无参)构造器访问演示
 * <p>
 * 用于演示编译器自动生成的默认构造器的访问控制符跟类名访问控制符的关系。
 * 
 * @author 刘晨伟
 *
 * 创建日期：2009-7-13
 */
public class DefaultConstructorAccessDemo {

	/**
	 * 打印如下： 
	 * Class PrivateClass is : private 
	 * Constructor PrivateClass() is : private
	 * 
	 * Class ProtectedClass is : protected 
	 * Constructor ProtectedClass() is : protected
	 * 
	 * Class DefaultClass is : default 
	 * Constructor DefaultClass() is : default
	 * 
	 * Class PublicClass is : public 
	 * Constructor PublicClass() is : public
	 */
	public static void main(String[] args) {
		ModifierPrinter.printModifier(PrivateClass.class);
		ModifierPrinter.printModifier(ProtectedClass.class);
		ModifierPrinter.printModifier(DefaultClass.class);
		ModifierPrinter.printModifier(PublicClass.class);
	}

	private class PrivateClass {
	}

	protected class ProtectedClass {
	}

	class DefaultClass {
	}

	public class PublicClass {
	}
}
