/**
 * 
 */
package inherit.difference;

/**
 * 飞机类
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2007-8-28
 */
public class Plane extends Vehicle implements IShowInfo {
	
	private String id;// 编号
	private int capacity;// 载人量

	public Plane() {
		this.name = "";
		this.load = 0;
		this.id = "";
		this.capacity = 0;
	}

	public Plane(String name, double load, String id, int capacity) {
		this.name = name;
		this.load = load;
		this.id = id;
		this.capacity = capacity;
	}

	public void setId(String newId) {
		id = newId;
	}

	public String getId() {
		return id;
	}

	public void setCapacity(int newCapacity) {
		capacity = newCapacity;
	}

	public int getCapacity() {
		return capacity;
	}

	@Override
	protected void speedUp() {
		System.out.println("Now speed up : 600mph!");
	}

	public void showInfo() {
		System.out.println("This is plane : ");
		System.out.println("name : " + this.getName());
		System.out.println("id : " + this.getId());
		System.out.println("load : " + this.getLoad());
		System.out.println("capacity : " + this.getCapacity());
	}
}