/**
 * 
 */
package inherit.difference;

/**
 * 生物类
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2007-8-28
 */
public abstract class Biology {
	
	protected String name;// 名字
	protected int age;// 物种年龄

	protected void setName(String newName) {
		name = newName;
	}

	protected String getName() {
		return name;
	}

	protected void setAge(int newAge) {
		age = newAge;
	}

	protected int getAge() {
		return age;
	}

	/**
	 * 返回死亡信息
	 */
	protected abstract String getDeathInfo();
}