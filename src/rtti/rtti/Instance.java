/**
 * 
 */
package rtti;

/**
 * instanceof运算符和Class.isInstance()方法 
 * <p>
 * 关键字instanceof返回一个boolean值，判断对象是不是某个类或接口的实例，
 * Class.isInstance方法提供了一种动态调用instanceof运算符的途径。
 * (如果对某个对象进行强制类型转换的时候，可以先用instanceof判断正确性)
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2007-8-6
 */
public class Instance {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		test(new Base());
		test(new Derived());
	}
	
	static void test(Object x) {
		/*
		 * instanceof和isInstance()生成结果完全相同，equals()和==也完全相同
		 * 其中instanceof考虑继承，而==不考虑继承
		 */
		System.out.println("Testing x is type " + x.getClass());
		System.out.println("x instance of Base " + (x instanceof Base));
		System.out.println("x instance of Derived " + (x instanceof Derived));
		System.out.println("x instance of MyInterface "
				+ (x instanceof MyInterface));
		System.out.println("Base.isInstance(x) " + Base.class.isInstance(x));
		System.out.println("Derived.isInstance(x) "
				+ Derived.class.isInstance(x));
		System.out.println("MyInterface.isInstance(x) "
				+ MyInterface.class.isInstance(x));
		System.out.println("x.getClass()==Base.class "
				+ (x.getClass() == Base.class));
		System.out.println("x.getClass()==Derived.class "
				+ (x.getClass() == Derived.class));
		System.out.println("x.getClass().equals(Base.class) "
				+ x.getClass().equals(Base.class));
		System.out.println("x.getClass().equals(Derived.class) "
				+ x.getClass().equals(Derived.class));
		System.out.println();
	}
}

class Base {
}

class Derived extends Base implements MyInterface {
}

interface MyInterface {
}