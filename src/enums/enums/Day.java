/**
 * 
 */
package enums;

/**
 * 枚举类
 * 
 * @author 刘晨伟
 *
 * 创建日期：2007-9-13
 */
public enum Day {
	
	// 枚举的第一行一定要把它的成员全部列出
	SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;

	// 如果需要定义方法，则需要把枚举成员的最后一个后面加上;号
	public static int getSize() {
		return 7;
	}
}
