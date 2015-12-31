/**
 * 
 */
package inner.statics;

import inner.IContents;
import inner.IDestination;

/**
 * 静态内部类演示
 * <p>
 * 如果不需要内部类对象与外部类对象之间有联系，可以将内部类声明为static，通常称为嵌套类。
 * 普通的内部类对象隐式的保存了一个引用创建它的外部类对象，当内部类是static的时候这没有这个引用了，
 * </br>这意味着：</br>
 * <li>1，要创建嵌套类的对象并不需要其外部类的对象。
 * <li>2，不能从嵌套类的对象中访问非静态的外部类对象。</br>
 * 另外，普通的内部类不能有static数据和static字段，也不能包含嵌套类，但是嵌套类可以包含这些东西。
 * 
 * @author 刘晨伟
 *
 * 创建日期：2008-4-14
 */
public class StaticInnerClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		IContents c = NewGoods2.getContents();
		@SuppressWarnings("unused")
		IDestination d = NewGoods2.getDestination("China");
	}
}

class NewGoods2 {

	private static class Contents implements IContents {

		private int i = 11;

		public int value() {
			return i;
		}
	}

	protected static class GDestination implements IDestination {
		
		private String label;

		private GDestination(String whereTo) {
			label = whereTo;
		}

		public String readLabel() {
			return label;
		}

		static int x = 2;

		static class AnotherLevel {
			
			static int x = 1;

			public static void f() {
			}
		}
	}

	public static IContents getContents() {
		return new Contents();
	}

	public static IDestination getDestination(String s) {
		return new GDestination(s);
	}
}
