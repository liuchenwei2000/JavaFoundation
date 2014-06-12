/**
 * 
 */
package inherit;

/**
 * ѧ����
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2007-8-28
 */
public class Student extends Person {
	
	private String school;
	private String grade;
	private String id;

	public Student() {
		super();
		this.school = "����ѧУ";
		this.grade = "�꼶";
		this.id = "S00000";
	}

	public Student(String theName, int theAge, char theSex) {
		super(theName, theAge, theSex);
		this.school = "����ѧУ";
		this.grade = "�꼶";
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
	 * ����������о�̬�����͸����ͬ���Ҳ����б���ͬ������ı������ˡ�
	 */
	public static void testClassMethod() {
		System.out.println("The class method in Student.");
	}

	/**
	 * �����������ʵ�������͸����ͬ���Ҳ����б���ͬ������ı������ˡ�
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