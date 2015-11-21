/**
 * 
 */
package object.clone.inherit;

/**
 * Object.clone()继承的细节
 * <p>
 * SonInt 继承自 Int，并添加了新的基本类型成员：int j。
 * 也许需要覆盖clone()方法，以确保 j 也被复制，但事情并非如此。
 * 当 Int 的clone()因 SonInt 的 clone()而被调用时，它又调用了Object.clone()。
 * 后者会判断它操作的是 SonInt，并且复制 SonInt 对象的所有位(bit)。
 * 只要没有向子类中添加需要克隆的对象，那么无论clone()定义于继承层次中多深的位置。
 * 只需调用Object.clone()一次，就能完成所有必要的复制。
 * 
 * @author 刘晨伟
 *
 * 创建日期：2009-6-6
 */
public class ObjectCloneInheritDetail {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SonInt si = new SonInt(1);
		SonInt clone = (SonInt) si.clone();
		System.out.println(clone);
	}
}

class SonInt extends Int {

	private int j;

	public SonInt(int j) {
		super(j);
		this.j = j;
	}

	public String toString() {
		return super.toString() + " j = " + j;
	}
}

class Int implements Cloneable {

	private int i;

	public Int(int i) {
		this.i = i;
	}

	public void increment() {
		i++;
	}

	public Object clone() {
		Object o = null;
		try {
			o = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return o;
	}

	public String toString() {
		return "i = " + i;
	}
}
