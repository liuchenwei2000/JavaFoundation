/**
 * 
 */
package jdk7;

/**
 * 2，在数值类型字面值中使用下划线分隔
 * <p>
 * 在Java SE 7中，还支持以下划线作为分隔符联接的数值表示方式。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014年12月19日
 */
public class UnderscoresInNumericLiterals {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//十进制形式
		int anInt1 = 123_45_6;
		System.out.println(anInt1);
		//二进制、十六进制等形式也支持
		int anInt2 = 0b10_0110_100;
		System.out.println(anInt2);
		int anInt3 = 0xFF_EC_DE_5E;
		System.out.println(anInt3);
		//小数形式也支持
		float pi = 3.14_15F;
		System.out.println(pi);
		double aDouble = 3.14_15;
		System.out.println(aDouble);
		//多个下划线相连
		int chain = 5______2____0;
		System.out.println(chain);
		
		//下划线不能放在最后
//		int x = 52_;                //错误
		//下划线不能邻近小数点(邻近小数点前后都不行)
//		float pi1 = 3_.1415F;       // 错误
//		float pi2 = 3._1415F;       //错误
		//下划线不能紧放在后缀「L」或「F」的前面
//		float pi3 = 3.1415_F;       //错误
//		long aLong1 = 999_99_9999_L;//错误
		//下划线不能放在表示进制的前缀字符之间
//		int x5 = 0_x52;             //错误
	}
}
