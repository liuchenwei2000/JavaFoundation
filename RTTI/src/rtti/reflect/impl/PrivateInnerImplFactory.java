/**
 * 
 */
package rtti.reflect.impl;

import rtti.reflect.demo.Product;
import rtti.reflect.demo.PrivateInnerImplDemo;

/**
 * 构造 Product 对象（私有内部类实现）的工厂类
 * <p>
 * 使用了实现接口 Product 的PrivateInnerImpl类，PrivateInnerImpl类是私有内部类，对外类型信息被屏蔽。
 * 
 * @author 刘晨伟
 * @see PrivateInnerImplDemo
 * 
 * 创建日期：2008-5-14
 */
public class PrivateInnerImplFactory {

	public static Product makeProduct() {
		return new PrivateInnerImpl();
	}

	private static class PrivateInnerImpl implements Product {

		public void f() {
			System.out.println("public PrivateInnerImpl.f()");
		}

		public void g() {
			System.out.println("public PrivateInnerImpl.g()");
		}

		void u() {
			System.out.println("package PrivateInnerImpl.u()");
		}

		protected void v() {
			System.out.println("protected PrivateInnerImpl.v()");
		}

		private void w() {
			System.out.println("private PrivateInnerImpl.w()");
		}
	}
}
