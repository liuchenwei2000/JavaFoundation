/**
 * 
 */
package inherit.more;

/**
 * 图形接口
 * <p>
 * 接口在extends时可以继承多个接口。
 * <p>
 * 若是在接口发布之后想增加新的方法，不能直接在原接口中添加，那样会破坏实现该接口的类。
 * 可以再写一个接口增加该方法，让其他类选择实现该接口。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2007-8-2
 */
public interface IFigure extends IArea, IGirth {
	
	void draw();
}
