/**
 * 
 */
package enums;

/**
 * ����ת��ö��
 * <p>
 * ʵ����values()�������ɱ����ڲ��뵽enum�����е�static������ ���������enumʵ������ת��ΪEnum����values()�����Ͳ������ˡ�
 * ������Class����һ��getEnumConstants()�������Դﵽ��ͬЧ���� ���Լ�ʹEnum�ӿ���û��values��������Ȼ���Ի�����е�enumʵ����
 *
 * @author ����ΰ
 *
 * ����ʱ�䣺2008-8-6
 */
public class UpcastEnum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Enum<?> e = Season.SPRING;
		// e.values();Enum�в�û�ж���÷���
		for (Enum<?> en : e.getClass().getEnumConstants()) {
			System.out.println(en);
		}
	}
}

enum Season {
	SPRING, SUMMER, AUTUMN, WINTER
}