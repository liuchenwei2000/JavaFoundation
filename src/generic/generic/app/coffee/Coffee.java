/**
 * 
 */
package generic.app.coffee;

/**
 * Coffee��
 * 
 * @author ����ΰ
 *
 * �������ڣ�2008-5-14
 */
public class Coffee {
	
	// ����ͳ��Coffee�������Ŀ
	private static int counter = 0;
	// ÿһ��Coffee������Ψһ�Ĳ��ɱ��id
	private final int id = counter++;
	
	/**
	 * ������ʽ�������ʵ������ id
	 *
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return getClass().getSimpleName() + " " + id;
	}
}