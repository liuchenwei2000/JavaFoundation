/**
 * 
 */
package syntax;

/**
 * 标识符演示类
 * <p>
 * 标识符除了数字和英文字母之外还可以使用其他拉丁字母甚至汉字，但是还是不可以数字开头。
 * <p>
 * goto和const是目前Java还未使用的保留字。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2007-11-13
 */
public class Identifier {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String 猫 = "猫";
		System.out.println(猫);
		String αβγ = "αβγ";
		System.out.println(αβγ);
	}
}
