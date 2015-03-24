/**
 * 
 */
package syntax;

/**
 * 特殊操作符示例
 * <p>
 * 包括 ++ 和三元操作符 ?:
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2007-11-5
 */
public class SpecialOperatorDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a = 1;
		System.out.println("now a is " + a);
		int b = (++a) * 3;// 先执行 ++ 操作再执行其他
		System.out.println("a after ++a is " + a);
		System.out.println("b = (++a) * 3 is " + b);
		System.out.println();
		
		a = 1;
		System.out.println("now a is " + a);
		b = (a++) * 3;// 先执行其他最后执行 ++
		System.out.println("a after a++ is " + a);
		System.out.println("b = (a++) * 3 is " + b);
		
		/*
		 * 三元运算符?:的使用格式：booleanExpression ? value1 : value2
		 * 若booleanExpression为true返回value1，否则返回value2。
		 * 但是三元运算符的返回值必须被读取或被保存。
		 * 
		 */
		System.out.println(a + "," + b + "中较大的是 " + (a > b ? a : b));
	}
}