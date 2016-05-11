/**
 * 
 */
package polymorphism;

/**
 * 静态方法是与类而不是单个对象相关联的，所以静态方法的行为不具有多态性。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2008-4-8
 */
public class StaticPolymorphism {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Father f = new Son();
		System.out.println(f.staticGet());
		System.out.println(f.dynamicGet());
	}
}

class Father {
	
	public static String staticGet() {
		return "staticGet() in Father";
	}

	public String dynamicGet() {
		return "dynamicGet() in Father";
	}
}

class Son extends Father {
	
	public static String staticGet() {
		return "staticGet() in Son";
	}

	public String dynamicGet() {
		return "dynamicGet() in Son";
	}
}
