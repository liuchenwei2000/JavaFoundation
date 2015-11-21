/**
 * 
 */
package generic.wildcard;

import generic.Pair;

/**
 * 通配符超类型限定演示类
 * 
 * @author 刘晨伟
 *
 * 创建日期：2009-8-4
 */
public class SuperWildcardDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Son[] sons = { new Son("A", 1), new Son("B", 2), new Son("C", 3),
				new Son("D", 4), new Son("E", 5) };
		minmax(sons, new Pair<Son>());
		// 可以将Pair<Father>作为参数，在这里再看minmax中set方法的行为就好理解了
		// 对于minmax方法来说，不管传入的Pair是什么类型(只要是Son的超类)
		// 都可以将Son放进去，因为这是安全的，所以set方法的参数是Son类型
		minmax(sons, new Pair<Father>());
		minmax(sons, new Pair<Object>());
	}

	private static void minmax(Son[] array,Pair<? super Son> pair){
		if(array == null || array.length == 0) return;
		Son min = array[0];
		Son max = array[0];
		for (Son son : array) {
			if(son.getAge() < min.getAge()) min = son;
			if(son.getAge() > max.getAge()) max = son;
		}
		/*
		 * 编译器不知道set方法参数的确切类型，但是可以用任意Son对象(或其子对象)
		 * 作为参数调用它，而不能用Father对象作为参数。
		 * 然而如果调用get方法，返回的对象类型得不到保证，只能将它赋给一个Object。
		 */
		pair.setFirst(min);
		pair.setSecond(max);
		System.out.println("first(min)=" + pair.getFirst());
		System.out.println("second(max)=" + pair.getSecond());
	}
}
