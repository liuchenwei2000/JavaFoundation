/**
 * 
 */
package object.dispatch;

/**
 * 静态多分派和动态单分派演示
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2010-6-11
 */
public class DispatchDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Father father = new Father();
		Father son = new Son();
		// 静态多分派
		father.operation(1);// 调用接收int类型参数的版本
		father.operation("1");// 调用接收String类型参数的版本
		// 动态单分派
		father.action();// 调用Father.action()
		son.action();// 调用Son.action()
	}
}

class Father {

	public void operation(int a) {
		System.out.println("This is an integer " + a);
	}

	public void operation(String s) {
		System.out.println("This is an string " + s);
	}

	public void action() {
		System.out.println("Father.action()");
	}
}

class Son extends Father {

	public void action() {
		System.out.println("Son.action()");
	}
}