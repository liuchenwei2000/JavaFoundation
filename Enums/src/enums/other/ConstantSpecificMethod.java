/**
 * 
 */
package enums.other;

import java.text.DateFormat;
import java.util.Date;

/**
 * 常量相关的方法
 * <p>
 * enum允许为其实例编写方法，从而为每个实例赋予不同的行为，
 * 要实现常量相关的方法，需要为enum定义abstract方法，然后为每个enum实例实现该抽象方法。
 * 每个enum元素都是一个enum类型的static final实例。
 *
 * @author 刘晨伟
 *
 * 创建时间：2008-8-7
 */
public enum ConstantSpecificMethod {
	
	DATE_TIME {
		String getInfo() {
			return DateFormat.getDateInstance().format(new Date());
		}
	},

	CLASSPATH {
		String getInfo() {
			return System.getenv("CLASSPATH");
		}
	},

	VERSION {
		String getInfo() {
			return System.getProperty("java.version");
		}
	};

	/**
	 * enum定义的抽象方法，其实例必须实现
	 */
	abstract String getInfo();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (ConstantSpecificMethod e : ConstantSpecificMethod.values()) {
			System.out.println(e.getInfo());
		}
	}
}
