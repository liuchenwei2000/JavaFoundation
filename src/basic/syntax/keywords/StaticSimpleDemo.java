/**
 * 
 */
package syntax.keywords;

/**
 * 静态成员简单示例
 * <p>
 * static作用于某个字段时会改变数据创建的方式，因为一个static字段对每个类来说都只有一份存储空间，而非static字段则是对每个对象都有一个存储空间。
 * </br>
 * 如果static作用于某个方法，这是为了在不创建任何对象的前提下调用它，即该类的任何对象调用该方法的效果一样。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2007-11-8
 */
public class StaticSimpleDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Share share1 = new Share();
		System.out.println(Share.a);
		share1.add();
		Share share2 = new Share();
		System.out.println(Share.a);
		share2.add();
		System.out.println(Share.a);
	}
}

class Share {
	
	static int a = 0;// 所有的对象共享此一份

	public void add() {
		a++;
	}
}