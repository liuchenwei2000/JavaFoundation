/**
 * 
 */
package rtti;

import inherit.difference.Animal;
import inherit.difference.IRunnable;

/**
 * Class类演示
 * <p>
 * Class引用总是指向某个Class对象，它可以制造类的实例，
 * 并包含可作用于这些实例的所有方法代码，还包含该类的静态成员。
 * Class类最常用方法是getClass()和newInstance()。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2007-8-5
 */
public class ClassDemo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Human human = new Human();
		// 获得一个Class对象的方法有三个
		// 1,请求一个对象提供与它对应的类对象
		Class<?> cl = human.getClass();
		System.out.println(cl.getName());
		// 2,使用静态forName()方法请求与一个字符串对应的类对象
		String className = "rtti.Human";
		try {
			// 若类className没有加载这个方法会加载它
			cl = Class.forName(className);
			System.out.println(cl.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 3,使用类字面常量,即 T.class 就是相符的类对象
		// 这样做不仅更简单，而且更安全，因为它在编译时就会受到检查。
		// 并且它根除了对forName()方法的调用，所以也更高效。
		// 类字面常量不仅可以应用于普通的类，也可以应用于借口、数组以及基本数据类型。
		cl = int[].class;
		System.out.println(cl.getName());
		// JVM为每个类型管理一个Class对象，可以利用  == 实现两个类对象比较的操作
		if (cl == int[].class)
			System.out.println("cl is int[].class");

		/*
		 * 动态创建类的一个实例的方法 
		 * 
		 * 这个方法将会创建一个指定类的新实例 ，调用的是无参构造方法,并初始化新建对象。
		 */
		try {
			/*
			 * 一般将forName和newInstance配合使用
			 * 
			 * 根据字符串代表的类名来创建一个对象，它调用的是默认的构造器(没有参数的构造器)。
			 * 如果类没有无参构造器则会抛出InstantiationException；
			 * 如果类有无参构造器但是private的则会抛出 IllegalAccessException，这表示违反了Java安全机制。
			 */
			// 这种方式只能使用Object来引用对象
			Object obj = Class.forName(className).newInstance();
			System.out.println(obj);
			// 使用了泛型的方式可以直接使用精确类型引用对象
			Class<Human> clazz = Human.class;
			Human hm = clazz.newInstance();
			System.out.println(hm);
			// 不能使用Class<Animal>来引用clazz.getSuperclass()
			Class<? super Human> supers = clazz.getSuperclass();
			Object base = supers.newInstance();// 只能使用Object来引用
			System.out.println(base);
			
			/*
			 * 如果想向被调用的类的构造器提供参数，就要使用Constructor类中的newInstance方法了
			 */
			// class.getInterfaces()方法返回的是Class对象直接实现的接口，不含其父类实现的接口
			Class<?>[] itfs = Human.class.getInterfaces();
			for (Class<?> itf : itfs) {
				System.out.println("Human.class directly implements " + itf.getName());
			}
			// 判定Class对象所表示的类(接口)与指定的Class参数所表示的类(接口)是否相同
			// (或是否是Class参数的超类(超接口))
			boolean isRunnable = IRunnable.class.isAssignableFrom(Human.class);
			if (isRunnable) {
				System.out.println("Human.class implements "
						+ IRunnable.class.getName());
			} else {
				System.out.println("Human.class not implements "
						+ IRunnable.class.getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String toString(){
		return "ClassDemo 对象：" + super.toString();
	}
}

interface Sexable {

	public static final int MALE = 0;// 雄性
	public static final int FEMALE = 1;// 雌性
}

class Human extends Animal implements Sexable {
}
