/**
 * 
 */
package access.inner.a;

import access.inner.Outer;

/**
 * 内部类异包子类的访问控制演示
 * 
 * @author 刘晨伟
 *
 * 创建日期：2009-7-13
 */
public class OuterSubclassInDifferentPackage extends Outer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Outer extend = new OuterSubclassInDifferentPackage();
		// Outer.ProtectedInner对于子类是可见的
		// protected内部类声明参与外部类的继承
		Outer.ProtectedInner protectedIn = extend.getProtectedInner();
		// 只能访问Outer.ProtectedInner的public成员和方法
		// protected内部类的方法不参与外部类的继承
		protectedIn.publicField = 0;
		protectedIn.publicMethod();
	}
}