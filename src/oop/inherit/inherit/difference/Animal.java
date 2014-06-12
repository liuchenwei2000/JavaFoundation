/**
 * 
 */
package inherit.difference;

/**
 * 动物类
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2007-8-28
 */
public class Animal extends Biology implements IShowInfo, IRunnable {
	
	private String type;// 种属

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

	/**
	 * (non-Java doc)
	 * 
	 * @see aboutInheritance.difference.Biology#deathInfo()
	 */
	@Override
	protected String getDeathInfo() {
		return "新陈代谢停止！";
	}

	/**
	 * (non-Java doc)
	 * 
	 * @see aboutInheritance.difference.IShowInfo#showInfo()
	 */
	public void showInfo() {
		System.out.println("This is animal : ");
		System.out.println("name : " + this.getName());
		System.out.println("age : " + this.getAge());
		System.out.println("type : " + this.getType());
	}

	/**
	 * (non-Java doc)
	 * 
	 * @see aboutInheritance.difference.IRunning#backOff()
	 */
	public void backOff() {
		System.out.println("I will back off!");
	}

	/**
	 * (non-Java doc)
	 * 
	 * @see aboutInheritance.difference.IRunning#goAhead()
	 */
	public void goAhead() {
		System.out.println("I will go ahead!");
	}
}