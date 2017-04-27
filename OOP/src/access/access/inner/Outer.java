/**
 * 
 */
package access.inner;

/**
 * 外部类
 * <p>
 * 在Java中，当生成一个内部类的对象时，此对象与制造它的外部类对象保持着联系。
 * 因此该内部类对象可以访问其外部类对象的所有成员，包括private成员。
 * 而该内部类对象对于其他类的对象的访问，遵照常规的访问权限控制。
 * <p>
 * 这里需要探讨的是，外部类以及其他类的对象可以如何访问到某个内部类对象，即内部类的可见性问题。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2009-7-13
 */
public class Outer {

	/**
	 * 结论：</br>
	 * 一个内部类，不论是何种访问权限，其具有的成员和方法也不论是何种访问权限，
	 * 在外部类中(注意：不是对象)被使用时，对于外部类对象而言是完全可见的。
	 */
	public static void main(String[] args) {
		Outer out = new Outer();
		// 可以通过两种方式创建内部类的实例：
		// 1，使用外部对象 new 一个内部类实例
		// 可以得到 private 内部类的实例，并且可以访问它的private成员和private方法
		// 当然default、protected和public的成员和方法也都可以访问
		Outer.PrivateInner privateInner = out.new PrivateInner();
		privateInner.privateField = 0;
		privateInner.privateMethod();

		// 2，使用外部类方法getInnerInstance()
		// 也可以访问所有内部类的所有成员和方法
		Outer.PrivateInner privateInner2 = out.getPrivateInner();
		privateInner2.privateField = 0;
		privateInner2.privateMethod();
	}

	/******************************************
	 * 在外部类中提供了得到内部类实例的public方法
	 ******************************************/
	
	public PrivateInner getPrivateInner() {
		return new PrivateInner();
	}

	public DefaultInner getDefaultInner() {
		return new DefaultInner();
	}

	public ProtectedInner getProtectedInner() {
		return new ProtectedInner();
	}

	public PublicInner getPublicInner() {
		return new PublicInner();
	}

	/********************************************************************
	 * 下面四个内部类分别具有不同的访问权限控制(private,default,protected,public)
	 * 并且每个类都实现了公有接口IAccessable，类内部都包含四个不同访问权限的成员和方法
	 ********************************************************************/
	
	/**
	 * private内部类
	 */
	private class PrivateInner implements IAccessable {

		private int privateField;
		int defaultField;
		protected int protectedField;
		public int publicField;

		private void privateMethod() {
		}

		void defaultMethod() {
		}

		protected void protectedMethod() {
		}

		public void publicMethod() {
		}
	}

	/**
	 * default内部类
	 */
	class DefaultInner implements IAccessable {

		private int privateField;
		int defaultField;
		protected int protectedField;
		public int publicField;

		private void privateMethod() {
		}

		void defaultMethod() {
		}

		protected void protectedMethod() {
		}

		public void publicMethod() {
		}
	}

	/**
	 * protected内部类
	 */
	protected class ProtectedInner implements IAccessable {

		private int privateField;
		int defaultField;
		protected int protectedField;
		public int publicField;

		public ProtectedInner(){}
		
		private void privateMethod() {
		}

		void defaultMethod() {
		}

		protected void protectedMethod() {
		}

		public void publicMethod() {
		}
	}

	/**
	 * public内部类
	 */
	public class PublicInner implements IAccessable {

		private int privateField;
		int defaultField;
		protected int protectedField;
		public int publicField;

		private void privateMethod() {
		}

		void defaultMethod() {
		}

		protected void protectedMethod() {
		}

		public void publicMethod() {
		}
	}
}
