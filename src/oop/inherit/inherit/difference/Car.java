/**
 * 
 */
package inherit.difference;

/**
 * �γ���
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2007-8-28
 */
public class Car extends Vehicle implements IShowInfo, IRunnable {
	
	private int capacity;// ������

	public Car() {
		this.name = "";
		this.load = 0;
		this.capacity = 0;
	}

	public Car(String name, double load, int capacity) {
		this.name = name;
		this.load = load;
		this.capacity = capacity;
	}

	public void setCapacity(int newCapacity) {
		capacity = newCapacity;
	}

	public int getCapacity() {
		return capacity;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see aboutInheritance.difference.Vehicle#speedUp()
	 */
	@Override
	protected void speedUp() {
		System.out.println("Now speed up : 80mph!");
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see aboutInheritance.difference.IShowInfo#showInfo()
	 */
	public void showInfo() {
		System.out.println("This is car : ");
		System.out.println("name : " + this.getName());
		System.out.println("load : " + this.getLoad());
		System.out.println("capacity : " + this.getCapacity());
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see aboutInheritance.difference.IRunning#backOff()
	 */
	public void backOff() {
		System.out.println("Be careful ! Back off now.");
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see aboutInheritance.difference.IRunning#goAhead()
	 */
	public void goAhead() {
		System.out.println("Go ahead now ! 100mph!");
	}
}