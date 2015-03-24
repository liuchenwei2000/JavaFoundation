/**
 * 
 */
package rtti;

import java.util.Random;

/**
 * 类初始化
 * <p>
 * 当使用".class"来创建对Class对象的引用时，不会自动地初始化该Class对象。
 * <p>
 * 为了使用类而做的准备工作实际包含三个步骤：
 * <li>1，加载 
 * 这是使用类加载器执行的，该步骤将查找class文件并创建一个Class对象。
 * <li>2，链接 
 * 在链接阶段将验证类中的字节码，为静态域分配存储空间， 并且如果必需的话，将解析这个类创建的对其他类的所有引用。
 * <li>3，初始化 
 * 如果该类具有超类，则对其初始化，执行静态初始化器和静态初始化块。
 * 
 * @author 刘晨伟
 *
 * 创建日期：2008-5-9
 */
public class ClassInitialization {

	/**
	 * 初始化有效地实现了尽可能地"惰性"：
	 * 使用 .class 语法来获取对类的引用不会引发初始化，而  Class.forName() 立即就进行了初始化。
	 */
	@SuppressWarnings( { "unused" })
	public static void main(String[] args) throws Exception {
		Class<?> initable = Initable.class;
		System.out.println("After creating Initable ref");
		/*
		 * 如果一个static final值是"编译期常量"，就像是Initable.staticFinal，
		 * 那么这个值不需要对Initable类进行初始化就可以被读取。
		 * 
		 * 如果只是将一个域设置为static final的，还不足以确保这种行为，
		 * 例如Initable.staticFinal2的访问将强制进行类的初始化，因为它不是编译期常量。
		 * 
		 * 如果一个static域不是final的，那么对它访问时总是要求在它被读取之前，
		 * 要先进行链接(为这个域分配存储空间)和初始化(初始化该存储空间)，就像在对Initable2.staticNonFinal的访问一样。
		 */
		// 不会触发初始化
		System.out.println(Initable.staticFinal);
		// 会触发初始化
		System.out.println(Initable.staticFinal2);
		// 会触发初始化
		System.out.println(Initable2.staticNonFinal);
		Class<?> initable3 = Class.forName("rtti.Initable3");
		System.out.println("After creating Initable3 ref");
		System.out.println(Initable3.staticNonFinal);
	}
}

class Initable{
	
	static final int staticFinal = 47;
	static final int staticFinal2 = new Random().nextInt(1000);
	
	static {
		System.out.println("Initializing Initable");
	}
}

class Initable2 {
	
	static int staticNonFinal = 147;
	
	static {
		System.out.println("Initializing Initable2");
	}
}

class Initable3 {
	
	static int staticNonFinal = 74;
	
	static {
		System.out.println("Initializing Initable3");
	}
}