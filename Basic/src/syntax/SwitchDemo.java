/**
 * 
 */
package syntax;

/**
 * switch语句的控制流程
 * <p>
 * switch后的参数只能是byte、short、char、int和相关包装类(Integer等)以及枚举类型。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2007-9-10
 */
public class SwitchDemo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int month = 2;
		int year = 2000;
		int numDays = 0;

		switch (month) {
		// switch语句将从匹配值的case标签开始执行直到遇到break语句，或者执行到switch语句的结束处为止
		// 如果没有匹配的case标签，而有default子句的话，就执行这个子句
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			numDays = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			numDays = 30;
			break;
		case 2:
			numDays = isLeapYear(year) ? 29 : 28;
			break;
		// 当所有的case都不匹配时执行default
		default:
			System.out.println("Invalid month.");
			// 下面的break可以省略，因为程序执行到此就跳出switch块了
			break;
		}
		System.out.println("Number of Days = " + numDays);
	}
	
	/**
	 * 判断参数年份是否是闰年
	 * 
	 * @param year
	 *            年份
	 */
	private static boolean isLeapYear(int year) {
		return ((year % 4 == 0) && !(year % 100 == 0)) || (year % 400 == 0);
	}
}
