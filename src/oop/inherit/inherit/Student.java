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
	 * 如果子类中有静态方法和父类的同名且参数列表相同，则父类的被隐藏了。
	 */
	public static void testClassMethod() {
		System.out.println("The class method in Student.");
	}

	/**
	 * 如果子类中有实例方法和父类的同名且参数列表相同，则父类的被覆盖了。
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