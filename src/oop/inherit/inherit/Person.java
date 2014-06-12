/**
 * 
 */
package inherit;

/**
 * ����
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2007-8-28
 */
public class Person {
	
	private String name;
	private int age;
	private char sex;
	int pack;

	public Person() {
		// ����������������췽��
		this("������", 0, '��');
	}

	public Person(String name, int age, char sex) {
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	public void walk() {
		System.out.println("Person is walking!");
	}

	public void talk() {
		System.out.println("Person is talking!");
	}

	public void eat() {
		System.out.println("Person is eating!");
	}

	public void sleep() {
		System.out.println("Person is sleeping!");
	}

	protected String getInfo() {
		return "name is " + name + "\n" + "age is " + age + "\n" + "sex is "
				+ sex + "\n";
	}

	public static void testClassMethod() {
		System.out.println("The class method in Person.");
	}

	public void testInstanceMethod() {
		System.out.println("The instance method in Person.");
	}

	public void showInfo() {
		System.out.println(getInfo());
	}

	public String toString() {
		return getInfo();
	}
}