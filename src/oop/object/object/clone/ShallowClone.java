/**
 * 
 */
package object.clone;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * ǳ��¡��ʾ
 * <p>
 * ǳ��¡�������صĶ����¡���´����Ķ���ȷ�ĸ�����ԭ�������ֵ����������ĳ��������������������ã���ôֻ����������á�
 * <p>
 * ʹ��Java��׼���ArrayList��Ϊ���ӡ�
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2009-6-5
 */
public class ShallowClone {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Int> oldList = new ArrayList<Int>();
		for (int i = 0; i < 10; i++) {
			oldList.add(new Int(i));
		}
		System.out.println("oldList: " + oldList);
		
		/*
		 * ArrayList��clone()���������Զ���¡��������ÿ�����󣬿�¡��ArrayListֻ�ǽ�ԭArrayList�еĶ����������
		 */
		ArrayList<?> newList = (ArrayList<?>) oldList.clone();
		Iterator<?> e = newList.iterator();
		while (e.hasNext()) {
			((Int) e.next()).increment();
		}
		System.out.println("oldList: " + oldList);
	}
}