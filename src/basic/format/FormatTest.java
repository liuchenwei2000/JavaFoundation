/**
 * 
 */
package format;

/**
 * 格式化示例
 * <p>
 * Java5开始支持格式化字符串功能，每一个以%字符开始的“格式说明符”都会用相应的参数替换，
 * 格式说明符尾部的转换符将指定被格式化的值类型：如f表示浮点数，s表示字符串。
 * 以 %s 为例，%是格式说明符，s是转换符。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014年12月22日
 */
public class FormatTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.printf("Name is %s%nAge is %d%nGrade is %c%nPassed? %b%n", "Tom Green", 14, 'A', true);
		String formattedString = String.format("This is a %s", "book");
		// 可以使用String的静态方法创建一个格式化的字符串。
		System.out.println(formattedString);

		// 左对齐打印表格的示例，%-12s中 - 表示左对齐（默认右对齐）12表示字符串长度
		String format = "%-12s %-8s %4s %12s%n";
		System.out.printf(format, "Code", "Name", "Age", "Meesage");
		for (int i = 1; i < 10; i++) {
			System.out.printf(format, "Code" + i, "Name" + i, i + 20, "Meesage"
					+ i);
		}
	}
}
