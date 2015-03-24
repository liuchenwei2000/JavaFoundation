/**
 * 
 */
package object;

import java.util.Arrays;

/**
 * 方法的参数传递
 * <p>
 * 对象的传递和返回：</br>
 * <li>1，不要在相同作用域内生成同一个对象的多个引用</br>
 * 当一个引用传入某个方法之后，它仍然指向原来的对象。
 * <li>2，一般而言，调用方法是为了产生返回值，或者是为了改变被调用者(某对象)的状态</br>
 * 通常不会为了处理其参数而调用方法，最好避免修改参数。
 * <li>3，如果确实要在方法调用中修改参数，但是又不希望修改外部参数，
 * 那就应该在方法内部制作一份参数的副本，以保护原参数。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2007-10-8
 */
public class PassingParaDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a = 8;
		System.out.println("before changing : a = " + a);
		changeInt(a);
		System.out.println("after changing : a = " + a);
		System.out.println();

		String s = "out";
		System.out.println("before changing : s = " + s);
		changeString(s);
		System.out.println("after changing : s = " + s);
		System.out.println();

		Person p = new Person("old");
		System.out.println("before changing : p.getname() = " + p.getName());
		changeObject(p);
		System.out.println("after changing : p.getname() = " + p.getName());
		System.out.println();
		
		System.out.println("before changing : p.getname() = " + p.getName());
		changeObjectAttribute(p);
		System.out.println("after changing : p.getname() = " + p.getName());
		System.out.println();

		int[] array = { 2, 6, 4, 9, 8 };
		System.out.print("before changing : array = ");
		System.out.println(Arrays.toString(array));
		changeArray(array);
		System.out.print("after changing : array = ");
		System.out.println(Arrays.toString(array));
		System.out.println();

		System.out.print("before changing : array = ");
		System.out.println(Arrays.toString(array));
		changeArrayElement(array);
		System.out.print("after changing : array = ");
		System.out.println(Arrays.toString(array));
	}

	/**
	 * 对于基本类型的参数，方法传递的都是一个拷贝，这解释了Java为什么不能够实现经典swap(int a,int b)方法。
	 */
	private static void changeInt(int a) {
		// 这里的a只是参数a的一个拷贝，真正的参数并没有改变
		a = 0;
		System.out.println("inside changeInt : a = " + a);
	}

	/**
	 * 当一个引用传入某个方法之后，它仍然指向原来的对象
	 */
	private static void changeString(String s) {
		// 这里的引用也是一个参数的拷贝
		s = "changed";
		System.out.println("inside changeString : s = " + s);
	}

	/**
	 * 当一个引用传入某个方法之后，它仍然指向原来的对象
	 */
	private static void changeObject(Person p) {
		p = new Person("new");
		System.out.println("inside changeObject : p.getName() = " + p.getName());
	}

	/**
	 * 虽然不可以改变引用，但是可以改变它所引用的对象的属性
	 */
	private static void changeObjectAttribute(Person p) {
		p.setName("changed");
		System.out.println("inside changeObjectAttribute : p.getName() = "
				+ p.getName());
	}

	/**
	 * 如果传递的参数是数组，方法改变不了数组引用所代表的对象
	 */
	private static void changeArray(int[] array) {
		array = new int[3];
		array[0] = 0;
		array[1] = 0;
		array[2] = 0;
		System.out.print("inside changeArray : array = ");
		System.out.println(Arrays.toString(array));
	}

	/**
	 * 如果传递的参数是数组,可以改变数组中元素的值
	 */
	private static void changeArrayElement(int[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] = i;
		}
		System.out.print("inside changeArrayElement : array = ");
		System.out.println(Arrays.toString(array));
	}
}

class Person {

	private String name;

	public Person(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}