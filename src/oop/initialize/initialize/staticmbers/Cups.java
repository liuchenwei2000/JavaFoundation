/**
 * 
 */
package initialize.staticmbers;

/**
 * Cups类
 * 
 * @author 刘晨伟
 *
 * 创建日期：2007-8-28
 */
public class Cups {
	
	static Cup c1;
	static Cup c2;
	
	/*
	 * 静态初始化语句块，相当于多个静态语句 。
	 * 
	 * 这段代码仅执行一次：
	 * 当首次生成这个类的一个对象时或者首次访问属于这个类的静态数据成员时（即使从未生成过该类的对象）时执行。
	 * 只允许在块中访问static字段和变量，并且不允许抛出任何受查异常。
	 */
	static {
		c1 = new Cup(1);
		c2 = new Cup(2);
	}

	public Cups() {
		System.out.println("Cups()");
	}
}