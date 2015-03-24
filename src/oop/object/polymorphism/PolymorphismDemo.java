/**
 * 
 */
package polymorphism;

/**
 * 多态演示
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2007-8-28
 */
public class PolymorphismDemo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Animal a = new Dog();
		a.sayHi();// a实际是一个Dog
		Animal b = new Bulldog();
		b.sayHi();// b实际是一个Bulldog
		Dog dog = (Dog) b;
		dog.sayHi();// dog实际上是一个Bulldog
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
	 * 此处方法是私有的
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
	 * 其实这个方法没有Override父类该方法，因为子类根本就继承不到父类的私有成员。
	 */
	@SuppressWarnings("unused")
	private String bark() {
		return "WOO-WOO";
	}
	
	/*
	 * // 即使对这个方法进行的覆盖也不会影响输出 
	 * public void sayHi() 
	 * { 
	 * super.sayHi(); 
	 * }
	 */
}