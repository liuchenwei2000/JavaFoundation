/**
 * 
 */
package enums.itf;

/**
 * ���Ͻӿ�
 * <p>
 * �����ʹ�����ཫһ��enum�е�Ԫ�ؽ��з��飬��Ϊ����ʹ�ü̳С�</br>
 * ����ֻ�ܲ�������������ﵽĿ�ģ�</br>
 * ����һ���ӿڣ�Ȼ�󴴽�ʵ�ָýӿڵ�ö�٣��Դ˽�Ԫ�ؽ��з��顣
 * ����enum���ԣ�ʵ�ֽӿ���ʹ�����໯��Ψһ������
 * <p>
 * �ӿڵ������ǽ�����������enum��ϳ�һ���������͡�
 * 
 * @author ����ΰ
 * 
 * ����ʱ�䣺2008-8-6
 */
public interface Drink {

	/**
	 * ˮ
	 */
	public enum Water implements Drink {

		HOTWATER("�׿�ˮ"), CLEANWATER("����ˮ");

		private String name;

		private Water(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return super.toString() + "(" + name + ")";
		}

		public static String getType() {
			return "ˮ";
		}
	}

	/**
	 * ����
	 */
	public enum Coffee implements Drink {

		NEST("ȸ��"), G7("Խ��G7"), BLUE("��ɽ����");

		private String name;

		private Coffee(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return super.toString() + "(" + name + ")";
		}

		public static String getType() {
			return "����";
		}
	}

	/**
	 * ��
	 */
	public enum Tea implements Drink {

		GREENTEA("�̲�"), BLACKTEA("���"), OOLONGTEA("������"), JASMINETEA("���򻨲�");

		private String name;

		private Tea(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return super.toString() + "(" + name + ")";
		}

		public static String getType() {
			return "��";
		}
	}

	/**
	 * ��֭
	 */
	public enum Juice implements Drink {

		APPLE("ƻ��֭"), PEACH("��֭"), GRAPE("����֭");

		private String name;

		private Juice(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return super.toString() + "(" + name + ")";
		}

		public static String getType() {
			return "��֭";
		}
	}
}