/**
 * 
 */
package generic.method;

import generic.Pair;

import java.io.Serializable;

/**
 * 泛型方法演示
 * 
 * @author 刘晨伟
 *
 * 创建日期：2009-8-2
 */
public class GenericMethodDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] ss = { "this", "Hello", "is", "world", "Java" };
		Pair<String> minmax = minmax(ss);
		System.out.println("min=" + minmax.getFirst());
		System.out.println("max=" + minmax.getSecond());
	}
	
	/**
	 * 泛型方法可以在普通类中定义，而不只是在泛型类中定义。
	 * 类型变量放在修饰符(public、static等)的后面，返回类型(Object类型及其子类或者void)的前面，
	 * 并且使用一对尖括号(<>)括住类型变量。
	 */
	public static <T> void genericMethod(T t) {
		// ...
	}
	
	/**
	 * 类型变量的限定
	 * <p>
	 * 如果泛型类型必须限定为某种特定类型，如下面的方法，就必须指定其绑定类型。
	 * <p>
	 * <T extends BoundingType>表示T应该是绑定类型的子类型(subtype)。
	 * 绑定类型可以是类，也可以是接口。选用关键字extends是因为它更接近子类的概念。
	 * 所以即使是实现接口也是使用extends而没有用implements。
	 */
	public static <T extends Comparable<T>> Pair<T> minmax(T[] array){
		if(array == null || array.length == 0) return null;
		T min = array[0];
		T max = array[0];
		for (T s : array) {
			if(s.compareTo(min)<0) min = s;
			if(s.compareTo(max)>0) max = s;
		}
		return new Pair<T>(min,max);
	}
	
	/**
	 *  一个类型变量或通配符可以有多个限定，如下面的方法：
	 *  <p>
	 *  限定类型间用"&"分隔，这是因为逗号用来分隔类型变量，
	 *  绑定类型列表中最多有一个类，可以有多个接口。
	 *  如果类在绑定类型列表中，它必须是第一个。
	 */
	public static <T extends Comparable<T> & Serializable> void genericMethod(T t) {
		// ...
	}
}