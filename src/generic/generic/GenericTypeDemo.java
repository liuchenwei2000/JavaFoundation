/**
 * 
 */
package generic;

/**
 * 泛型演示类
 * 
 * @author 刘晨伟
 *
 * 创建日期：2007-9-14
 */
public class GenericTypeDemo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int i = 5;
		Integer[] ia = { 1, 2, 3, 4, 5, 6, 7 };
		// 构造实例时需要指明泛型的具体类型以便于编译检查
		GenericType<Integer> gt1 = new GenericType<Integer>();
		gt1.set(i);
		System.out.println(gt1.get());
		GenericType.print(ia);
		gt1.testNumber(i);

		String s = "String";
		String[] sa = { "a", "b", "c", "d", "e" };
		GenericType<String> gt2 = new GenericType<String>();
		gt2.set(s);
		System.out.println(gt2.get());
		GenericType.print(sa);
		gt2.test(i);
		gt2.testComparable(s);
		gt2.testNumberAndComparable(i);
	}
}

/**
 * GenericType<T,T>这种表达方式是不对的，若是需要两个泛型数据需要这样GenericType<T,U>。
 */
class GenericType<T> {
	
	private T t;

	public void set(T t) {
		this.t = t;
	}

	public T get() {
		return t;
	}

	/*
	 * public static void print(T[] t){
	 * 	// T不能和非泛型静态方法一起使用(因为它是和实例相关的)
	 * 	}
	 */
	
	/**
	 * 泛型数组(不支持基本类型)
	 */
	public static <T> void print(T[] t) {
		for (T item : t) {
			System.out.print(item + " ");
		}
		System.out.println();
	}
	
	/**
	 * 方法也可以定义并使用泛型
	 * <p>
	 * U是自定义的另一个泛型，区别于T
	 */
	public <U> void test(U u) {
		System.out.println("T : " + t.getClass().getName());
		System.out.println("U : " + u.getClass().getName());
	}
	
	/**
	 * 可以设定泛型绑定某一类型(接口)使得其只接受该类型或者其子类。</br>
	 * 也可以在类声明的时候进行类型绑定如：</br>
	 * public class GenericsType<T extends String>
	 */
	public <U extends Number> void testNumber(U u) {
		System.out.println("U extends Number : " + u.getClass().getSimpleName());
	}
	
	/**
	 * 实现某个接口也要用关键字extends而不是implements</br>
	 * 同样也可以在类声明的时候进行类型绑定到接口。
	 */
	public <U extends Comparable<?>> void testComparable(U u) {
		System.out.println("U extends Comparable : " + u.getClass().getSimpleName());
	}
	
	/**
	 * 也可以同时继承一个类和一个接口，用'&'进行连接。
	 */
	public <U extends Number & Comparable<?>> void testNumberAndComparable(U u) {
		System.out.println("U extends Number & Comparable : " + u.getClass().getSimpleName());
	}
}