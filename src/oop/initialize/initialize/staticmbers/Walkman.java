/**
 * 
 */
package initialize.staticmbers;

/**
 * Walkman��
 * 
 * @author ����ΰ
 *
 * �������ڣ�2007-11-8
 */
public class Walkman {

	private int code;// ���

	protected Walkman(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * �����ʽ��Walkman (2)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Walkman (" + getCode() + ")";
	}
}