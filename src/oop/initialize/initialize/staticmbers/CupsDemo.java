/**
 * 
 */
package initialize.staticmbers;

/**
 * 演示类
 * 
 * @author 刘晨伟
 *
 * 创建日期：2007-8-28
 */
public class CupsDemo {
	
	// static Cups x=new Cups();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Inside main()");
		Cups.c1.f(99);
		// 因为在初始化过程中创建了两个Cup对象
		System.out.println("当前创建Cup对象数： " + Cup.getCounter());
		// 输出为：
		// Inside main()
		// Cup(1)
		// Cup(2)
		// f(99)
		// 当前创建Cup对象数： 2
	}
}
