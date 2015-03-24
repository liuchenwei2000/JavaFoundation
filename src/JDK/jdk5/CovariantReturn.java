/**
 * 
 */
package jdk5;

/**
 * ����Э������
 * <p>
 * ��ʾ�������еı����Ƿ������Է��ػ��෽���ķ������͵������͡�
 *
 * @author ����ΰ
 *
 * �������ڣ�2008-4-10
 */
public class CovariantReturn {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ReturnFather rf = new ReturnFather();
		Father f = rf.get();
		System.out.println(f);
		rf = new ReturnSon();
		f = rf.get();
		System.out.println(f);
	}
}

class Father {
	
	public String toString() {
		return "Father";
	}
}

class Son extends Father {
	
	public String toString() {
		return "Son";
	}
}

class ReturnFather {
	
	public Father get() {
		return new Father();
	}
}

class ReturnSon extends ReturnFather {
	
	public Son get() {
		return new Son();
	}
}