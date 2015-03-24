/**
 * 
 */
package puzzler;

/**
 * 某方法中finally在return语句之后的控制流程
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2008-5-5
 */
public class FinallyAfterReturn {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i = 1; i < 4; i++) {
			test(i);
		}
	}

	/**
	 * 因为finally子句总会被执行，所以在一个方法中
	 * 可以从多个点返回，并且可以保证重要的清理工作仍旧会执行
	 */
	private static void test(int i) {
		try {
			System.out.println("in try : ");
			System.out.println(" i == 1");
			if (i == 1)
				return;
			System.out.println(" i == 2");
			if (i == 2)
				return;
			System.out.println(" i == 3");
			if (i == 3)
				return;
		} finally {
			System.out.println("in finally");
		}
	}
}