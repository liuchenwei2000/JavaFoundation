/**
 * 
 */
package object;

/**
 * Object类方法示例
 * 
 * @author 刘晨伟
 *
 * 创建日期：2007-11-9
 */
public class ObjectClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Object obj = new Object();
		// 返回对象的运行时类
		System.out.println(obj.getClass());
		// 返回该对象的字符串表示(为类全路径+@+16进制hashCode)
		System.out.println(obj.toString());
		// toString()格式规范：
		// 类的名字，随后是一对方括号括起来的域值。
		// 如：getClass().getName() + "[name=" + name + ",age=" + age + "]";
	}
}
