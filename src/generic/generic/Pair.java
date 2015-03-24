/**
 * 
 */
package generic;

/**
 * 泛型类就是具有一个或多个类型变量的类
 * <p>
 * Pair类引入了一个类型变量T，用尖括号(<>)括起，并放在类名的后面。
 * <p>
 * 泛型类可以有多个类型变量。
 * 例如，可以定义Pair类，其中第一个域和第二个域使用不同的类型：</br>
 * public class Pair<T,U>{...}
 * <p>
 * 类型变量使用大写形式，且比较短，这是很常见的。按照Java规范：</br>
 * <li>一般使用变量E表示集合的元素类型
 * <li>K和V分别表示表的关键字与值的类型
 * <li>T(需要时还可以使用U和S)表示任意类型
 * 
 * @author 刘晨伟
 *
 * 创建日期：2009-8-3
 */
public class Pair<T> {

	// 类定义中的类型变量指定方法的返回类型以及字段和局部变量的类型
	private T first;// 使用了类型变量T
	private T second;

	public Pair() {
	}

	/**
	 * 使用了类型变量T
	 */
	public Pair(T first, T second) {
		this.first = first;
		this.second = second;
	}

	public T getFirst() {
		return first;
	}

	public void setFirst(T first) {
		this.first = first;
	}

	public T getSecond() {
		return second;
	}

	public void setSecond(T second) {
		this.second = second;
	}
	
	public String toString() {
		return "first=" + first.toString() + "  second=" + second.toString();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] ss = { "this", "Hello", "is", "world", "Java" };
		Pair<String> minmax = minmax(ss);
		System.out.println("min=" + minmax.getFirst());
		System.out.println("max=" + minmax.getSecond());
	}
	
	private static Pair<String> minmax(String[] array){
		if(array == null || array.length == 0) return null;
		String min = array[0];
		String max = array[0];
		for (String s : array) {
			if (s.compareTo(min) < 0)
				min = s;
			if (s.compareTo(max) > 0)
				max = s;
		}
		/*
		 * 用具体的类型替换类型变量就可以实例化泛型类型
		 * 例如：Pair<String>
		 * 换句话说，泛型类可看作普通类的工厂。
		 */
		return new Pair<String>(min,max);
	}
}