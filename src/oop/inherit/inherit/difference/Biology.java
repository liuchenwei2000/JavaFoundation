/**
 * 
 */
package inherit.difference;

/**
 * ������
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2007-8-28
 */
public abstract class Biology {
	
	protected String name;// ����
	protected int age;// ��������

	protected void setName(String newName) {
		name = newName;
	}

	protected String getName() {
		return name;
	}

	protected void setAge(int newAge) {
		age = newAge;
	}

	protected int getAge() {
		return age;
	}

	/**
	 * ����������Ϣ
	 */
	protected abstract String getDeathInfo();
}