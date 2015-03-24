/**
 * 
 */
package puzzler;

/**
 * 私有方法覆盖
 *
 * @author 刘晨伟
 *
 * 创建日期：2008-4-8
 */
public class PrivateOverride {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PrivateOverride p = new Derived();
		p.f();
		/*
		 * 实际输出是"private f() in PrivateOverride"
		 * 这是因为private方法是final方法，对子类是屏蔽的。
		 * Derived类中的f()方法是一个全新的方法，既然基类的f()方法子类不可见，也就不存在覆盖。
		 * 只有非private方法才可以被覆盖，但是还是要注意隐藏private方法的现象。
		 * 虽然编译器不会报错，但是也不会按照期望来执行，对于基类中的private方法，在子类中最好采用不同的名字
		 */
	}

	private void f() {
		System.out.println("private f() in PrivateOverride");
	}
}

class Derived extends PrivateOverride {
	
	public void f() {
		System.out.println("public f() in Derived");
	}
}