/**
 * 
 */
package inherit.difference;

/**
 * 交通工具类
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2007-8-28
 */
public abstract class Vehicle {
	
	protected String name;// 名字
	protected double load;// 载重

	protected void setName(String newName) {
		name = newName;
	}

	protected String getName() {
		return name;
	}

	protected void setLoad(double newLoad) {
		load = newLoad;
	}

	protected double getLoad() {
		return load;
	}

	/**
	 * 加速动作
	 */
	protected abstract void speedUp();
}
