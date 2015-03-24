/**
 * 
 */
package rtti.itf.impl;

import rtti.itf.Interface;

/**
 * 构造Interface对象（私有内部类实现）的工厂类
 * <p>
 * 使用了实现接口Interface的PrivateInnerImpl类，PrivateInnerImpl类是私有内部类，对外类型信息被屏蔽。
 * 
 * @author 刘晨伟
 * @see rtti.itf.demo.PrivateInnerImplDemo
 * 
 * 创建日期：2008-5-14
 */
public class PrivateInnerImplFactory {

	public static Interface makeInterface() {
		return new PrivateInnerImpl();
	}

	private static class PrivateInnerImpl implements Interface {

		public void f() {
			System.out.println("public PrivateInnerImpl.f()");
		}

		@SuppressWarnings("unused")
		public void g() {
			System.out.println("public PrivateInnerImpl.g()");
		}

		@SuppressWarnings("unused")
		void u() {
			System.out.println("package PrivateInnerImpl.u()");
		}

		@SuppressWarnings("unused")
		protected void v() {
			System.out.println("protected PrivateInnerImpl.v()");
		}

		@SuppressWarnings("unused")
		private void w() {
			System.out.println("private PrivateInnerImpl.w()");
		}
	}
}