/**
 * 
 */
package inherit.more;

/**
 * 演示类
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2007-8-2
 */
public class Demo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Circle cc = new Circle(2);
		show(cc);
		Rectangle rt = new Rectangle(4, 3);
		show(rt);
	}

	private static void show(IFigure f) {
		f.draw();
		System.out.println("My area : " + f.getArea());
		System.out.println("My girth : " + f.getGirth());
	}
}