/**
 * 
 */
package jdk7;

/**
 * 4，switch-case语句支持字符串类型
 * <p>
 * 在Java SE 7中，switch-case语句可以支持字符串类型的数据变量。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014年12月19日
 */
public class StringsInSwitchStatements {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String input = "Monday";
		String output = null;
		switch(input){
		case "Monday":
		    output = "星期一";
		    break;
		case "Tuesday":
		    output = "星期二";
		    break;
		case "Wednesday":
		    output = "星期三";
		    break;
		case "Thursday":
		    output = "星期四";
		    break;
		case "Friday":
		    output = "星期五";
		    break;
		case "Saturday":
		    output = "星期六";
		    break;
		case "Sunday":
		    output = "星期日";
		    break;
		default:
		    throw new IllegalArgumentException("无效的输入参数：" + input);
		}
		System.out.println(output); //输出：星期一
	}
}
