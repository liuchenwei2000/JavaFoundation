/**
 * 
 */
package rtti.itf.impl;

import rtti.itf.Interface;

/**
 * 构造Interface对象(匿名内部类实现)的工厂类
 * 
 * @author 刘晨伟
 * @see rtti.itf.demo.AnonymousInnerImplDemo
 * 
 * 创建日期：2008-5-14
 */
public class AnonymousInnerImplFactory {

	public static Interface makeInterface() {
		return new Interface() {

			public void f() {
				System.out.println("public AnonymousInnerImpl.f()");
			}

			@SuppressWarnings("unused")
			public void g() {
				System.out.println("public AnonymousInnerImpl.g()");
			}

			@SuppressWarnings("unused")
			void u() {
				System.out.println("package AnonymousInnerImpl.u()");
			}

			@SuppressWarnings("unused")
			protected void v() {
				System.out.println("protected AnonymousInnerImpl.v()");
			}

			@SuppressWarnings("unused")
			private void w() {
				System.out.println("private AnonymousInnerImpl.w()");
			}
		};
	}
}