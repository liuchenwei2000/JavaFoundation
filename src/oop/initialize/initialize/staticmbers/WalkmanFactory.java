/**
 * 
 */
package initialize.staticmbers;

/**
 * Walkman����������
 * 
 * @author ����ΰ
 *
 * �������ڣ�2007-11-8
 */
public class WalkmanFactory {

	private static int code = 1;// ���

	private WalkmanFactory() {
		// do nothing and no instance
	}

	public static Walkman createWalkman() {
		return new Walkman(getCode());
	}

	/**
	 * ÿ����һ��Walkman��ž�+1
	 */
	public static int getCode() {
		return code++;
	}
}