/**
 * 
 */
package inherit.more;

/**
 * Բ�� 
 * <p>
 * һ����ʵ�ֵ���һ���̳��������ӿڵĽӿ� ����������ʵ������ӿں������и��ӿڵ����з�����
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2007-8-2
 */
public class Circle implements IFigure {
	
	private double r;// �뾶

	/**
	 * @param r
	 */
	public Circle(double r) {
		this.r = r;
	}

	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}

	public void draw() {
		System.out.println("This is circle!");
	}

	public double getArea() {
		return r * r * Math.PI;
	}

	public double getGirth() {
		return 2 * r * Math.PI;
	}
}