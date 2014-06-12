/**
 * 
 */
package inherit.more;

/**
 * ʹ�ü̳к���Ͻ�����Ƶ���ʾ
 * <p>
 * ��ϲ���ǿ�Ƴ�����ƽ���̳еĲ�νṹ��������ϸ������
 * ��Ϊ�����Զ�̬ѡ������(Ҳ��ѡ������Ϊ)���෴�̳��ڱ���ʱ����Ҫ֪��ȷ�����͡�
 * <p>
 * һ��ͨ�õ�׼���ǣ�</br>
 * �ü̳б����Ϊ��Ĳ��죬�����ֶα��״̬�ϵı仯��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2008-4-10
 */
public class InheritAndCompositeDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Stage stage = new Stage();
		stage.performPlay();
		stage.change();
		stage.performPlay();
	}
}

class Actor {
	public void act() {
	}
}

class HappyActor extends Actor {
	public void act() {
		System.out.println("HappyActor");
	}
}

class SadActor extends Actor {
	public void act() {
		System.out.println("SadActor");
	}
}

/**
 * ����г�ʼ���������õ�λ����������</br>
 * <li>1���ڶ������ĵط�������ζ�����������ܹ��ڹ�����������֮ǰ����ʼ����
 * <li>2������Ĺ�������   3��������Ҫʹ����Щ����֮ǰ(������)��
 */
class Stage {
	// ��һ�ֳ�ʼ����ʽ
	private Actor actor1 = new HappyActor();
	
	@SuppressWarnings("unused")
	private Actor actor2;
	private Actor actor3;

	public Stage(){
		// �ڶ��ֳ�ʼ����ʽ
		actor2 = new HappyActor();
	}
	
	/**
	 * �����ֳ�ʼ����ʽ
	 */
	public Actor getActor3() {
		if (actor3 == null) {
			actor3 = new HappyActor();
		}
		return actor3;
	}
	
	public void change() {
		actor1 = new SadActor();
	}

	public void performPlay() {
		actor1.act();
	}
}