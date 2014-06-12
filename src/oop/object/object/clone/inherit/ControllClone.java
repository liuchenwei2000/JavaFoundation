/**
 * 
 */
package object.clone.inherit;

/**
 * ���ƿ�¡������ʾ
 * <p>
 * ���ϣ��һ������Ա���¡��</br>
 * <li>1.ʵ�� Cloneable �ӿڡ�
 * <li>2.���� clone()��
 * <li>3.����� clone()�е��� super.clone()��
 * <li>4.����� clone()�в����쳣��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2009-6-8
 */
public class ControllClone {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Ordinary[] objects = { new IsCloneable(), new WrongClone(),
				new NoMore(), new TryMore(), new BackOn(), new ReallyNoMore(), };
		// This won't compile; clone() is protected in Object:
		// Ordinary x = new Ordinary();
		// x = (Ordinary)x.clone();
		for (int i = 0; i < objects.length; i++){
			tryToClone(objects[i]);
			System.out.println();			
		}
	}

	private static Ordinary tryToClone(Ordinary object) {
		String clazz = object.getClass().getSimpleName();
		System.out.println("Attempting " + clazz);
		Ordinary x = null;
		if (object instanceof Cloneable) {
			try {
				x = (Ordinary) ((IsCloneable) object).clone();
				System.out.println("Cloned " + clazz);
			} catch (CloneNotSupportedException e) {
				System.out.println("Could not clone " + clazz);
			}
		} else {
			System.out.println("Doesn't implement Cloneable");
		}
		return x;
	}
}

/**
 * 1.�����ġ�
 * <p>
 * �������κο�¡��������ʹ�಻�ɿ�¡������ֻҪԸ�⣬��������������ӿ�¡������
 * ��ֻ����ȱʡ��Object.clone()�ܹ�����ش���������������ʱ�������á�
 * <p>
 * Ordinary������������ͣ�������"�ر�"��¡���������ǲ�֧��Ҳ����ֹ��¡��
 * ���������һ��Ordinary����Ķ�������������ת��ΪOrdinary�󣬾��޷��ֱ����Ƿ�ɿ�¡��
 */
class Ordinary {
}

/**
 * WrongClone����ʾ��ʵ�ֿ�¡���ƵĴ���ʽ��
 * ���� public ��ʽ������Object.clone()������û��ʵ��Cloneable��
 * ��˵��� super.clone()ʱ(���ջ����Object.clone())���׳� CloneNotSupportException�������޷���¡��
 */
class WrongClone extends Ordinary {
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

/**
 * 2.֧��clone()��
 * <p>
 * ���ձ�׼�Ĺ�����ʵ�� Cloneable �ӿڡ����� clone()������
 * �����ص�clone()�У����� super.clone()�������������쳣��
 * <p>
 * IsCloneable ִ����������ȷ�Ĳ��������� clone()������ʵ�� Cloneable �ӿڡ�
 * ֻ���쳣�׸������߽��д���
 */
class IsCloneable extends Ordinary implements Cloneable {
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

/**
 * 3.��������֧�ֿ�¡��
 * <p>
 * ��������������������ã����ǲ�һ���ǿɿ�¡�ģ������clone()����Ӧ�����ſ�¡���ǡ�
 * ����׳��쳣��ֻ�轫�쳣��������Ա��
 */

/**
 * 4.��ʵ�� Cloneable �ӿڣ������� protected ��ʽ���� clone()������Ϊ�������Դ�����ȷ�ĸ�����Ϊ��
 * <p>
 * ���Ǹ�����κ����࣬����������clone()������super.clone()������ȷ�ĸ�����Ϊ��
 * ��� clone()����(����Ӧ��)����super.clone()����ʹ super.clone()Ԥ�ڵ��Ǹ� Cloneable ����
 * û�˻�ֱ�Ӷ������Ķ������clone()��ֻ��ͨ����������У���Ҫ�������������������������ʵ��Cloneable �ӿڡ�
 */

/**
 * 5.��ʵ�� Cloneable �ӿڣ����� clone()ʹ֮�׳��쳣������ֹ��¡������
 * <p>
 * ֻ�д�����������࣬���ڸ��Ե�clone()�е��� super.clone()��������ֹ��¡�ķ����������á�
 * <p>
 * NoMore �ೢ��"�ر�"��¡������������ Java ����߽���ķ�ʽ��
 * ������� clone()���׳�CloneNotSupportedException��
 * ������� clone()���� super.clone()ʱ�����׳��쳣����ֹ��¡��
 */
class NoMore extends IsCloneable {
	
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}

/**
 * TryMore ��� clone()���� super.clone()ʱ�����׳��쳣����ֹ��¡��
 */
class TryMore extends NoMore {
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

/**
 * BackOn ʹ�ö����� duplication()���Ƶ�ǰ������clone()����ȡ���� super.clone()��
 * �ⲻ���׳��쳣�������µ���Ҳ�ǿɿ�¡�ġ���ˣ��޷������׳��쳣����ֹ��¡������
 */
class BackOn extends NoMore {
	
	private BackOn duplicate(BackOn b) {
		return new BackOn();
	}

	public Object clone() {
		return duplicate(this);
	}
}

/**
 * 6.�����������Ϊfinal����ֹ��¡��
 * <p>
 * ��������κθ���(������)��û������clone()����ô�˷������в�ͨ�ˡ�
 * �������������clone()����ô��������ٴ�����clone()�����׳�CloneNotSupportedException��
 * ��������Ϊfinal����Ψһ�б�֤�ķ�ֹ��¡�ķ�����
 * <p>
 * ReallyNoMore ʾ����Ψһ����������Ľ��������������Ϊfinal���Ͳ����Ա��̳��ˡ�
 * ����ζ�ţ������ final �����У�clone()�����׳��쳣�����������ᱻ�����޸ģ����Կ϶�����ֹ��¡��
 */
final class ReallyNoMore extends NoMore {
}