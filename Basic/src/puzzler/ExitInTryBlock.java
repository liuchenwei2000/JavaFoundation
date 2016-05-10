/**
 * 
 */
package puzzler;

/**
 * 在try块中有System.exit(0)语句时的控制流程示例
 * 
 * @author 刘晨伟
 *
 * 创建日期：2007-11-7
 */
public class ExitInTryBlock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * System.exit(0)操作将会停止一切线程然后推出虚拟机，
		 * 所以它不会再去执行finally中的任何操作。
		 */
		try {
			System.out.println("Goodbye!");
			System.exit(0);
		} finally {
			System.out.println("finally");
		}
	}
}
