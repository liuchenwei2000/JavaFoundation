/**
 * 
 */
package generic.wildcard;

import generic.Pair;

/**
 * 通配符子类型限定演示类
 * <p>
 * 访问器安全(可用)，修改器不安全(不可用)。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2009-8-3
 */
public class ExtendsWildcardDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Father f1 = new Father("f1");
		Father f2 = new Father("f2");

		Son s1 = new Son("s1");
		Son s2 = new Son("s2");

		Pair<Father> p1 = new Pair<Father>(f1, f2);
		Pair<Son> p2 = new Pair<Son>(s1, s2);

		printFather(p1);
		// 下面的语句会有编译错
//		printFather(p2);
//		printSon(p1);
		printSon(p2);
		printAll(p1);
		printAll(p2);
		
		/* 
		 * 使用Pair<? extends Father>类型将不可以调用set方法
		 * 编译器只知道它需要某个Father的子类型，但是不知道具体是什么类型
		 * 它拒绝传递任何特定的类型；但get方法是安全可用的
		 */
		Pair<? extends Father> pair = p2;
		// 下面的语句会有编译错
//		pair.setFirst(s1);
		Father f3 = pair.getFirst();
		System.out.println(f3.getName());
	}

	/**
	 * 通配符类型Pair<? extends Father>表示任何泛型Pair类型。
	 * 它的类型参数是Father的子类，如Pair<Son>，但不是Pair<String>。
	 * Pair<Father>、Pair<Son>都是Pair<? extends Father>的子类型。
	 */
	private static void printAll(Pair<? extends Father> pair) {
		System.out.println("first=" + pair.getFirst().getName());
		System.out.println("second=" + pair.getSecond().getName());
		System.out.println();
	}
	
	/**
	 * 本方法就把参数限制的太死了，只可以传入Pair<Father>，而Pair<Son>就不行。
	 * 因为Pair<Son>并不是Pair<Father>的子类。
	 */
	private static void printFather(Pair<Father> pair) {
		System.out.println("first=" + pair.getFirst().getName());
		System.out.println("second=" + pair.getSecond().getName());
		System.out.println();
	}

	/**
	 * 同上方法
	 */
	private static void printSon(Pair<Son> pair) {
		System.out.println("first=" + pair.getFirst().getName());
		System.out.println("second=" + pair.getSecond().getName());
		System.out.println();
	}
}
