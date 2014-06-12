/**
 * 
 */
package rtti.itf.impl;

import rtti.itf.Interface;

/**
 * ����Interface����(������ʵ��)�Ĺ�����
 * <p>
 * ʹ����ʵ�ֽӿ�Interface��PackageImpl�࣬
 * PackageImpl���ǰ�����Ȩ���������ⲿ�Ŀͻ��˾Ͳ��ܿ�����
 * 
 * @author ����ΰ
 * @see rtti.itf.demo.PackageImplDemo
 * 
 * �������ڣ�2008-5-14
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