/**
 * 
 */
package object;

/**
 * 对象别名演示
 * <p>
 * 别名效应是指多个引用指向同一个对象。</br>
 * 当某人修改那个对象时，别名带来的问题就会显现出来：</br>
 * 如果此对象还有其他的引用指向它，而使用那些引用的人根本没想到对象会有变化，
 * 定然会对此感到十分诧异，所以
 * <li><strong>不要在相同作用域内生成同一个对象的多个引用</strong>
 * <li><strong>将引用作为参数传递时，它会自动被别名化(Java的工作方式)</strong>
 * <li><strong>在方法内创建的局部引用能够修改"外部的对象"</strong>
 *
 * @author 刘晨伟
 *
 * 创建日期：2009-6-4
 */
public class ObjectAlias {
	
	private int i;

	public ObjectAlias(int i) {
		this.i = i;
	}

	/**
	 * 参数引用可以在方法体中修改它所指向的对象
	 * <p>
	 * 调用方法是为了产生返回值，或者为了改变被调用者的状态。
	 * 通常不会为了处理其参数而调用方法，那被称作"为了副作用而调用方法"。
	 * 方法如果会修改其参数，则必须清楚地向调用者说明它的使用方式以及潜在危险。
	 * <p>
	 * 如果确实要在方法调用中修改参数，但又不希望修改外部参数。
	 * 那么就应该在方法内部制作一份参数的副本，以保护原参数。
	 */
	private static void method(ObjectAlias ref) {
		ref.i++;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// x、y指向同一个对象
		ObjectAlias x = new ObjectAlias(7);
		ObjectAlias y = x;
		System.out.println("x: " + x.i);
		System.out.println("y: " + y.i);
		System.out.println("Incrementing x");
		x.i++;
		System.out.println("x: " + x.i);
		System.out.println("y: " + y.i);
		
		ObjectAlias z = new ObjectAlias(1);
		System.out.println("z: " + z.i);
		System.out.println("Calling method(z)");
		method(z);
		System.out.println("z: " + z.i);
	}
}