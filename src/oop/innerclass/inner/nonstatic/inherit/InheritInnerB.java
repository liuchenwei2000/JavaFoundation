/**
 * 
 */
package inner.nonstatic.inherit;

/**
 * 内部类的继承方式之二
 * <p>
 * <strong>内部类继承会导致结构混乱不易读，应避免这种设计</strong>
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2007-11-12
 */
public class InheritInnerB extends Outer {
	
	class ExtendedInner extends Inner {

	}

	// 这样做使得当一个外部类对象被创建的时候内部类对象能够初始化，因为内部类对象需要绑定一个外部类对象。
	Inner inner = new ExtendedInner();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InheritInnerB ii = new InheritInnerB();
		System.out.println(ii);
	}
}