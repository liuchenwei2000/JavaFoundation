/**
 * 
 */
package enums;

/**
 * 枚举类示例
 *
 * @author 刘晨伟
 *
 * 创建时间：2008-8-6
 */
public class EnumDemo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// values()返回这个枚举所等同的数组，并且数组中的元素严格保持其在enum中声明的顺序
		for (Day day : Day.values()) {
			// 返回枚举常量的序数(它在枚举声明中的位置，其中初始常量序数为零)
			println(day + " ordinal: " + day.ordinal());
			// 枚举实现了Comparable接口，可以进行比较
			println(day + ".compareTo(Day.THURSDAY) = " + day.compareTo(Day.THURSDAY));
			println(day + ".equals(Day.THURSDAY) = " + day.equals(Day.THURSDAY));
			println(day + " == equals(Day.THURSDAY) = " + (day == Day.THURSDAY));
			println(day + ".getDeclaringClass() = " + day.getDeclaringClass());
			println(day + ".name() = " + day.name());
			println("-----------------------------------------------");
		}
		// 静态方法valueOf(Class<T> enumType, String name)
		// 返回带指定名称的指定枚举类型的枚举常量
		// 名称必须与在此类型中声明枚举常量所用的标识符完全匹配
		println(Enum.valueOf(Day.class, "TUESDAY"));
		// 该方法的逆方法toString()能够返回枚举对象的常量名
		println(Day.FRIDAY.toString());
	}

	private static void println(Object object) {
		System.out.println(object);
	}
}