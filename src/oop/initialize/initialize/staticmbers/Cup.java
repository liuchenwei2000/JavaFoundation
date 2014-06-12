/**
 * 
 */
package initialize.staticmbers;

/**
 * Cup类(演示静态变量和静态方法)
 * 
 * @author 刘晨伟
 *
 * 创建日期：2007-8-28
 */
public class Cup {
	
	/** 静态变量会常驻内存，直到程序结束该变量被清除，该类对象共用(share)这一个*/
	private static int counter = initCounter();
	/** 实例变量会为每个对象提供一个拷贝 */
	private String number = initNumber();
	
	public Cup(int marker) {
		System.out.println("Cup(" + marker + ")");
		counter++;
		number = counter + "";
	}

	public void f(int marker)
    {
    	System.out.println("f("+marker+")");
    }
    
    /**
	 * The advantage of private static methods is that they can be reused later
	 * if you need to reinitialize the class variable
	 */
	private static int initCounter() {
		return 0;
	}
    
	/**
	 * 这样初始化实例变量可以防止子类覆盖该方法
	 */
	protected final String initNumber() {
		return getCounter() + "";
	}
	
    /**
	 * 静态方法的一般作用是为了访问静态变量
	 */
    public static int getCounter() {
    	return counter;
    }
    
    public String getNumber() {
    	return number;
    }
}