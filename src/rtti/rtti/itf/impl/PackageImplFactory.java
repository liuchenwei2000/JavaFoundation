/**
 * 
 */
package rtti.itf.impl;

import rtti.itf.Interface;

/**
 * 构造Interface对象(包级类实现)的工厂类
 * <p>
 * 使用了实现接口Interface的PackageImpl类，
 * PackageImpl类是包访问权限这样包外部的客户端就不能看到它
 * 
 * @author 刘晨伟
 * @see rtti.itf.demo.PackageImplDemo
 * 
 * 创建日期：2008-5-14
 */
public class PackageImplFactory {

	public static Interface makeInterface() {
		return new PackageImpl();
	}
}

class PackageImpl implements Interface {

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

	@SuppressWarnings("unused")
	private void w() {
		System.out.println("private PackageImpl.w()");
	}
}