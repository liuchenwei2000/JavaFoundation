/**
 * 
 */
package enums.other;

import java.util.EnumSet;
import static enums.other.SignalNumber.*;

/**
 * EnumSet��ʾ
 * <p>
 * EnumSet����ö������һ��ʹ�õ�ר��Setʵ�֣�ö��set�����м����������Ե���ö�����ͣ�
 * ��ö�������ڴ���setʱ��ʽ����ʽ��ָ����</br>
 * �����ŵ��ǣ��ٶȿ죬���ܺá�
 *
 * @author ����ΰ
 *
 * ����ʱ�䣺2008-8-6
 */
public class EnumSetDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// ����һ������ָ��Ԫ�����͵Ŀ�ö��set
		EnumSet<SignalNumber> set = EnumSet.noneOf(SignalNumber.class);
		set.add(ONE);
		System.out.println(set);
		// ����һ���������ָ��Ԫ�ص�ö��set
		set.addAll(EnumSet.of(ONE, ZERO));
		System.out.println(set);
		// ����һ������ָ��Ԫ�����͵�����Ԫ�ص�ö��set
		set = EnumSet.allOf(SignalNumber.class);
		System.out.println(set);
		set.removeAll(EnumSet.of(ONE, ZERO));
		System.out.println(set);
		// ����һ����Ԫ��������ָ��ö��set��ͬ��ö��set
		// �������ָ�� set �����������Ĵ����͵�����Ԫ��(����)
		set = EnumSet.complementOf(set);
		System.out.println(set);
	}
}

/**
 * ������ö��
 */
enum SignalNumber {
	ONE, ZERO, NEGATIVEONE
}