/**
 * 
 */
package generic;

/**
 * 泛型的继承
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2009-8-3
 */
public class InheritInGeneric {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Car<Father>、Car<Son>都是Car原生类型的子类，但是Car<Father>、Car<Son>之间没有任何关系
		// 这和Father和Son的继承层次没有任何关系
		Car<Father> c1 = new Car<Father>();
		System.out.println(c1.getClass());
		Car<Son> c2 = new Car<Son>();
		System.out.println(c2.getClass());
		
		// SmallCar<Father>、SmallCar<Son>都是SmallCar原生类型的子类
		SmallCar<Father> sc1 = new SmallCar<Father>();
		SmallCar<Son> sc2 = new SmallCar<Son>();
		// 证明SmallCar<Father>是Car<Father>的子类
		c1 = sc1;
		// 证明SmallCar<Son>是Car<Son>的子类
		c2 = sc2;
	}
}

class Car<T> {
}

class SmallCar<T> extends Car<T> {
}

class Father {
}

class Son extends Father {
}