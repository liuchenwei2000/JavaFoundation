/**
 * 
 */
package inner;

/**
 * 内部类演示2
 * <p>
 * 用途2：</br>
 * 当生成一个内部类对象时，该对象与创建它的外围对象是对应的。
 * 它能够访问外围对象的所有成员，而不需要任何特殊条件，也就是内部类拥有其外部类的所有元素的访问权。
 * <p>
 * 实现细节： </br>
 * 当某个外围类的对象创建了一个内部类对象时，此内部类对象必定会秘密地得到一个指向该外部类对象的引用；
 * 然后当访问外部类的成员时，就是用那个引用来选择外部类成员。
 * 所以内部类的对象只能在与其外部类的对象相关联的情况下才能被创建（即内部类是非static的）。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2008-4-13
 */
public class InnerClass2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Outer outer = new Outer();
		Printable printer = outer.getPrinter();
		System.out.println(printer.getPrintMessage());
	}
}

interface Printable {
	
	public String getPrintMessage();
}

class Outer {
	
	private String message;

	public Outer() {
		message = "Outer";
	}

	public Printable getPrinter() {
		return new Inner();
	}

	class Inner implements Printable {

		public String getPrintMessage() {
			return "Inner.getPrintMessage() : " + message;
		}
	}
}