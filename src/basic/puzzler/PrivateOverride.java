/**
 * 
 */
package puzzler;

/**
 * ˽�з�������
 *
 * @author ����ΰ
 *
 * �������ڣ�2008-4-8
 */
public class PrivateOverride {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PrivateOverride p = new Derived();
		p.f();
		/*
		 * ʵ�������"private f() in PrivateOverride"
		 * ������Ϊprivate������final�����������������εġ�
		 * Derived���е�f()������һ��ȫ�µķ�������Ȼ�����f()�������಻�ɼ���Ҳ�Ͳ����ڸ��ǡ�
		 * ֻ�з�private�����ſ��Ա����ǣ����ǻ���Ҫע������private����������
		 * ��Ȼ���������ᱨ������Ҳ���ᰴ��������ִ�У����ڻ����е�private����������������ò��ò�ͬ������
		 */
	}

	private void f() {
		System.out.println("private f() in PrivateOverride");
	}
}

class Derived extends PrivateOverride {
	
	public void f() {
		System.out.println("public f() in Derived");
	}
}