/**
 * 
 */
package enums;

/**
 * 覆盖enum中的方法
 * <p>
 * 实际上和覆盖普通类的方法没有什么区别。
 *
 * @author 刘晨伟
 *
 * 创建时间：2008-8-6
 */
public class OverrideInEnum {

	enum Sex {
		MALE, FEMALE;

		@Override
		public String toString() {
			return name().toLowerCase();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (Sex sex : Sex.values()) {
			System.out.println(sex);
		}
	}
}