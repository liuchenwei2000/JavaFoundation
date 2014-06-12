/**
 * 
 */
package object.clone.inherit;

/**
 * 控制克隆能力演示
 * <p>
 * 如果希望一个类可以被克隆：</br>
 * <li>1.实现 Cloneable 接口。
 * <li>2.覆盖 clone()。
 * <li>3.在类的 clone()中调用 super.clone()。
 * <li>4.在类的 clone()中捕获异常。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2009-6-8
 */
public class ControllClone {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Ordinary[] objects = { new IsCloneable(), new WrongClone(),
				new NoMore(), new TryMore(), new BackOn(), new ReallyNoMore(), };
		// This won't compile; clone() is protected in Object:
		// Ordinary x = new Ordinary();
		// x = (Ordinary)x.clone();
		for (int i = 0; i < objects.length; i++){
			tryToClone(objects[i]);
			System.out.println();			
		}
	}

	private static Ordinary tryToClone(Ordinary object) {
		String clazz = object.getClass().getSimpleName();
		System.out.println("Attempting " + clazz);
		Ordinary x = null;
		if (object instanceof Cloneable) {
			try {
				x = (Ordinary) ((IsCloneable) object).clone();
				System.out.println("Cloned " + clazz);
			} catch (CloneNotSupportedException e) {
				System.out.println("Could not clone " + clazz);
			}
		} else {
			System.out.println("Doesn't implement Cloneable");
		}
		return x;
	}
}

/**
 * 1.不关心。
 * <p>
 * 并不做任何克隆操作，即使类不可克隆，但是只要愿意，就能向其子类添加克隆能力。
 * 这只有在缺省的Object.clone()能够合理地处理类中所有属性时才起作用。
 * <p>
 * Ordinary类代表常见的类型：它不是"关闭"克隆能力，而是不支持也不阻止克隆。
 * 但是如果有一个Ordinary子类的对象，其引用向上转型为Ordinary后，就无法分辨它是否可克隆。
 */
class Ordinary {
}

/**
 * WrongClone类演示了实现克隆机制的错误方式。
 * 它以 public 方式重载了Object.clone()，但是没有实现Cloneable。
 * 因此调用 super.clone()时(最终会调用Object.clone())会抛出 CloneNotSupportException，所以无法克隆。
 */
class WrongClone extends Ordinary {
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

/**
 * 2.支持clone()。
 * <p>
 * 按照标准的惯例：实现 Cloneable 接口、重载 clone()方法。
 * 在重载的clone()中，调用 super.clone()，并捕获所有异常。
 * <p>
 * IsCloneable 执行了所有正确的操作：重载 clone()方法、实现 Cloneable 接口。
 * 只是异常抛给调用者进行处理。
 */
class IsCloneable extends Ordinary implements Cloneable {
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

/**
 * 3.有条件地支持克隆。
 * <p>
 * 如果类包含其他对象的引用，它们不一定是可克隆的，但类的clone()方法应该试着克隆它们。
 * 如果抛出异常，只需将异常传给程序员。
 */

/**
 * 4.不实现 Cloneable 接口，但是以 protected 方式重载 clone()方法，为所有属性创建正确的复制行为。
 * <p>
 * 于是该类的任何子类，都可以重载clone()并调用super.clone()产生正确的复制行为。
 * 你的 clone()可以(并且应该)调用super.clone()，即使 super.clone()预期的是个 Cloneable 对象。
 * 没人会直接对你的类的对象调用clone()，只能通过其子类才行，而要想让它正常工作，其子类必须实现Cloneable 接口。
 */

/**
 * 5.不实现 Cloneable 接口，重载 clone()使之抛出异常，以阻止克隆操作。
 * <p>
 * 只有此类的所有子类，都在各自的clone()中调用 super.clone()，这种阻止克隆的方法才起作用。
 * <p>
 * NoMore 类尝试"关闭"克隆能力，采用了 Java 设计者建议的方式：
 * 在子类的 clone()中抛出CloneNotSupportedException。
 * 当子类的 clone()调用 super.clone()时，会抛出异常，阻止克隆。
 */
class NoMore extends IsCloneable {
	
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}

/**
 * TryMore 类的 clone()调用 super.clone()时，会抛出异常，阻止克隆。
 */
class TryMore extends NoMore {
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

/**
 * BackOn 使用独立的 duplication()复制当前对象，在clone()中它取代了 super.clone()。
 * 这不会抛出异常，而且新的类也是可克隆的。因此，无法依赖抛出异常来防止克隆能力。
 */
class BackOn extends NoMore {
	
	private BackOn duplicate(BackOn b) {
		return new BackOn();
	}

	public Object clone() {
		return duplicate(this);
	}
}

/**
 * 6.将你的类声明为final以阻止克隆。
 * <p>
 * 如果它的任何父类(祖先类)都没有重载clone()，那么此方法就行不通了。
 * 如果父类重载了clone()，那么让你的类再次重载clone()，并抛出CloneNotSupportedException。
 * 将类声明为final，是唯一有保证的防止克隆的方法。
 * <p>
 * ReallyNoMore 示范了唯一不会有问题的解决方案。类声明为final，就不可以被继承了。
 * 这意味着，如果在 final 的类中，clone()方法抛出异常，由于它不会被子类修改，所以肯定能阻止克隆。
 */
final class ReallyNoMore extends NoMore {
}