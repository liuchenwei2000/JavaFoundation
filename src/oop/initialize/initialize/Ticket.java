/**
 * 
 */
package initialize;

/**
 * 票类(初始化语句块演示)
 * <p>
 * 初始化语句块一般用于匿名内部类的初始化(因为这些类没有构造函数)，也可以用来执行构造函数都需要执行的语句。
 * 但是这种初始化语句块是不被提倡的(破坏了设计和可读性)。如果遇到了构造函数不能单独解决的事情可以使用它。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2007-11-8
 */
public class Ticket {
	
	private static int code = 0;// 编号
	
	/*
	 * 初始化语句块用于复杂的初始化(本例为演示)
	 * 
	 * 这个语句块将先于构造方法而执行，和其他的初始化语句一样按照顺序执行。
	 * 如果语句块中会产生受查异常，那么所有的构造方法都应该声明抛出该异常。
	 */
	{
		if(code < 0)
			throw new Exception();
		code++;
		System.out.print("Ticket code:");
	}
	
	/*
	 * static初始化语句块中不准许抛出受查异常，即使在构造方法上声明抛出异常也不可以。
	 */
	static {
		if (code < 0) {
			// throw new Exception();
		}
	}
	
	public Ticket() throws Exception{
		System.out.println(code);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			new Ticket();
			new Ticket();
			new Ticket();
			new Ticket();
			new Ticket();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}