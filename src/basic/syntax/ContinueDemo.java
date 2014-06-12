/**
 * 
 */
package syntax;

/**
 * continue演示类
 * <p>
 * 无标签的continue：
 * 跳过最内层循环在continue之后的语句，直接判断boolean值决定是否继续循环。</br>
 * 有标签的continue：
 * 直接跳到标签代表的循环的起始位置
 * <p>
 * continue也可以和总会被执行的finally语句一起配合使用
 * 这样Java里就没有必要使用goto语句了
 * 
 * @author 刘晨伟
 *
 * 创建日期：2007-9-11
 */
public class ContinueDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String searchMe = "Look for a substring in me";
		String substring = "sub";
		boolean foundIt = false;

		int max = searchMe.length() - substring.length();

		test: for (int i = 0; i <= max; i++) {
			int n = substring.length();
			int j = i;
			int k = 0;
			while (n-- != 0) {
				if (searchMe.charAt(j++) != substring.charAt(k++)) {
					// 若是continue则跳到while循环开始处
					continue test;
				}
			}
			foundIt = true;
			break test;
		}
		System.out.println(foundIt ? "Found it" : "Didn't find it");
	}
}