/**
 * 
 */
package enums;

/**
 * 向上转型枚举
 * <p>
 * 实际上values()方法是由编译期插入到enum定义中的static方法， 所以如果将enum实例向上转型为Enum，则values()方法就不访问了。
 * 但是在Class中有一个getEnumConstants()方法可以达到相同效果， 所以即使Enum接口中没有values方法，仍然可以获得所有的enum实例。
 *
 * @author 刘晨伟
 *
 * 创建时间：2008-8-6
 */
public class UpcastEnum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Enum<?> e = Season.SPRING;
		// e.values();Enum中并没有定义该方法
		for (Enum<?> en : e.getClass().getEnumConstants()) {
			System.out.println(en);
		}
	}
}

enum Season {
	SPRING, SUMMER, AUTUMN, WINTER
}