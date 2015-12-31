/**
 * 
 */
package access.inner.a;

import access.inner.IAccessable;
import access.inner.Outer;

/**
 * 内部类异包其他类的访问控制演示
 * 
 * @author 刘晨伟
 *
 * 创建日期：2009-7-13
 */
public class OuterInDifferentPackage {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Outer out = new Outer();
		// 只能访问public内部类
		Outer.PublicInner publicInner = out.new PublicInner();
		// 只能访问public成员和public方法
		publicInner.publicField = 0;
		publicInner.publicMethod();

		Outer.PublicInner publicInner2 = out.getPublicInner();
		publicInner2.publicField = 0;
		publicInner2.publicMethod();

		// 使用接口引用则可以访问所有四个内部类的public方法
		IAccessable accessable;
		accessable = out.getPrivateInner();
		accessable.publicMethod();
		accessable = out.getDefaultInner();
		accessable.publicMethod();
		accessable = out.getProtectedInner();
		accessable.publicMethod();
		accessable = out.getPublicInner();
		accessable.publicMethod();
	}
}
