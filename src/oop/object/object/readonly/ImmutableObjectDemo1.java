/**
 * 
 */
package object.readonly;

/**
 * 不可变对象演示类
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2009-6-8
 */
public class ImmutableObjectDemo1 {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ImmutableObject x = new ImmutableObject(47);
		System.out.println("before println(x)：x = " + x.read());
		println(x);
		System.out.println("after println(x)：x = " + x.read());
	}
	
	private static void println(ImmutableObject io) {
		ImmutableObject multiply = io.multiply(4);
		System.out.println("io = " + io.read());
		System.out.println("multiply = " + multiply.read());
	}
}

/** 
 * 不可变对象 
 */
class ImmutableObject {

	/* 所有数据都是private的，甚至是final的 */
	private int value;

	public ImmutableObject(int value) {
		this.value = value;
	}

	/* 没有修改private数据的方法 */
	public int read() {
		return value;
	}

	public boolean nonzero() {
		return value != 0;
	}

	/**
	 * 创建了一个新的对象返回，并没有修改原对象
	 */
	public ImmutableObject multiply(int multiplier) {
		return new ImmutableObject(value * multiplier);
	}
}
