/**
 * 
 */
package syntax.keywords;

/**
 * 静态方法和实例方法演示
 * <p>
 * 对于静态方法和实例方法的取舍要由外部调用者来决定，可以从效率和参数列表两个方面综合考虑这个问题。
 * 
 * @author 刘晨伟
 *
 * 创建日期：2009-7-8
 */
public class StaticAndInstanceMethodDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * 对于少数的调用来说，这两种方式都是可取的 
		 */
		EchoUtil.echo("hello word.");
		new Echo("hello word.").echo();
		
		/*
		 * 对于大量的调用，明显使用静态方法的方式更好
		 * 在内存占用和效率上都要比实例方法的方式要优
		 */
		for (int i = 0; i < 100; i++) {
			EchoUtil.echo("this is number " + i);
		}
		for (int i = 0; i < 100; i++) {
			new Echo("this is number " + i).echo();
		}

		/*
		 * 对于这种方式，过长的参数列表会使人迷惑，并且难以阅读和维护
		 * 当然也可以将所以参数都封装到一个对象中(如下面的Info对象)
		 * 但是这样会使得调用者必须清楚两个类才可以达到打印信息的目的
		 */
		InfoUtil.printInfo("Tom", 19, 'M', "other info", "more info");
		/*
		 * 使用对象和实例方法可以使得调用过程清晰，并且调用者之需要清楚一个类即可
		 */
		Info info = new Info();
		info.setName("Tom");
		info.setAge(19);
		info.setSex('M');
		info.setOther("other info");
		info.setMore("more info");
		info.printInfo();
	}
}

/**
 * 使用静态方法的工具类来实现echo功能
 */
class EchoUtil {

	public static void echo(String content) {
		System.out.println("echo：" + content);
	}
}

/**
 * 使用对象和实例方法的方式实现echo功能
 */
class Echo {

	private String content;

	public Echo(String content) {
		this.content = content;
	}

	public void echo() {
		System.out.println("echo：" + content);
	}
}

/**
 * 使用静态方法的工具类来实现打印信息的功能
 */
class InfoUtil {

	public static void printInfo(String name, int age, char sex, String other,
			String more) {
		System.out.println("name " + name);
		System.out.println("age " + age);
		System.out.println("sex " + sex);
		System.out.println("other " + other);
		System.out.println("more " + more);
	}
}

/**
 * 用对象和实例方法的方式实现打印信息的功能
 */
class Info {
	
	private String name;
	private int age;
	private char sex;
	private String other;
	private String more;
	
	public Info(){
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getMore() {
		return more;
	}

	public void setMore(String more) {
		this.more = more;
	}
	
	/**
	 * 这里甚至可以将toString()方法定义为这样
	 */
	public void printInfo() {
		System.out.println("name " + name);
		System.out.println("age " + age);
		System.out.println("sex " + sex);
		System.out.println("other " + other);
		System.out.println("more " + more);
	}
}
