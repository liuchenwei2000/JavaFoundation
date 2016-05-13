/**
 * 
 */
package initialize;

/**
 * 初始化顺序演示
 * <p>
 * 用来测试类中字段和构造方法的初始化顺序，首先各个字段先被初始化然后是再调用构造方法。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2007-8-28
 */
public class OrderOfInitialization {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Card c = new Card();
		c.f();
		// 输出为：
		// Tag(1)
		// Tag(2)
		// Tag(3)
		// Card()
		// Tag(33)
		// f()
	}
}

/**
 * 牌类(字段的声明不是连续的)
 */
class Card {
	
	Tag t1 = new Tag(1);
	
	public Card() {
		System.out.println("Card()");
		t3 = new Tag(33);
	}

	Tag t2 = new Tag(2);

	public void f() {
		System.out.println("f()");
	}

	Tag t3 = new Tag(3);
}

/**
 * Tag类
 */
class Tag {
	
	public Tag(int marker) {
		System.out.println("Tag(" + marker + ")");
	}
}
