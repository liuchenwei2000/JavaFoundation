/**
 * 
 */
package inherit.itf;

/**
 * 数据库连接接口
 * <p>
 * 接口：</br>
 * 是一些方法特征的集合，它们一般都是来自于一些在系统中不断出现的方法。
 * 接口只是方法的特征没有方法的实现，这些方法在不同的地方被实现时会有不同的行为。
 * <p>
 * 注：</br>
 * 接口中的实例变量都是默认final static的，它们的值不可通过实现类改变且必须以常量初始化。
 * 实现类必须实现接口中的所有的方法，否则必须声明为abstract类
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2007-8-28
 */
public interface IDatabaseConnection {
	
	public void connect();// 连接数据库的方法
}