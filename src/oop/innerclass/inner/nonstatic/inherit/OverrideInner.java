/**
 * 
 */
package inner.nonstatic.inherit;

/**
 * 内部类的覆盖演示
 * <p>
 * 创建一个内部类，然后继承其外部类并重新定义此内部类时。
 * 覆盖内部类并不像覆盖外部类方法那样，覆盖是无用的。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2008-4-18
 */
public class OverrideInner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new BigEgg();
	}
}

class Egg {
	
	@SuppressWarnings("unused")
	private Yolk yolk;

	protected class Yolk {
		public Yolk() {
			System.out.println("Egg.Yolk()");
		}
	}

	public Egg() {
		System.out.println("New Egg()");
		yolk = new Yolk();
	}
}

class BigEgg extends Egg {
	
	/**
	 * 当继承某个外部类的时候，内部类并没有发生什么变化。
	 * 这两个内部类是完全独立的两个实体，各自在自己的命名空间内。
	 */
	public class Yolk {
		
		public Yolk() {
			System.out.println("BigEgg.Yolk()");
		}
	}
}