/**
 * 
 */
package generic.wildcard;

import generic.Pair;

/**
 * 通配符演示类
 * 
 * @author 刘晨伟
 *
 * 创建日期：2009-8-3
 */
public class WildcardDemo {

	/**
	 * @param args
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		Pair<?> pair = new Pair<String>("first", "second");
		System.out.println("has null:" + hasNull(pair));
		System.out.println("has null2:" + hasNull2(pair));
		/*
		 * 无限定通配符 ? ，可以这样使用：Pair<?> 
		 * 这好像与原始的Pair类型一样，实际上有很大的不同： 
		 * 类型Pair<?>有方法如：
		 * ? getFirst(); void setFirst(?);
		 */
		// getFirst的返回值只能赋给一个Object
		Object object = pair.getFirst();
		System.out.println(object);
		// setFirst方法不能被调用，使用Object作为参数也不行
		// 下面的语句会有编译错
//		pair.setFirst(first);
		// Pair<?>和Pair的本质不同在于： 
		// Pair可以以任意Object对象为参数调用setFirst方法
		Pair pair2 = new Pair<String>("first", "second");
		pair2.setFirst(new String());
	}

	/**
	 * 为什么要使用 ? 这样脆弱的类型？它对于许多简单的操作非常有用。</br>
	 * 如：</br>
	 * 为了测试一个Pair是否包含了指定的对象，它不需要实际的对象。
	 */
	private static boolean hasNull(Pair<?> pair) {
		return pair.getFirst() == null || pair.getSecond() == null;
	}

	/**
	 * 通过将 ? 转换成泛型方法，可以避免使用通配符类型，但是带有通配符类型的版本可读性更强。
	 */
	private static <T> boolean hasNull2(Pair<T> pair) {
		return pair.getFirst() == null || pair.getSecond() == null;
	}
}