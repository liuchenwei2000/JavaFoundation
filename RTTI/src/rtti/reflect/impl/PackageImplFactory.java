/**
 * 
 */
package rtti.reflect.impl;

import rtti.reflect.demo.Product;
import rtti.reflect.demo.PackageImplDemo;

/**
 * 构造 Product 对象（包级类实现）的工厂类
 * <p>
 * 使用了实现接口 Product 的PackageImpl类，PackageImpl类是包访问权限，这样包外部的客户端就不能看到它。
 * 
 * @author 刘晨伟
 * @see PackageImplDemo
 * 
 * 创建日期：2008-5-14
 */
public class PackageImplFactory {

	public static Product makeProduct() {
		return new PackageImpl();
	}
}

class PackageImpl implements Product {

	public void f() {
		System.out.println("public PackageImpl.f()");
	}

	public void g() {
		System.out.println("public PackageImpl.g()");
	}

	void u() {
		System.out.println("package PackageImpl.u()");
	}

	protected void v() {
		System.out.println("protected PackageImpl.v()");
	}

	private void w() {
		System.out.println("private PackageImpl.w()");
	}
}
