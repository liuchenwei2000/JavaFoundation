/**
 * 
 */
package enums;

/**
 * 覆盖enum中的方法
 *
 * @author 刘晨伟
 *
 * 创建时间：2008-8-6
 */
public class OverrideInEnum {

	/**
	 * 覆盖普通方法
	 */
	enum Sex {
		MALE, FEMALE;

		/**
		 * 实际上和覆盖普通类的方法没有什么区别。
		 * 
		 * @see java.lang.Enum#toString()
		 */
		@Override
		public String toString() {
			return name().toLowerCase();
		}
	}
	
	/**
	 * 可以为 enum 实例编写方法，从而为每个enum 实例赋予各自不同的行为，要实现常量相关的方法，
	 * 需要为 enum 定义一个或多个 abstract 方法，然后每个 enum 实例实现该抽象方法。
	 */
	enum Signal {

		ON() {

			@Override
			String getDescription() {
				return "ON";
			}

		},
		
		OFF() {

			@Override
			String getDescription() {
				return "OFF";
			}
		};

		abstract String getDescription();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (Sex sex : Sex.values()) {
			System.out.println(sex);
		}
		
		for (Signal signal : Signal.values()) {
			System.out.println(signal.getDescription());
		}
	}
}
