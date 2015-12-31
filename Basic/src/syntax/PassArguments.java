/**
 * 
 */
package syntax;

/**
 * 方法的参数传递演示
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2007-9-11
 */
public class PassArguments {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 基本类型参数
		int a = 3;
		System.out.println("before changing a = " + a);
		change(a);
		System.out.println("after changing a = " + a);
		
		System.out.println();
		
		// 引用类型参数
		Person p = new Person(50);
		System.out.println("before changing age of p is " + p.age);
		changeObject(p);
		System.out.println("after changing age of p is " + p.age);
	}
	
	/**
	 * 当方法的参数为基本类型的时候，完全是传值传递，对参数的改变只有在方法体内是存在的。
	 * 一旦方法返回，则参数消失，所有对它的修改也都消失。
	 */
	private static void change(int n) {
		n = 9;
		System.out.println("now in change() a = " + n);
	}
	
	
	/**
	 * 当方法的参数为引用类型(对象)的时候，其实也是一种传值传递，当方法返回时引用指向的对象不变。
	 * 但是可以在方法中通过这个引用修改指向对象的某些属性。
	 */
	private static void changeObject(Person p) {
		p.age = 100;
		p = new Person(0);
		System.out.println("in changeObject() age of p is " + p.age);
	}
}

class Person {
	
	int age;

	public Person(int newAge) {
		age = newAge;
	}
}
