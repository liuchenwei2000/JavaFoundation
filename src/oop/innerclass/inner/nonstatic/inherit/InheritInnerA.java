/**
 * 
 */
package inner.nonstatic.inherit;

/**
 * 内部类的继承方式之一
 * <p>
 * 如果新建的子内部类的外部类不是父内部类的外部类的子类，或者子内部类不再是一个内部类而是一个一般的类时。
 * 当子内部类通过super调用构造方法的时候必须提供一个父内部类外部类对象的引用。
 * <p>
 * <strong>内部类继承会导致结构混乱不易读，应避免这种设计</strong>
 * 
 * @author 刘晨伟
 *
 * 创建日期：2007-8-6
 */
public class InheritInnerA extends Outer.Inner {
	
	/**
	 * 构造方法不能只是传递一个指向外部类对象的引用
	 * 还必须在构造方法内使用：XXX.super();(缺省构造方法编译会不能通过)
	 */ 
	InheritInnerA(Outer o) {
		o.super();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Outer o = new Outer();
		InheritInnerA ii = new InheritInnerA(o);
		System.out.println(ii);
	}
}