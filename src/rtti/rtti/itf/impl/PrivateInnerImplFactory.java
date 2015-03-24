/**
 * 
 */
package rtti.itf.impl;

import rtti.itf.Interface;

/**
 * ����Interface����˽���ڲ���ʵ�֣��Ĺ�����
 * <p>
 * ʹ����ʵ�ֽӿ�Interface��PrivateInnerImpl�࣬PrivateInnerImpl����˽���ڲ��࣬����������Ϣ�����Ρ�
 * 
 * @author ����ΰ
 * @see rtti.itf.demo.PrivateInnerImplDemo
 * 
 * �������ڣ�2008-5-14
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