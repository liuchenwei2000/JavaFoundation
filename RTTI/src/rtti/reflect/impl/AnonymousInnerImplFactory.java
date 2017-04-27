/**
 * 
 */
package rtti.reflect.impl;

import rtti.reflect.demo.AnonymousInnerImplDemo;
import rtti.reflect.demo.Product;

/**
 * 构造 Product 对象（匿名内部类实现）的工厂类
 * 
 * @author 刘晨伟
 * @see AnonymousInnerImplDemo
 * 
 * 创建日期：2008-5-14
 */
public class AnonymousInnerImplFactory {

	public static Product makeProduct() {
		return new Product() {

			public void f() {
				System.out.println("public AnonymousInnerImpl.f()");
			}

			public void g() {
				System.out.println("public AnonymousInnerImpl.g()");
			}

			void u() {
				System.out.println("package AnonymousInnerImpl.u()");
			}

			protected void v() {
				System.out.println("protected AnonymousInnerImpl.v()");
			}

			private void w() {
				System.out.println("private AnonymousInnerImpl.w()");
			}
		};
	}
}
