/**
 * 
 */
package initialize;

/**
 * 类加载和初始化
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2008-4-8
 */
public class LoadAndInit {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Derived constructor");
		/**
		 * 运行该类时，首先发生的是调用了该类的main方法(它是static的)。
		 * 于是加载器开始启动并找出LoadAndInit类的编译代码(LoadAndInit.class)。
		 * 在加载的过程中，编译器注意到它有一个基类。于是它继续加载其基类，不管是否打算产生一个该基类的对象，这都会发生。
		 * 如果该基类还有其自身的基类，那么第二个基类就会被加载，以此类推。
		 * 接下来，根基类的static初始化就会执行，然后是下一个子类，以此类推。
		 * 这种方式很重要，因为子类的static初始化可能会依赖于基类成员能否被正确初始化。
		 * 到此为止，必要的类都已加载完毕，对象就可以被创建了。
		 * 
		 * 首先对象中的所有基本类型都会被设为默认值，对象引用设为null，
		 * 然后基类的构造器会被调用，在基类构造器完成之后，实例变量按其次序被初始化，
		 * 然后，构造器的其余部分被执行，最后，子类的构造器被调用。
		 */
		new Derived();
	}
}

class Super {
	
	private int i = 9;
	protected int j;

	Super() {
		System.out.println("i = " + i + ", j = " + j);
		j = 39;
	}

	public static int x1 = printInt("static Super.x1 initialized");

	static int printInt(String s) {
		System.out.println(s);
		return 47;
	}
}

class Derived extends Super {

	private int k = printInt("Derived.k initialized");

	Derived() {
		System.out.println("k = " + k);
		System.out.println("j = " + j);
	}

	public static int x2 = printInt("static Derived.x2 initialized");
}