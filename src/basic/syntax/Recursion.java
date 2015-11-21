/**
 * 
 */
package syntax;

/**
 * 递归演示类
 * <p>
 * 递归算法的一般要求：
 * <li>1，定义的中心是if-else语句或者switch语句
 * <li>2，至少有一个分支语句有递归调用
 * <li>3，至少有一个分支语句没有递归调用(停止情形)
 *
 * @author 刘晨伟
 *
 * 创建日期：2008-3-21
 */
public class Recursion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 6;
		System.out.println(n + "!" + " = " + fatorial(n));
	}

	/**
	 * 阶乘方法，递归实现
	 */
	public static int fatorial(int n) {
		if (n == 0 || n == 1)
			return 1;
		else
			return n * fatorial(n - 1);
	}
}
