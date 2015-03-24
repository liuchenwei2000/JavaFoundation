/**
 * 
 */
package inherit.difference;

/**
 * 嵌套接口演示
 * <p>
 * 接口可以在被定义在某个类里或者其他接口里。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2009-5-11
 */
class A {
	
	// 接口定义在类中
	interface B {
		void f();
	}
	// 实现该接口的类可以有不同的访问权限
	public class BImp implements B {
		public void f() {
		}
	}

	@SuppressWarnings("unused")
	private class BImp2 implements B {
		public void f() {
		}
	}
	// 类内定义的接口也可以有不同的访问权限
	public interface C {
		void f();
	}

	class CImp implements C {
		public void f() {
		}
	}

	@SuppressWarnings("unused")
	private class CImp2 implements C {
		public void f() {
		}
	}

	// 对于private接口，只可以在它的定义类内实现它
	private interface D {
		void f();
	}

	@SuppressWarnings("unused")
	private class DImp implements D {
		public void f() {
		}
	}

	public class DImp2 implements D {
		public void f() {
		}
	}

	public D getD() {
		return new DImp2();
	}

	private D dRef;

	public void receiveD(D d) {
		dRef = d;
		dRef.f();
	}
}
// 在接口中定义接口(可见性默认public)
// 实现某个接口时并不需要实现嵌套在其内部的任何接口
interface E {
	
	interface G {
		void f();
	}

	// 多余的 "public":
	public interface H {
		void f();
	}

	void g();
	
	// 不能有非public的接口定义
	// private interface I {}
}

public class NestingInterfaces {
	
	public class BImp implements A.B {
		public void f() {
		}
	}

	class CImp implements A.C {
		public void f() {
		}
	}

	// 对于private接口，除了可以在该接口定义的类内实现该接口外
	// 其他地方都不可以实现这个接口
	// class DImp implements A.D {
	// public void f() {}
	// }
	
	class EImp implements E {
		public void g() {
		}
	}

	class EGImp implements E.G {
		public void f() {
		}
	}

	class EImp2 implements E {
		public void g() {
		}

		class EG implements E.G {
			public void f() {
			}
		}
	}

	public static void main(String[] args) {
		A a = new A();
		// 不能访问到A.D
		// A.D ad = a.getD();
		
		// 只能返回A.D
		// A.DImp2 di2 = a.getD();
		
		// 不能访问到私有接口，所以不能调用其方法
		// a.getD().f();
		
		// A.DImp2只能被其自身所使用，无法表达它实现了一个private接口A.D
		// 以下摘自Thinking in Java 3rd
		// 实现一个private接口只是一种方式，他可以强制该接口中的方法定义不要
		// 添加任何类型信息(也就是说，不允许向上转型)
        /**
         * A.DImp2 can only be used as itself. You are not allowed to mention the fact that it 
         * implements the private interface D, so implementing a private interface is a way to force 
         * the definition of the methods in that interface without adding any type information 
         * (that is, without allowing any upcasting).  
         * */
		@SuppressWarnings("unused")
		A.DImp2 di2 = (A.DImp2)a.getD();
		// 只有如下方式是正确的调用
		A a2 = new A();
		a2.receiveD(a.getD());
	}
}