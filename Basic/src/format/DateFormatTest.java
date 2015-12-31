/**
 * 
 */
package format;

import java.util.Date;

/**
 * 日期时间格式化示例
 * <p>
 * 格式化日期时间的转换符是t，后面还可以跟如下转换符：
c	完整的日期和时间	Mon Veb 09 18:05:19 PST 2004
F	ISO 8601日期		2004-02-09
D	美国格式日期（月/日/年）02/09/2004
T	24小时时间		18:05:19
r	12小时时间		06:05:19 PM
R	24小时时间没有秒	18:05
Y	4位数字的年（前面补0）	2004
m	两位数字的月（前面补0）	02
d	两位数字的日（前面补0）	09
H	两位数字的小时（前面补0）23
M	两位数字的分钟（前面补0）05
S	两位数字的秒钟（前面补0）59
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014年12月22日
 */
public class DateFormatTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Date date = new Date();
		// c	完整的日期和时间
		System.out.printf("完整的日期和时间=%tc %n", date);
		// F	ISO 8601日期
		System.out.printf("ISO 8601日期=%tF %n", date);
		// D	美国格式日期（月/日/年）
		System.out.printf("美国格式日期（月/日/年）=%tD %n", date);
		// T	24小时时间
		System.out.printf("24小时时间=%tT %n", date);
		// r	12小时时间
		System.out.printf("12小时时间=%tr %n", date);
		// R	24小时时间没有秒
		System.out.printf("24小时时间没有秒=%tR %n", date);
		// Y	4位数字的年（前面补0）
		System.out.printf("4位数字的年（前面补0）=%tY %n", date);
		// m	两位数字的月（前面补0）
		System.out.printf("两位数字的月（前面补0）=%tm %n", date);
		// d	两位数字的日（前面补0）
		System.out.printf("两位数字的日（前面补0）=%td %n", date);
		// H	两位数字的小时（前面补0）
		System.out.printf("两位数字的小时（前面补0）=%tH %n", date);
		// M	两位数字的分钟（前面补0）
		System.out.printf("两位数字的分钟（前面补0）=%tM %n", date);
		// S	两位数字的秒钟（前面补0）
		System.out.printf("两位数字的秒钟（前面补0）=%tS %n", date);
		// 形如 2014-12-22 14:47:51
		System.out.printf("%tF %tT", date, date);
	}
}
