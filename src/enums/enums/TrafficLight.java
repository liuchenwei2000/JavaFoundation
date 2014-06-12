/**
 * 
 */
package enums;

/**
 * switch����е�enum
 *
 * @author ����ΰ
 *
 * ����ʱ�䣺2008-8-6
 */
public class TrafficLight {

	private Color color = Color.RED;
	
	public void change(){
		switch(color){
		// ���ﲻ��д��Color.RED
		case RED:
			color = Color.YELLOW;
			break;
		case GREEN:
			color = Color.RED;
			break;
		case YELLOW:
			color = Color.GREEN;
			break;
		}
	}
	
	@Override
	public String toString() {
		return "The traffic light is " + color;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TrafficLight light = new TrafficLight();
		for (int i = 0; i < 7; i++) {
			System.out.println(light);
			light.change();
		}
	}
}

enum Color {
	RED, GREEN, YELLOW
}