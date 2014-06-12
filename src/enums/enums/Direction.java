/**
 * 
 */
package enums;

/**
 * ��enum����ӷ���
 *
 * @author ����ΰ
 *
 * ����ʱ�䣺2008-8-6
 */
public enum Direction {
	
	// enum�е����б�������ʵ���Ķ���
	EAST("This is east!"), WEST("This is west!"), SOUTH("This is south!"), NORTH(
			"This is north!");

	// �����Ҫ��ӷ���(������)���������enumʵ�����е�������һ���ֺ�
	private String description;

	/**
	 * ����������涨��enumʵ���Ĺ�����ʽ(�����ṩһ��String����)��
	 * ��ʹ������private�ģ�һ��enumʵ���Ķ���������������Ͳ�������ʹ���乹�����������κ�ʵ���ˡ�
	 */
	private Direction(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (Direction direction : Direction.values()) {
			System.out.println(direction + " : " + direction.getDescription());
		}
	}
}