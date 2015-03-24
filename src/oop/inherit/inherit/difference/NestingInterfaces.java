/**
 * 
 */
package inherit.difference;

/**
 * Ƕ�׽ӿ���ʾ
 * <p>
 * �ӿڿ����ڱ�������ĳ��������������ӿ��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2009-5-11
 */
class A {
	
	// �ӿڶ���������
	interface B {
		void f();
	}
	// ʵ�ָýӿڵ�������в�ͬ�ķ���Ȩ��
	public class BImp implements B {
		public void f() {
		}
	}

	@SuppressWarnings("unused")
	private class BImp2 implements B {
		public void f() {
		}
	}
	// ���ڶ���Ľӿ�Ҳ�����в�ͬ�ķ���Ȩ��
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

	// ����private�ӿڣ�ֻ���������Ķ�������ʵ����
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
// �ڽӿ��ж���ӿ�(�ɼ���Ĭ��public)
// ʵ��ĳ���ӿ�ʱ������Ҫʵ��Ƕ�������ڲ����κνӿ�
interface E {
	
	interface G {
		void f();
	}

	// ����� "public":
	public interface H {
		void f();
	}

	void g();
	
	// �����з�public�Ľӿڶ���
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

	// ����private�ӿڣ����˿����ڸýӿڶ��������ʵ�ָýӿ���
	// �����ط���������ʵ������ӿ�
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
		// ���ܷ��ʵ�A.D
		// A.D ad = a.getD();
		
		// ֻ�ܷ���A.D
		// A.DImp2 di2 = a.getD();
		
		// ���ܷ��ʵ�˽�нӿڣ����Բ��ܵ����䷽��
		// a.getD().f();
		
		// A.DImp2ֻ�ܱ���������ʹ�ã��޷������ʵ����һ��private�ӿ�A.D
		// ����ժ��Thinking in Java 3rd
		// ʵ��һ��private�ӿ�ֻ��һ�ַ�ʽ��������ǿ�Ƹýӿ��еķ������岻Ҫ
		// ����κ�������Ϣ(Ҳ����˵������������ת��)
        /**
         * A.DImp2 can only be used as itself. You are not allowed to mention the fact that it 
         * implements the private interface D, so implementing a private interface is a way to force 
         * the definition of the methods in that interface without adding any type information 
         * (that is, without allowing any upcasting).  
         * */
		@SuppressWarnings("unused")
		A.DImp2 di2 = (A.DImp2)a.getD();
		// ֻ�����·�ʽ����ȷ�ĵ���
		A a2 = new A();
		a2.receiveD(a.getD());
	}
}