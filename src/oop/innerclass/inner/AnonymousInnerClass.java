/**
 * 
 */
package inner;

/**
 * �����ڲ�����ʾ
 * <p>
 * �����ڲ����������ļ̳������Щ���ޣ�</br>
 * ��Ϊ�����ڲ���ȿ�����չ�࣬Ҳ����ʵ�ֽӿڣ����ǲ������߼汸�����ʵ�ֽӿ�ֻ��ʵ��һ����
 * 
 * @author ����ΰ
 *
 * �������ڣ�2008-4-14
 */
public class AnonymousInnerClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AnonymousInnerClass aicd = new AnonymousInnerClass();
		System.out.println(aicd.getSong().getSongName());
		aicd.getGame("basketball").play();
		getBase(47).f();
	}
	
	public Song getSong(){
		/*
		 * �����������ģ���û�����֣��⿴�����ƺ�����Ҫ����һ��Game����
		 * �����ڵ����������ķֺ�֮ǰȴ�У���һ�ȣ�Ҫ���������һ����Ķ��塣
		 * ����ָ������һ���̳���Game��������Ķ���
		 */
		return new Song(){
			@Override
			public String getSongName() {
				return "����";
			}
		};
	}
	
	public Game getGame(final String name) {
		/*
		 * ���̳еĸ���Ĺ�������Ҫ����ʱ������Ҫ���ݺ��ʵĲ���������Ĺ�������
		 * ��������ڲ���ʹ����һ�������ⲿ����Ķ�����ô������Ҫ�������������final�ġ�
		 */
		return new Game(name) {
			public void play() {
				System.out.println("paly " + name + " inside");
			}
		};
	}
	
	public static Base getBase(int i) {
		/*
		 * ��Ϊ�������ڲ�����û���������������������һЩ���ƹ���������Ϊ����ͨ�� ʵ����ʼ����
		 * (��Ҫ��iһ����final�ģ���Ϊi�Ǳ����ݸ�������Ļ���Ĺ��������������������ڲ���ֱ��ʹ��)
		 */
		return new Base(i) {
			{
				// ʵ����ʼ����Ч�����ǹ�����
				// ���ǲ�������ʵ����ʼ�����������ֻ�������Ĺ�����
				System.out.println("Inside instance initializer");
			}

			public void f() {
				System.out.println("In anonymous f()");
			}
		};
	}
}

class Song {

	public String getSongName() {
		return "song";
	}
}

class Game {

	private String name;

	public Game(String name) {
		this.name = name;
	}

	public void play() {
		System.out.println("paly " + name + " outside");
	}
}

abstract class Base {
	
	public Base(int i) {
		System.out.println("Base constructor.i = " + i);
	}

	public abstract void f();
}