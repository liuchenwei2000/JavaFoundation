/**
 * 
 */
package inner.nonstatic.inherit;

/**
 * 内部类的继承演示
 * <p>
 * 因为内部类的构造器必须连接到指向其外部类对象的引用，
 * 所以在继承内部类的时候指向外部类对象的秘密的引用必须被初始化。
 * 而在子类中不再存在可连接的默认对象，要解决这个问题必须使用特殊的语法来明确的说清它们之间的关联。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2008-4-18
 */
public class InheritInner extends Outer.Inner{

	/**
	 * 无参构造器是编译不过的，必须有对外部类对象的关联信息
	 */
//	public InheritInner(){
//		
//	}
	
	/**
	 * 不能只是传递一个指向外部类对象的引用,还必须在构造器中第一行使用如下语法：
	 * 
	 * outerClassReference.super();
	 */
	public InheritInner(Outer outer){
		outer.super();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Outer outer = new Outer();
		InheritInner ii = new InheritInner(outer);
	}
}
