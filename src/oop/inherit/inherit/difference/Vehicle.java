/**
 * 
 */
package inherit.difference;

/**
 * ��ͨ������
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2007-8-28
 */
public abstract class Vehicle {
	
	protected String name;// ����
	protected double load;// ����

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
	 * ���ٶ���
	 */
	protected abstract void speedUp();
}