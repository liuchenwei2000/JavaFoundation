/**
 * 
 */
package inner;

/**
 * 接口中的内部类
 * <p>
 * 正常情况下接口中是不能有具体代码的，但是嵌套类可以作为接口的一部分。
 * 放到接口中的任何类都自动的是 public static，因为类是 static 的，只是将其置于接口的命名空间内。
 * 这样并不违反接口的规则，甚至可以在内部类中实现这个接口。
 * 如果想要创建某些公共代码，使得它们可以被某个接口的所有不同实现所共用，用接口内部的嵌套类会显得很方便。
 * 
 * @author 刘晨伟
 *
 * 创建日期：2008-4-14
 */
public interface InnerClassInInterface {

	void print();
	
	class InnerImpl implements InnerClassInInterface {
		
		public void print() {
			System.out.println("Inside InnerImpl");
		}
	}
}
