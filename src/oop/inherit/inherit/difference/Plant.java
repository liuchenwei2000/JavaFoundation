/**
 * 
 */
package inherit.difference;

/**
 * 植物类
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2007-8-28
 */
public class Plant extends Biology implements IShowInfo {
	
	private String type;// 种属

	public Plant() {
		this.name = "";
		this.age = 0;
		this.type = "";
	}

	public Plant(String name, int age, String type) {
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
	 * (non-Javadoc)
	 * 
	 * @see aboutInheritance.difference.Biology#deathInfo()
	 */
	@Override
	protected String getDeathInfo() {
		return "光合作用停止！";
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see aboutInheritance.difference.IShowInfo#showInfo()
	 */
	public void showInfo() {
		System.out.println("This is plant : ");
		System.out.println("name : " + this.getName());
		System.out.println("age : " + this.getAge());
		System.out.println("type : " + this.getType());
	}
}