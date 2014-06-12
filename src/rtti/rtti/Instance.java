/**
 * 
 */
package rtti;

/**
 * instanceof�������Class.isInstance()���� 
 * <p>
 * �ؼ���instanceof����һ��booleanֵ���ж϶����ǲ���ĳ�����ӿڵ�ʵ����
 * Class.isInstance�����ṩ��һ�ֶ�̬����instanceof�������;����
 * (�����ĳ���������ǿ������ת����ʱ�򣬿�������instanceof�ж���ȷ��)
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2007-8-6
 */
public class Instance {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		test(new Base());
		test(new Derived());
	}
	
	static void test(Object x) {
		/*
		 * instanceof��isInstance()���ɽ����ȫ��ͬ��equals()��==Ҳ��ȫ��ͬ
		 * ����instanceof���Ǽ̳У���==�����Ǽ̳�
		 */
		System.out.println("Testing x is type " + x.getClass());
		System.out.println("x instance of Base " + (x instanceof Base));
		System.out.println("x instance of Derived " + (x instanceof Derived));
		System.out.println("x instance of MyInterface "
				+ (x instanceof MyInterface));
		System.out.println("Base.isInstance(x) " + Base.class.isInstance(x));
		System.out.println("Derived.isInstance(x) "
				+ Derived.class.isInstance(x));
		System.out.println("MyInterface.isInstance(x) "
				+ MyInterface.class.isInstance(x));
		System.out.println("x.getClass()==Base.class "
				+ (x.getClass() == Base.class));
		System.out.println("x.getClass()==Derived.class "
				+ (x.getClass() == Derived.class));
		System.out.println("x.getClass().equals(Base.class) "
				+ x.getClass().equals(Base.class));
		System.out.println("x.getClass().equals(Derived.class) "
				+ x.getClass().equals(Derived.class));
		System.out.println();
	}
}

class Base {
}

class Derived extends Base implements MyInterface {
}

interface MyInterface {
}