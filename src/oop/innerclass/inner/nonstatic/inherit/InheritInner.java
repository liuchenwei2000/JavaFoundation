/**
 * 
 */
package inner.nonstatic.inherit;

/**
 * �ڲ���ļ̳���ʾ
 * <p>
 * ��Ϊ�ڲ���Ĺ������������ӵ�ָ�����ⲿ���������ã�
 * �����ڼ̳��ڲ����ʱ��ָ���ⲿ���������ܵ����ñ��뱻��ʼ����
 * ���������в��ٴ��ڿ����ӵ�Ĭ�϶���Ҫ�������������ʹ��������﷨����ȷ��˵������֮��Ĺ�����
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2008-4-18
 */
public class InheritInner extends Outer.Inner{

	/**
	 * �޲ι������Ǳ��벻���ģ������ж��ⲿ�����Ĺ�����Ϣ
	 */
//	public InheritInner(){
//		
//	}
	
	/**
	 * ����ֻ�Ǵ���һ��ָ���ⲿ����������
	 * <p>
	 * �������ڹ������е�һ��ʹ�������﷨��
	 * 
	 * outerClassReference.super();
	 */
	public InheritInner(Outer outer){
		outer.super();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Outer outer = new Outer();
		@SuppressWarnings("unused")
		InheritInner ii = new InheritInner(outer);
	}
}