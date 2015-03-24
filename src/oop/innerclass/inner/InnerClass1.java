/**
 * 
 */
package inner;

/**
 * 内部类演示1
 * <p>
 * 用途1：内部类是一种名字隐藏和组织代码的模式。
 * <p>
 * 典型的情况是：外部类有一个方法，该方法返回一个指向内部类的引用。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2008-4-13
 */
public class InnerClass1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Goods goods1 = new Goods();
		goods1.ship("China");
		Goods goods2 = new Goods();
		// 定义对内部类的引用
		// 如果想在外部类的非static方法之外的地方创建内部类对象，就必须具体的指明这个对象的类型：OutClass.InnerClass
		@SuppressWarnings("unused")
		Goods.Contents c = goods2.getContents();
		@SuppressWarnings("unused")
		Goods.Destination d = goods2.to("Home");
	}
}

class Goods {
	
	class Contents {
		
		private int i = 11;

		public int getValue() {
			return i;
		}
	}

	class Destination {
		
		private String label;

		Destination(String toWhere) {
			label = toWhere;
		}

		String readLabel() {
			return label;
		}
	}

	public Contents getContents() {
		return new Contents();
	}

	public Destination to(String where) {
		return new Destination(where);
	}

	public void ship(String dest) {
		@SuppressWarnings("unused")
		Contents c = getContents();
		Destination d = to(dest);
		System.out.println(d.readLabel());
	}
}