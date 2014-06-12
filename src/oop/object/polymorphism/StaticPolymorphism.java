/**
 * 
 */
package polymorphism;

/**
 * ��̬��������������ǵ�������������ģ����Ծ�̬��������Ϊ�����ж�̬�ԡ�
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2008-4-8
 */
public class StaticPolymorphism {

	/**
	 * @param args
	 */
	@SuppressWarnings("static-access")
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