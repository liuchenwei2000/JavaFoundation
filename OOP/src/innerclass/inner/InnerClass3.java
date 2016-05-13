/**
 * 
 */
package inner;

/**
 * 内部类演示3
 * <p>
 * 用途3：</br>
 * 当将内部类向上转型为其基类，尤其是一个接口的时候，内部类就有特殊的用途。
 * 这是因为内部类(某个接口的实现)能够完全不可见，并且不可用，
 * 所得到的只是指向其基类或者接口的引用，所以能够方便地隐藏实现细节。
 * 
 * @author 刘晨伟
 *
 * 创建日期：2008-4-13
 */
public class InnerClass3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NewGoods goods = new NewGoods();
		IContents c = goods.getContents();
		IDestination d = goods.getDestination("Beijing");
	}
}

class NewGoods {

	/**
	 * 内部类Contents
	 * <p>
	 * private 内部类可以完全阻止任何依赖于类型的编码，并且完全隐藏实现细节。
	 * 从客户端程序员的角度来看，由于不能访问任何新增加的原本不属于公共接口的方法，所以扩展接口是没有价值的。
	 */
	private class Contents implements IContents {

		private int i = 11;

		public int value() {
			return i;
		}
	}

	/**
	 * 内部类GDestination
	 */
	protected class GDestination implements IDestination {
		
		private String label;

		private GDestination(String whereTo) {
			label = whereTo;
		}

		public String readLabel() {
			return label;
		}
	}

	public IContents getContents() {
		return new Contents();
	}

	public IDestination getDestination(String s) {
		return new GDestination(s);
	}
}
