/**
 * 
 */
package puzzler;

/**
 * 在try块中有return语句时的控制流程示例
 * 
 * @author 刘晨伟
 *
 * 创建日期：2007-11-7
 */
public class ReturnInTryBlock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (decision())
			System.out.println("return in try");
		else
			System.out.println("return in finally");
		testReturn();
	}

	/**
	 * 一条语句或一个语句块在它抛出了一个异常，或者对某个封闭语句执行了一个break、continue或者return时，
	 * 将发生意外结束，因为它们阻止程序去按顺序执行下面的语句。
	 * 
	 * 在try语句块和finally语句块都意外结束时，try语句块中引发意外结束的原因将被丢弃，
	 * 而整个try-finally语句意外结束的原因将与finally语句块意外结束的原因相同。
	 * 
	 * 总之，每一个finally语句块都应该正常结束，除非抛出的是不受查的异常。
	 * 也就是不要用return、break、continue或throw来退出一个finally语句块，
	 * 也不要将一个受查异常传到finally语句块之外去。 
	 * 
	 * 可以这样理解： 程序尝试着(try)返回(return)true 但是最终(finally)返回(return)false
	 */
	@SuppressWarnings("finally")
	private static boolean decision() {
		try {
			return true;
		} finally {
			return false;
		}
	}

	/**
	 * 在try语句块中有return作为结束该方法的标志时，在控制流到达return时将会先执行finally语句块，然后在执行return语句结束方法。
	 */
	private static void testReturn() {
		try {
			System.out.println("try before return");
			return;
		} finally {
			System.out.println("finaly");
		}
	}
}