/**
 * 
 */
package inner;

/**
 * 内部类的.this和.new语法
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2008-4-13
 */
public class InnerClassSyntax {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DotThis dt = new DotThis();
		DotThis.Inner dti = dt.getInner();
		dti.getOuter().f();
		
		DotNew dn = new DotNew();
		@SuppressWarnings("unused")
		// 若想创建某个内部类的对象，必须在new表达式中提供对其外部类对象的引用，也就是outer.new。
		// 在拥有外部类对象之前是不能创建内部类对象的，因为内部类对象会暗暗地连接到创建它的外部类对象上。
		// 但是如果创建的是嵌套类（静态内部类）就不需要对外部类对象的引用。
		DotNew.Inner dni = dn.new Inner();
	}
}

class DotThis {
	
	void f() {
		System.out.println("DotThis.f()");
	}

	public class Inner {
		/**
		 * 如果需要生成对外部类对象的引用，可以使用外部类.this来完成 。
		 * 这样产生的引用自动地具有正确的类型。这个是在编译期就被检查的，没有任何运行开销。
		 */
		public DotThis getOuter() {
			return DotThis.this;
			// 如果只是this将会返回Inner的对象
		}
	}

	public Inner getInner() {
		return new Inner();
	}
}

class DotNew {
	
	public class Inner {
	}
}
