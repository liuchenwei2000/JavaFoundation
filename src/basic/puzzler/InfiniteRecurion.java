/**
 * 
 */
package puzzler;

import java.util.ArrayList;
import java.util.List;

/**
 * ����ʶ�����޵ݹ�
 * 
 * @author ����ΰ
 *
 * �������ڣ�2008-5-7
 */
public class InfiniteRecurion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<InfiniteRecurion> list = new ArrayList<InfiniteRecurion>();
		for (int i = 0; i < 10; i++) {
			list.add(new InfiniteRecurion());
		}
		System.out.println(list);
	}

	/**
	 * ���﷢�����Զ�����ת������InfiniteRecurion����ת������String���͡�
	 * ��Ϊ����������һ��String����������һ��"+"��������Ķ�����String�����������Ž�thisת����һ��String�����ǵ���������toString������
	 * ���������ӡ������ڴ��ַӦ�õ���Object���е�toString����������ʹ��this��ʹ��super�����ø����toString������
	 *
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return "InfiniteRecursion address: " + this + "\n";
	}
}