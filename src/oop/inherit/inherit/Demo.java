/**
 * 
 */
package inherit;

/**
 * ��ʾ��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2007-8-28
 */
public class Demo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Person p = new Person();
		Student s = new Student();
		p.walk();
		s.walk();
		p.testInstanceMethod();
		s.testInstanceMethod();
		Person.testClassMethod();
		Student.testClassMethod();
		p.showInfo();
		s.showInfo();
		p = s;
		System.out.println("After p = s : ");
		p.testInstanceMethod();
		p.walk();
		p.showInfo();
		// �������ñ���p��study�������ɼ�
		// p.study();
	}
}