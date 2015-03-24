/**
 * 
 */
package object.dispatch;

/**
 * 动态分派演示
 * <p>
 * Java通过方法覆盖(override)支持动态分派。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2010-6-11
 */
public class DynamicDispatchDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "abc";
		Object o = "abc";
		// 尽管o的静态类型是Object，但是调用equals()方法时它还是调用了其真实类型String的equals()方法
		System.out.println("o.equals(s)? " + o.equals(s));
	}
}