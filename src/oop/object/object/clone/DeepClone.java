/**
 * 
 */
package object.clone;

/**
 * ���¡��ʾ
 * <p>
 * ���¡���������ȫ���ƣ���������ж�������������ã���Щ����Ҳ����ȫ���ơ�
 * <p>
 * �ڶ���϶��������¡ʱ����������Ա�����clone()��������������������ִ�����¡�����������ơ�
 * ��ʵ���ϱ�ʾ��Ҫ�������¡�����ã��ͱ������������Ĵ��룬��������
 * �����¡�漰����Ҫ�㹻�˽⣬����֪�������Ƿ���ȷִ���˸��Ե����¡��
 * 
 * @author ����ΰ
 *
 * �������ڣ�2009-6-6
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

/** ����� */
class Depth implements Cloneable {
	
	private double depth;

	public Depth(double depth) {
		this.depth = depth;
	}

	/**
	 * ʵ������clone����
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

/** �¶��� */
class Temperature implements Cloneable {
	
	private double temperature;

	public Temperature(double temperature) {
		this.temperature = temperature;
	}

	/**
	 * ʵ������clone����
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

/** ������ */
class Ocean implements Cloneable {
	
	private Depth depth;
	private Temperature temperature;

	public Ocean(double depth, double temperature) {
		this.depth = new Depth(depth);
		this.temperature = new Temperature(temperature);
	}

	/**
	 * Ocean ����ʵ�����¡��ʱ���������Ա����Ҳ���п�¡������
	 * Ȼ�󽫿�¡��ĳ�Ա���󸱱����Ocean�Ŀ�¡����
	 */
	public Object clone() {
		Ocean o = null;
		try {
			o = (Ocean) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		// ��Ա����Ŀ�¡�������Ocean��¡��Ķ���
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