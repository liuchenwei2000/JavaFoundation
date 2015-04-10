/**
 * 
 */
package enums;

/**
 * ����enum�еķ���
 *
 * @author ����ΰ
 *
 * ����ʱ�䣺2008-8-6
 */
public class OverrideInEnum {

	/**
	 * ������ͨ����
	 */
	enum Sex {
		MALE, FEMALE;

		/**
		 * ʵ���Ϻ͸�����ͨ��ķ���û��ʲô����
		 * 
		 * @see java.lang.Enum#toString()
		 */
		@Override
		public String toString() {
			return name().toLowerCase();
		}
	}
	
	/**
	 * ����Ϊ enum ʵ����д�������Ӷ�Ϊÿ��enum ʵ��������Բ�ͬ����Ϊ��Ҫʵ�ֳ�����صķ�����
	 * ��ҪΪ enum ����һ������ abstract ������Ȼ��ÿ�� enum ʵ��ʵ�ָó��󷽷���
	 */
	enum Signal {

		ON() {

			@Override
			String getDescription() {
				return "ON";
			}

		},
		
		OFF() {

			@Override
			String getDescription() {
				return "OFF";
			}
		};

		abstract String getDescription();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (Sex sex : Sex.values()) {
			System.out.println(sex);
		}
		
		for (Signal signal : Signal.values()) {
			System.out.println(signal.getDescription());
		}
	}
}