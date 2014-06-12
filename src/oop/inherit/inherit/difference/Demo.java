/**
 * 
 */
package inherit.difference;

/**
 * ��ʾ��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2007-8-28
 */
public class Demo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Plane plane = new Plane("����747", 30.0, "CA-10048", 400);
		Car car = new Car("����999", 3.0, 6);
		Animal animal = new Animal("�ϻ�", 2000, "ʳ�⶯��");
		Plant plant = new Plant("����", 3000, "ľ��ֲ��");
		show(plane);
		plane.speedUp();
		System.out.println();
		show(car);
		car.speedUp();
		move(car);
		System.out.println();
		show(animal);
		move(animal);
		System.out.println("Death : " + animal.getDeathInfo());
		System.out.println();
		show(plant);
		System.out.println("Death : " + plant.getDeathInfo());
	}

	private static void show(IShowInfo is) {
		is.showInfo();
	}

	private static void move(IRunnable ir) {
		ir.goAhead();
		ir.backOff();
	}
}