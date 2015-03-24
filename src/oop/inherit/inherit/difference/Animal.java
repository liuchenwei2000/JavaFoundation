/**
 * 
 */
package inherit.difference;

/**
 * ������
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2007-8-28
 */
public class Animal extends Biology implements IShowInfo, IRunnable {
	
	private String type;// ����

	public Animal() {
		this.name = "";
		this.age = 0;
		this.type = "";
	}

	public Animal(String name, int age, String type) {
		this.name = name;
		this.age = age;
		this.type = type;
	}

	public void setType(String newType) {
		type = newType;
	}

	public String getType() {
		return type;
	}

	@Override
	protected String getDeathInfo() {
		return "�³´�лֹͣ��";
	}

	@Override
	public void showInfo() {
		System.out.println("This is animal : ");
		System.out.println("name : " + this.getName());
		System.out.println("age : " + this.getAge());
		System.out.println("type : " + this.getType());
	}

	@Override
	public void backOff() {
		System.out.println("I will back off!");
	}

	@Override
	public void goAhead() {
		System.out.println("I will go ahead!");
	}
}