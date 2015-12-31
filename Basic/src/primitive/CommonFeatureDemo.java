/**
 * 
 */
package primitive;

/**
 * 基本类型和其包装类使用演示
 * <p>
 * 原始类型包装类提供了多个方法，能在原始类型和String类型之间互相转换 ，
 * 还提供了处理原始类型时非常有用的其他一些常量和方法。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2007-11-13
 */
public class CommonFeatureDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * 除了Character之外，其余的原始类型包装类都有一个用String作为参数的构造方法 
		 */
		Character c = new Character('a');
		Integer i = new Integer(1);
		i = new Integer("1");		
		/*
		 * 各包装类的valueOf方法返回一个新建的实例或者缓存中的已存在的实例
		 * 此方法比构造方法效率要高(尤其对于经常使用的实例)，应优先使用它，除非确实需要一个包含相同数值的不同的实例。
		 * Character类中没有valueOf(String)这个方法
		 */
		Integer ii = Integer.valueOf(1);
		ii = Integer.valueOf("1");
		/*
		 * 各包装类的compareTo(Type other)方法用来比较两个基本类型的大小
		 * 如果该Type在数值上等于other，则返回 0 值；
		 * 如果该Type在数值上小于other，则返回小于 0 的值；
		 * 如果该Type在数值上大于other，则返回大于 0 的值(有符号的比较)
		 * Boolean类中没有该方法
		 */
		System.out.println(ii + " " + (ii.compareTo(2) < 0 ? "<" : ">") + " 2");
		System.out.println(ii + " " + (ii.compareTo(1) == 0 ? "=" : "<>") + " 1");
		System.out.println(ii + " " + (ii.compareTo(-2) > 0 ? ">" : "<") + " -2");
		/*
		 * 各包装类的typeValue()用来返回包装类型对象对应的基本类型值
		 */
		int value = ii.intValue();
		System.out.println(c + " " + i + " " + ii + " " + value);
	}
}
