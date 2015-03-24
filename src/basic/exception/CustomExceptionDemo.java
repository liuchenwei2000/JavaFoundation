/**
 * 
 */
package exception;

/**
 * 自定义异常演示类
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2007-8-28
 */
public class CustomExceptionDemo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a = 10, b = 0;
		try {
			if (b == 0) {
				throw new DivisorIsZeroException();
			}
			int c = a / b;
			System.out.println(c);
		} catch (DivisorIsZeroException e) {
			// 标准错误流打印该异常的描述信息
			System.err.println("异常 : " + e.getMessage());
			// 堆栈跟踪(stack trace)是一个方法调用过程的列表，它包含了程序执行中方法的调用次序
			e.printStackTrace();
		} 
	}
}

/**
 * 除数为0异常(自定义异常)
 * <p>
 * 如果遇到标准异常类都不能够充分地描述清楚的问题，那么就需要创建自己的异常类了。
 * 需要做的只是定义一个派生于Exception的类，或者派生于Exception子类的类。
 * 习惯上，定义的类应该包含两个构造器，一个是默认构造器，另一个是带有详细描述信息的构造器。
 */
class DivisorIsZeroException extends RuntimeException {
	
	private static final long serialVersionUID = 1947531179165400147L;
	
	/** 异常提示信息 */
	private static final String message = "除数不可为0!";

	public DivisorIsZeroException() {
		super();
	}

	public DivisorIsZeroException(String message) {
		super(message);
	}

	public DivisorIsZeroException(Throwable e) {
		super(e);
	}

	public DivisorIsZeroException(String message, Throwable e) {
		super(message, e);
	}

	public String getMessage() {
		return message;
	}
}