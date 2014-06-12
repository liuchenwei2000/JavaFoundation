/**
 * 
 */
package object.clone;

/**
 * 成功克隆的典型实现演示
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2009-6-6
 */
public class SuccessfulClone {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyObject a = new MyObject(11);
		MyObject b = incrementPara(a);
		System.out.println("a == b: " + (a == b));
		System.out.println("a = " + a + ", b = " + b);
		MyObject c = new MyObject(47);
		MyObject d = incrementClonedPara(c);
		System.out.println("c == d: " + (c == d));
		System.out.println("c = " + c + ", d = " + d);
	}

	/**
	 * 返回参数对象执行increment()的引用
	 */
	public static MyObject incrementPara(MyObject v) {
		v.increment();
		return v;
	}

	/**
	 * 返回参数对象被克隆后的对象执行increment()的引用
	 */
	public static MyObject incrementClonedPara(MyObject v) {
		v = (MyObject) v.clone();
		v.increment();
		return v;
	}

}

/**
 * 实现了Cloneable接口
 */
class MyObject implements Cloneable {

	private int n;

	public MyObject(int n) {
		this.n = n;
	}

	/**
	 * <li>1，为了想clone()方法可以被访问，必须将其声明为public。
	 * <li>2，作为子类clone()操作的初始化部分，应该调用基类的clone()。
	 */
	public Object clone() {
		Object o = null;
		/*
		 * 必须将super.clone()置于 try块内，以捕获不应该发生的异常(因为已经实现了 Cloneable接口)。
		 */
		try {
			o = super.clone();
		} catch (CloneNotSupportedException e) {
			System.err.println("MyObject can't clone");
		}
		return o;
	}

	public int getValue() {
		return n;
	}

	public void setValue(int n) {
		this.n = n;
	}

	public void increment() {
		n++;
	}

	public String toString() {
		return Integer.toString(n);
	}
}