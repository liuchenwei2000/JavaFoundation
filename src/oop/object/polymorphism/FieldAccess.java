/**
 * 
 */
package polymorphism;

/**
 * 只有普通的方法调用(不包括域调用)可以是多态的。
 * 如果直接访问某个域，这个访问将在编译期进行解析。
 * 多态是动态绑定、后期绑定、运行时绑定。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2008-4-8
 */
public class FieldAccess {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Super sup = new Sub();
		// 当Sub对象转型为Super引用时，任何域访问操作都由编译期解析，因此不是多态的
		System.out.println("sup.field = " + sup.field + ", sup.getField() = "
				+ sup.getField());
		// 输出：sup.field = super field, sup.getField() = sub field
		Sub sub = new Sub();
		System.out.println("sub.field = " + sub.field + ", sub.getField() = "
				+ sub.getField() + ", sub.getSuperFiled() = "
				+ sub.getSuperFiled());
		// 输出：sub.field = sub field, sub.getField() = sub field, sub.getSuperFiled() = super field
	}
}

class Super {
	public String field = "super field";

	public String getField() {
		return field;
	}
}

class Sub extends Super {
	public String field = "sub field";

	public String getField() {
		return field;
	}

	public String getSuperFiled() {
		return super.field;
	}
}