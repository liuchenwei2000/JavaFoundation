/**
 * 
 */
package enums;

/**
 * ����enum�еķ���
 * <p>
 * ʵ���Ϻ͸�����ͨ��ķ���û��ʲô����
 *
 * @author ����ΰ
 *
 * ����ʱ�䣺2008-8-6
 */
public class OverrideInEnum {

	enum Sex {
		MALE, FEMALE;

		@Override
		public String toString() {
			return name().toLowerCase();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (Sex sex : Sex.values()) {
			System.out.println(sex);
		}
	}
}