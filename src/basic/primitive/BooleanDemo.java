/**
 * 
 */
package primitive;

import java.util.HashMap;
import java.util.Map;

/**
 * boolean��װ�����ʾ
 * <p>
 * Boolean����û��̫��ʵ�õķ��������������������ᾭ�����õ���
 * Boolean.TRUE �� Boolean.FALSE��
 * 
 * ����Ҫ����Boolean����ʱʹ�����������������Ч�ʡ�
 * 
 * @author ����ΰ
 *
 * �������ڣ�2007-11-13
 */
public class BooleanDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("A", Boolean.TRUE);
		map.put("B", Boolean.FALSE);
		map.put("C", Boolean.TRUE);
		map.put("D", Boolean.FALSE);
		map.put("E", Boolean.TRUE);
		System.out.println(map);
	}
}