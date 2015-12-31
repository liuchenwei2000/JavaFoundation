/**
 * 
 */
package exception;

/**
 * 重新抛出异常演示
 * <p>
 * 重抛异常会把异常抛给上一级环境中的异常处理程序，同一个try块后的其他catch字句将会被忽略。
 * 异常对象的所有信息都得以保持，所以高一级环境中捕获此异常的处理程序可以得到它的所有信息。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2008-4-21
 */
public class RethrowException {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			notFillStackTrace();
		} catch (Exception e) {
			System.out.println("main: printStackTrace()");
			e.printStackTrace(System.out);
		}
		try {
			fillStackTrace();
		} catch (Exception e) {
			System.out.println("main: printStackTrace()");
			e.printStackTrace(System.out);
		}
	}

	private static void original() throws Exception {
		System.out.println("originating the exception in original()");
		throw new Exception("Message : thrown from original()");
	}
	
	/**
	 * 如果只是把当前异常对象重新抛出，那么printStackTrace()方法 
	 * 显示的是原来异常抛出点的调用栈信息，而并非是重新抛出点的信息
	 */
	private static void notFillStackTrace() throws Exception {
		try {
			original();
		} catch (Exception e) {
			System.out.println("Inside notFillStackTrace().e.printStacktrace()");
			e.printStackTrace(System.out);
			throw e;
		}
	}

	/**
	 * 要想更新这个信息，可以调用fillStackTrace()方法返回一个Throwable对象 
	 * 它是通过把当前调用栈信息填入原来那个异常对象而建立的
	 * 调用fillStackTrace()的那一行就成了异常的新发生地了
	 */
	private static void fillStackTrace() throws Exception {
		try {
			original();
		} catch (Exception e) {
			System.out.println("Inside fillStackTrace().e.printStacktrace()");
			e.printStackTrace(System.out);
			throw (Exception) e.fillInStackTrace();
		}
	}
}
