/**
 * 
 */
package jdk7;

/**
 * 2������ֵ��������ֵ��ʹ���»��߷ָ�
 * <p>
 * ��Java SE 7�У���֧�����»�����Ϊ�ָ������ӵ���ֵ��ʾ��ʽ��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014��12��19��
 */
public class UnderscoresInNumericLiterals {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//ʮ������ʽ
		int anInt1 = 123_45_6;
		System.out.println(anInt1);
		//�����ơ�ʮ�����Ƶ���ʽҲ֧��
		int anInt2 = 0b10_0110_100;
		System.out.println(anInt2);
		int anInt3 = 0xFF_EC_DE_5E;
		System.out.println(anInt3);
		//С����ʽҲ֧��
		float pi = 3.14_15F;
		System.out.println(pi);
		double aDouble = 3.14_15;
		System.out.println(aDouble);
		//����»�������
		int chain = 5______2____0;
		System.out.println(chain);
		
		//�»��߲��ܷ������
//		int x = 52_;                //����
		//�»��߲����ڽ�С����(�ڽ�С����ǰ�󶼲���)
//		float pi1 = 3_.1415F;       // ����
//		float pi2 = 3._1415F;       //����
		//�»��߲��ܽ����ں�׺��L����F����ǰ��
//		float pi3 = 3.1415_F;       //����
//		long aLong1 = 999_99_9999_L;//����
		//�»��߲��ܷ��ڱ�ʾ���Ƶ�ǰ׺�ַ�֮��
//		int x5 = 0_x52;             //����
	}
}
