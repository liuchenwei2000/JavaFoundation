/**
 * 
 */
package object.clone;

/**
 * 深克隆演示
 * <p>
 * 深克隆：对象的完全复制，如果对象有对其它对象的引用，那些对象也被完全复制。
 * <p>
 * 在对组合对象做深克隆时，必须假设成员对象的clone()方法会在其引用上依次执行深克隆，并依此类推。
 * 它实际上表示，要想让深克隆起作用，就必须控制所有类的代码，或者至少
 * 对深克隆涉及的类要足够了解，才能知道它们是否正确执行了各自的深克隆。
 * 
 * @author 刘晨伟
 *
 * 创建日期：2009-6-6
 */
public class DeepClone {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Ocean ocean = new Ocean(33.9, 100.5);
		Ocean clone = (Ocean) ocean.clone();
		
		Temperature tr = clone.getTemperature();
		tr.setTemperature(tr.getTemperature() + 1);
		clone.setTemperature(tr);
		Depth dr = clone.getDepth();
		dr.setDepth(dr.getDepth() + 1);
		clone.setDepth(dr);
		
		System.out.println("ocean \n" + ocean);
		System.out.println("clone \n" + clone);
	}
}

/** 深度类 */
class Depth implements Cloneable {
	
	private double depth;

	public Depth(double depth) {
		this.depth = depth;
	}

	/**
	 * 实现自身clone方法
	 * 
	 * @see java.lang.Object#clone()
	 */
	public Object clone() {
		Object o = null;
		try {
			o = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return o;
	}

	public double getDepth() {
		return depth;
	}

	public void setDepth(double depth) {
		this.depth = depth;
	}

	public String toString() {
		return String.valueOf(depth);
	}
}

/** 温度类 */
class Temperature implements Cloneable {
	
	private double temperature;

	public Temperature(double temperature) {
		this.temperature = temperature;
	}

	/**
	 * 实现自身clone方法
	 * 
	 * @see java.lang.Object#clone()
	 */
	public Object clone() {
		Object o = null;
		try {
			o = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return o;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public String toString() {
		return String.valueOf(temperature);
	}
}

/** 海洋类 */
class Ocean implements Cloneable {
	
	private Depth depth;
	private Temperature temperature;

	public Ocean(double depth, double temperature) {
		this.depth = new Depth(depth);
		this.temperature = new Temperature(temperature);
	}

	/**
	 * Ocean 对象实现深克隆的时候必须对其成员对象也进行克隆操作，
	 * 然后将克隆后的成员对象副本设给Ocean的克隆对象。
	 */
	public Object clone() {
		Ocean o = null;
		try {
			o = (Ocean) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		// 成员对象的克隆，并设给Ocean克隆后的对象
		o.depth = (Depth) o.depth.clone();
		o.temperature = (Temperature) o.temperature.clone();
		return o;
	}

	public Temperature getTemperature() {
		return temperature;
	}

	public void setTemperature(Temperature tr) {
		temperature = tr;
	}

	public Depth getDepth() {
		return depth;
	}

	public void setDepth(Depth dr) {
		this.depth = dr;
	}

	public String toString() {
		return "temperature: " + temperature + ", depth: " + depth;
	}
}
