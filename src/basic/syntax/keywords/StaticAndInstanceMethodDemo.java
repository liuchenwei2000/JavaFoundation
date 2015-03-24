/**
 * 
 */
package syntax.keywords;

/**
 * ��̬������ʵ��������ʾ
 * <p>
 * ���ھ�̬������ʵ��������ȡ��Ҫ���ⲿ�����������������Դ�Ч�ʺͲ����б����������ۺϿ���������⡣
 * 
 * @author ����ΰ
 *
 * �������ڣ�2009-7-8
 */
public class StaticAndInstanceMethodDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * ���������ĵ�����˵�������ַ�ʽ���ǿ�ȡ�� 
		 */
		EchoUtil.echo("hello word.");
		new Echo("hello word.").echo();
		
		/*
		 * ���ڴ����ĵ��ã�����ʹ�þ�̬�����ķ�ʽ����
		 * ���ڴ�ռ�ú�Ч���϶�Ҫ��ʵ�������ķ�ʽҪ��
		 */
		for (int i = 0; i < 100; i++) {
			EchoUtil.echo("this is number " + i);
		}
		for (int i = 0; i < 100; i++) {
			new Echo("this is number " + i).echo();
		}

		/*
		 * �������ַ�ʽ�������Ĳ����б��ʹ���Ի󣬲��������Ķ���ά��
		 * ��ȻҲ���Խ����Բ�������װ��һ��������(�������Info����)
		 * ����������ʹ�õ����߱������������ſ��Դﵽ��ӡ��Ϣ��Ŀ��
		 */
		InfoUtil.printInfo("Tom", 19, 'M', "other info", "more info");
		/*
		 * ʹ�ö����ʵ����������ʹ�õ��ù������������ҵ�����֮��Ҫ���һ���༴��
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
 * ʹ�þ�̬�����Ĺ�������ʵ��echo����
 */
class EchoUtil {

	public static void echo(String content) {
		System.out.println("echo��" + content);
	}
}

/**
 * ʹ�ö����ʵ�������ķ�ʽʵ��echo����
 */
class Echo {

	private String content;

	public Echo(String content) {
		this.content = content;
	}

	public void echo() {
		System.out.println("echo��" + content);
	}
}

/**
 * ʹ�þ�̬�����Ĺ�������ʵ�ִ�ӡ��Ϣ�Ĺ���
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
 * �ö����ʵ�������ķ�ʽʵ�ִ�ӡ��Ϣ�Ĺ���
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
	 * �����������Խ�toString()��������Ϊ����
	 */
	public void printInfo() {
		System.out.println("name " + name);
		System.out.println("age " + age);
		System.out.println("sex " + sex);
		System.out.println("other " + other);
		System.out.println("more " + more);
	}
}