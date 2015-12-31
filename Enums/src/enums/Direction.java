/**
 * 
 */
package enums;

/**
 * 在enum中添加方法
 *
 * @author 刘晨伟
 *
 * 创建时间：2008-8-6
 */
public enum Direction {
	
	// enum中的首行必须是其实例的定义
	EAST("This is east!"), WEST("This is west!"), SOUTH("This is south!"), NORTH("This is north!");

	// 如果想要添加方法(或属性)，则必须在enum实例序列的最后添加一个分号
	private String description;

	/**
	 * 这个构造器规定了enum实例的构造形式(必须提供一个String参数)。
	 * 即使它不是private的，一旦enum实例的定义结束，编译器就不允许再使用其构造器来创建任何实例了。
	 */
	private Direction(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (Direction direction : Direction.values()) {
			System.out.println(direction + " : " + direction.getDescription());
		}
	}
}
