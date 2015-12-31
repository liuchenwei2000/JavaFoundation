/**
 * 
 */
package object.dispatch;

/**
 * 静态分派演示
 * <p>
 * Java通过方法重载(overload)支持静态分派。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2010-6-11
 */
public class StaticDispatchDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StaticDispatchDemo demo = new StaticDispatchDemo();
		Horse wh = new WhiteHorse();
		Horse bh = new BlackHorse();
		/*
		 * 打印结果如下：
		 * ride a horse.
		 * ride a horse.
		 * 
		 * 两次对ride()方法的调用传入的是不同的参量，也就是wh和bh。
		 * 它们虽然具有不同的真实类型，但是它们的静态类型都是一样的(Horse)。
		 * 重载的方法的分派是根据静态类型进行的，这个分派过程是在编译时期就完成了。
		 */
		demo.ride(wh);
		demo.ride(bh);
	}

	/** ride()方法由下面三个方法重载而成 **/
	
	public void ride(Horse horse) {
		System.out.println("ride a horse.");
	}

	public void ride(WhiteHorse horse) {
		System.out.println("ride a white horse.");
	}

	public void ride(BlackHorse horse) {
		System.out.println("ride a black horse.");
	}
}

abstract class Horse {
}

class WhiteHorse extends Horse {
}

class BlackHorse extends Horse {
}
