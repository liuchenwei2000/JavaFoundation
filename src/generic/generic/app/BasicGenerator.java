/**
 * 
 */
package generic.app;


/**
 * 对象生成器基类
 * <p>
 * 该类可以为任何类构造一个生成器，只要该类具有默认的构造器。
 * 
 * @author 刘晨伟
 *
 * 创建日期：2008-5-15
 */
public class BasicGenerator<T> implements Generator<T> {
	
	private Class<T> type;// 生成对象的类型
	
	/**
	 * type类型的生成器
	 */
	public BasicGenerator(Class<T> type) {
		this.type = type;
	}
	
	/**
	 * 为type类型创建默认的生成器
	 * <p>
	 * 该方法可以直接用形如BasicGenerator.create(Integer.class)，
	 * 而不必执行麻烦的new BasicGenerator<Integer>(Integer.class)。
	 */
	public static <T> Generator<T> create(Class<T> type){
		return new BasicGenerator<T>(type);
	}
	
	/**
	 * 生成指定类型的对象
	 * 
	 * @see generic.app.Generator#generate()
	 */
	public T generate() {
		try {
			return type.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}