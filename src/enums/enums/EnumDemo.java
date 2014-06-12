/**
 * 
 */
package enums;

/**
 * ö����ʾ��
 *
 * @author ����ΰ
 *
 * ����ʱ�䣺2008-8-6
 */
public class EnumDemo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// values()�������ö������ͬ�����飬���������е�Ԫ���ϸ񱣳�����enum��������˳��
		for (Day day : Day.values()) {
			// ����ö�ٳ���������(����ö�������е�λ�ã����г�ʼ��������Ϊ��)
			println(day + " ordinal: " + day.ordinal());
			// ö��ʵ����Comparable�ӿڣ����Խ��бȽ�
			println(day + ".compareTo(Day.THURSDAY) = " + day.compareTo(Day.THURSDAY));
			println(day + ".equals(Day.THURSDAY) = " + day.equals(Day.THURSDAY));
			println(day + " == equals(Day.THURSDAY) = " + (day == Day.THURSDAY));
			println(day + ".getDeclaringClass() = " + day.getDeclaringClass());
			println(day + ".name() = " + day.name());
			println("-----------------------------------------------");
		}
		// ��̬����valueOf(Class<T> enumType, String name)
		// ���ش�ָ�����Ƶ�ָ��ö�����͵�ö�ٳ���
		// ���Ʊ������ڴ�����������ö�ٳ������õı�ʶ����ȫƥ��
		println(Enum.valueOf(Day.class, "TUESDAY"));
		// �÷������淽��toString()�ܹ�����ö�ٶ���ĳ�����
		println(Day.FRIDAY.toString());
	}

	private static void println(Object object) {
		System.out.println(object);
	}
}