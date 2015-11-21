/**
 * 
 */
package inherit;

/**
 * 演示类
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2007-8-28
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
		// 对于引用变量p，study方法不可见
		// p.study();
	}
}
