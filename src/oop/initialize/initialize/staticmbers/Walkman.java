/**
 * 
 */
package initialize.staticmbers;

/**
 * Walkman类
 * 
 * @author 刘晨伟
 *
 * 创建日期：2007-11-8
 */
public class Walkman {

	private int code;// 编号

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
	 * 输出形式：Walkman (2)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Walkman (" + getCode() + ")";
	}
}