/**
 * 
 */
package generic.wildcard;

/**
 * 泛型所使用的对象类
 * 
 * @author 刘晨伟
 *
 * 创建日期：2009-8-4
 */
public class Father {

	private String name;

	public Father(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return name;
	}
}

class Son extends Father {

	private int age;

	public Son(String name) {
		super(name);
	}
	
	public Son(String name, int age) {
		super(name);
		this.age = age;
	}

	public int getAge() {
		return age;
	}
}