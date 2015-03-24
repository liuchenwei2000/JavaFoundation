/**
 * 
 */
package generic.app;


/**
 * ��������������
 * <p>
 * �������Ϊ�κ��๹��һ����������ֻҪ�������Ĭ�ϵĹ�������
 * 
 * @author ����ΰ
 *
 * �������ڣ�2008-5-15
 */
public class BasicGenerator<T> implements Generator<T> {
	
	private Class<T> type;// ���ɶ��������
	
	/**
	 * type���͵�������
	 */
	public BasicGenerator(Class<T> type) {
		this.type = type;
	}
	
	/**
	 * Ϊtype���ʹ���Ĭ�ϵ�������
	 * <p>
	 * �÷�������ֱ��������BasicGenerator.create(Integer.class)��
	 * ������ִ���鷳��new BasicGenerator<Integer>(Integer.class)��
	 */
	public static <T> Generator<T> create(Class<T> type){
		return new BasicGenerator<T>(type);
	}
	
	/**
	 * ����ָ�����͵Ķ���
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