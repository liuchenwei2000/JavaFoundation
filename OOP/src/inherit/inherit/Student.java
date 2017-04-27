/**
 * 
 */
package inherit;

/**
 * 学生类
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2007-8-28
 */
public class Student extends Person {
	
	private String school;
	private String grade;
	private String id;

	/**
	 * 当创建一个子类的对象时，该对象包含了一个基类的对象，
	 * Java会自动在子类的每一个构造方法中插入对基类无参构造方法的调用。
	 * 除非它已经调用了基类其他有参数的构造方法，调用一个带参数的基类构造器
	 * 就必须用super关键字显式调用并配以适当的参数列表。
	 * 调用基类构造方法必须是在子类的构造方法中要做的第一件事，
	 * 并且子类的每个构造方法中有且只能有一个super关键字。
	 */
	public Student() {
		super();
		this.school = "无名学校";
		this.grade = "年级";
		this.id = "S00000";
	}

	public Student(String theName, int theAge, char theSex) {
		super(theName, theAge, theSex);
		this.school = "无名学校";
		this.grade = "年级";
		this.id = "S00000";
	}

	public Student(String school, String grade, String id) {
		super();
		this.school = school;
		this.grade = grade;
		this.id = id;
	}

	public Student(String theName, int theAge, char theSex, String school,
			String grade, String id) {
		super(theName, theAge, theSex);
		this.school = school;
		this.grade = grade;
		this.id = id;
	}

	@Override
	public void walk() {
		System.out.println("Student is walking!");
	}

	public void study() {
		System.out.println("Student is studying!");
	}

	/**
	 * 如果子类中有静态方法和父类的同名且参数列表相同，则父类的被隐藏。
	 */
	public static void testClassMethod() {
		System.out.println("The class method in Student.");
	}

	/**
	 * 如果子类中有实例方法和父类的同名且参数列表相同，则父类的被覆盖。
	 *
	 * @see inherit.Person#testInstanceMethod()
	 */
	@Override
	public void testInstanceMethod() {
		System.out.println("The instance method in Student.");
	}
	
	@Override
	protected String getInfo() {
		String temp = super.getInfo();
		return temp + "school is " + school + "\n" + "grade is " + grade + "\n"
				+ "id is " + id + "\n";
	}
}
