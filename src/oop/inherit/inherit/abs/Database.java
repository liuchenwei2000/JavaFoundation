/**
 * 
 */
package inherit.abs;

/**
 * 数据库类(abstract)
 * <p>
 * 抽象类：</br>
 * 提供一个类型的部分实现 ，可以有常量、实例变量/抽象方法和具体方法，但不可被实例化。
 * 抽象类可以含有也可以不含有抽象方法。
 * 其子类都必须实现超类中的所有的抽象方法，或者其子类自己也声明成abstract。</br>
 * 不可声明为抽象的方法：构造方法、静态方法、私有方法。</br>
 * 若一个类没有完全实现某个接口中的方法就应该被声明为abstract。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2007-8-28
 */
public abstract class Database {
	
	/** 可以定义并使用常量 */
	protected static final String TYPE = "Database";

	//即使有构造方法也不能被实例化
	public Database(){}
	public abstract void showName();
}