/**
 * 
 */
package exception;

/**
 * 重新抛出新的异常(包装异常)演示
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2008-4-21
 */
public class RethrowNewException {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			throwTwoExceptionUnknown();
		} catch (TwoException e) {
			// 该异常仅知道自己来自throwTwoException而不知道throwOneException
			System.out.println("catch TwoException in main()");
			e.printStackTrace(System.out);
		}
		System.out.println("******************************************");
		
		try {
			throwTwoExceptionKnown();
		} catch (TwoException e) {
			// 该异常不仅知道自己来自throwTwoException而且还知道throwOneException
			System.out.println("catch TwoException in main()");
			e.printStackTrace(System.out);
			// 当捕获异常时，就可以使用getCause()获得原始异常
			System.out.println("cause : " + e.getCause().getMessage());
		}
		throwExceptionNotAllowed();
	}

	private static void throwOneException() throws OneException {
		System.out.println("originating OneException in throwOneException()");
		throw new OneException("thrown from throwOneException()");
	}

	private static void throwTwoExceptionUnknown() throws TwoException {
		try {
			throwOneException();
		} catch (OneException e) {
			System.out.println("catch OneException in throwTwoException()");
			e.printStackTrace(System.out);
			// 在一个catch子句中，也可以抛出一个新异常，这样做的目的是希望改变异常的类型
			throw new TwoException("thrown from throwTwoException()");
		}
	}
	
	private static void throwTwoExceptionKnown() throws TwoException {
		try {
			throwOneException();
		} catch (OneException e) {
			System.out.println("catch OneException in throwTwoException()");
			e.printStackTrace(System.out);
			/*
			 * 异常链机制
			 * 
			 * 如果想要在捕获一个异常后抛出另一个异常，并且希望把原始异常的信息保存下来，就需要使用异常链。
			 * 使用initCause(Throwable)方法可以把原始异常传递给新的异常，使得即使在当前位置
			 * 创建并抛出了新的异常，也能通过这个异常链追踪到异常最初发生的位置。
			 */
			TwoException te = new TwoException("thrown from throwTwoException()");
			te.initCause(e);
			throw te;
		}
	}
	
	/**
	 * 如果一个方法中出现一个 已检查异常，而不允许抛出它，那么包装技术就十分有用：
	 * 可以捕获这个已检查异常，并将它包装成运行时异常。
	 */
	private static void throwExceptionNotAllowed() {
		try {
			throwOneException();
		} catch (OneException e) {
			throw new RuntimeException(e);
		}
	}
}

class OneException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public OneException(String msg) {
		super(msg);
	}
}

class TwoException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public TwoException(String msg) {
		super(msg);
	}
}