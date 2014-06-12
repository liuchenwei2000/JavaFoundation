/**
 * 
 */
package inherit.difference;

/**
 * 演示类
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2007-8-28
 */
public class Demo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Plane plane = new Plane("波音747", 30.0, "CA-10048", 400);
		Car car = new Car("奔驰999", 3.0, 6);
		Animal animal = new Animal("老虎", 2000, "食肉动物");
		Plant plant = new Plant("柳树", 3000, "木本植物");
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