/**
 * 
 */
package access.inner;

/**
 * 内部类同包其他类的访问控制演示
 * 
 * @author 刘晨伟
 *
 * 创建日期：2009-7-13
 */
public class OuterInTheSamePackage {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	       Outer out = new Outer();
	       // 使用 new 的方式得不到 Outer.PrivateInner 的实例
	       // 因为Outer.PrivateInner对于本类是不可见的
	       // Outer.PrivateInner privateInner = out.new PrivateInner();
	       
	       // 使用 new 的方式得到 Outer.DefaultInner 的实例
	       Outer.DefaultInner defaultInner = out.new DefaultInner();
	       // 但是不能够访问DefaultInner的private成员和private方法
	       // defaultInner.privateField = 0;
	       // defaultInner.privateMethod();
	       // 只可以访问DefaultInner的非private修饰的成员和方法，这和基本访问权限控制是一致的
	       defaultInner.defaultField = 0;
	       defaultInner.defaultMethod();
	 
	       // 使用外部类方法getInnerInstance()也无法得到Outer.PrivateInner 的实例
	       // 虽然可以调用public getPrivateInner()方法，但是无法得到Outer.PrivateInner引用
	       // Outer.PrivateInner privateInner2 = out.getPrivateInner();
	       
	       // 可以通过接口的引用访问到private内部类的public方法
	       // 同样使用default、protected和public的内部类对象都可以访问这个public方法
	       IAccessable privateInner = out.getPrivateInner();
	       privateInner.publicMethod();
	}
}