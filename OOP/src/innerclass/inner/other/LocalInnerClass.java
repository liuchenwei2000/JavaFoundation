/**
 * 
 */
package inner.other;

/**
 * 局部内部类演示
 * <p>
 * 可以在代码块中创建内部类，典型的方式是在一个方法体的里面创建。
 * 局部内部类不能有访问修饰符，它不是外部类的一部分。
 * 但是它可以访问当前代码块的常量，以及外部类的所有成员。
 * <p>
 * 使用局部内部类而不使用匿名内部类的原因有：</br>
 * <li>1，需要一个命名的构造器，或者需要重载构造器；
 * <li>2，需要不止一个该内部类的对象。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2008-4-18
 */
public class LocalInnerClass {
	
	private int count = 0;
	
	/**
	 * 局部内部类展示
	 */
	public Counter getLocalCounter(final String name) {
		
		class LocalCounter implements Counter {
			
			/**
			 * 局部内部类可以有自己的构造器
			 */
			public LocalCounter() {
				System.out.println("LocalCounter()");
			}

			public int next() {
				System.out.println(name);
				return count++;
			}
		}
		return new LocalCounter();
	}
	
	/**
	 * 匿名内部类展示
	 */
	public Counter getCounter(final String name) {
		
		return new Counter() {
			/**
			 * 匿名内部类不能有自己的构造方法，只能使用实例初始化的方法进行初始操作。
			 */
			{
				System.out.println("AnonymousCounter()");
			}

			public int next() {
				System.out.println(name);
				return count++;
			}
		};
	}
}

interface Counter{
	
	int next();
}
