/**
 * 
 */
package object.clone;

/**
 * Object.clone()方法的效果演示
 * <p>
 * 用于证明Object.clone()是浅克隆。
 * 
 * @author 刘晨伟
 *
 * 创建日期：2009-6-6
 */
public class CloneInObjectClass {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IntObject io = new IntObject(1);
		IntObject copy = (IntObject) io.clone();
		io.increment();
		System.out.println("io : " + io);
		System.out.println("copy : " + copy);
		System.out.println("io == copy : " + (io == copy));
	}
}

class IntObject implements Cloneable {

	private Int i;

	public IntObject(int i) {
		this.i = new Int(i);
	}

	public void increment() {
		i.increment();
	}

	public String toString() {
		return i.toString();
	}
	
	public Object clone() {
		Object o = null;
		try {
			o = super.clone();
		} catch (CloneNotSupportedException e) {
			System.err.println("IntObject can't clone");
		}
		return o;
	}
}