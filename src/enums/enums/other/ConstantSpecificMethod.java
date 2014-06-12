/**
 * 
 */
package enums.other;

import java.text.DateFormat;
import java.util.Date;

/**
 * ������صķ���
 * <p>
 * enum����Ϊ��ʵ����д�������Ӷ�Ϊÿ��ʵ�����費ͬ����Ϊ��
 * Ҫʵ�ֳ�����صķ�������ҪΪenum����abstract������Ȼ��Ϊÿ��enumʵ��ʵ�ָó��󷽷���
 * ÿ��enumԪ�ض���һ��enum���͵�static finalʵ����
 *
 * @author ����ΰ
 *
 * ����ʱ�䣺2008-8-7
 */
public enum ConstantSpecificMethod {
	
	DATE_TIME {
		String getInfo() {
			return DateFormat.getDateInstance().format(new Date());
		}
	},

	CLASSPATH {
		String getInfo() {
			return System.getenv("CLASSPATH");
		}
	},

	VERSION {
		String getInfo() {
			return System.getProperty("java.version");
		}
	};

	/**
	 * enum����ĳ��󷽷�����ʵ������ʵ��
	 */
	abstract String getInfo();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (ConstantSpecificMethod e : ConstantSpecificMethod.values()) {
			System.out.println(e.getInfo());
		}
	}
}