/**
 * 
 */
package generic.wildcard;

import generic.Pair;

/**
 * 通配符捕获演示
 * 
 * @author 刘晨伟
 *
 * 创建日期：2009-8-3
 */
public class CaptureWildcardDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Pair<?> pair = new Pair<String>("head", "tail");
		System.out.println(pair.toString());
		swap(pair);
		System.out.println(pair.toString());
		Pair<Father> pair2 = new Pair<Father>(new Father("f1"), new Father("f2"));
		System.out.println(pair2.toString());
		swapMustCapture(pair2);
		System.out.println(pair2.toString());
	}

	/**
	 * 交换Pair中两个元素的方法
	 */
	private static void swap(Pair<?> pair) {
		// 下面的语句会有编译错
		// 通配符不是类型变量，因此不能在代码中使用"?"作为一种类型
//		? t = pair.getFirst();
		// 即使使用Object也不可以，因为setFirst不可用，如下：
//		Object t = pair.getFirst();
//		pair.setFirst(pair.getSecond());
//		pair.setSecond(t);
		// 因为在交换时必须用一个引用临时保存一个元素
		// 所幸的是这个问题有一个有趣的解决方案，使用一个泛型辅助方法
		swapHelper(pair);
	}
	
	/**
	 * swapHelper是一个泛型方法，而swap不是，它具有固定的Pair<?>类型的参数。
	 * 参数 T 能够捕获(capture)通配符，它不知道是哪种类型的通配符，但是肯定是一个明确的类型。
	 * 并且<T>swapHelper的定义只有在T指出类型时，才有明确的含义。
	 */
	private static <T> void swapHelper(Pair<T> pair) {
		T t = pair.getFirst();
		pair.setFirst(pair.getSecond());
		pair.setSecond(t);
	}
	
	/**
	 * 当然上面那种情况下直接使用swapHelper作为公共接口就可以，
	 * 但是通配符类型以下面的形式出现时，捕获机制是不可避免的。
	 */
	private static void swapMustCapture(Pair<? super Son> pair){
		// 下面的语句会有编译错
//		Object object = pair.getSecond();// 返回Object类型对象
//		pair.setFirst(object);// 该方法的参数是Son类型对象
		swapHelper(pair);
	}
}
