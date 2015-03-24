/**
 * 
 */
package polymorphism;

/**
 * ��̬��ʾ
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2007-8-28
 */
public class PolymorphismDemo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Animal a = new Dog();
		a.sayHi();// aʵ����һ��Dog
		Animal b = new Bulldog();
		b.sayHi();// bʵ����һ��Bulldog
		Dog dog = (Dog) b;
		dog.sayHi();// dogʵ������һ��Bulldog
		check(dog);
		Bulldog bulldog = (Bulldog) b;
		check(bulldog);
	}

	private static void check(Dog dog) {
		System.out.println("check dog " + dog.getName() + ". ");
	}

	private static void check(Bulldog bulldog) {
		System.out.println("check bulldog " + bulldog.getName() + ". ");
	}
}

interface Animal {
	
	void sayHi();

	String getName();
}

class Dog implements Animal {
	
	public String getName() {
		return "Bob";
	}

	/**
	 * �˴�������˽�е�
	 */
	private String bark() {
		return "wang-wang";
	}

	public void sayHi() {
		System.out.println("I am " + getName() + ". " + bark());
	}
}

class Bulldog extends Dog {
	
	@Override
	public String getName() {
		return "Mike";
	}

	/**
	 * ��ʵ�������û��Override����÷�������Ϊ��������ͼ̳в��������˽�г�Ա��
	 */
	@SuppressWarnings("unused")
	private String bark() {
		return "WOO-WOO";
	}
	
	/*
	 * // ��ʹ������������еĸ���Ҳ����Ӱ����� 
	 * public void sayHi() 
	 * { 
	 * super.sayHi(); 
	 * }
	 */
}