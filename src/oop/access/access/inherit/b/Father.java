/**
 * 
 */
package access.inherit.b;

import access.inherit.a.GrandFather;
import access.inherit.c.Son;

/**
 * ����
 * <p>
 * ��ʾprotected�����ķ��ʿ��ƺ��壺</br>
 * ���游�ࡢ���ࡢ����������಻ͬ��ʱ��
 * <li>���ڸ��������游��Ķ�����ö��󲻿ɷ�������protected��Ա
 * <li>���ڸ�������������Ķ�����ö�����Է�������protected��Ա
 * <li>�����protected static��Ա�򶼿��Է���
 * 
 * @author ����ΰ
 *
 * �������ڣ�2007-11-9
 */
public class Father extends GrandFather {

	public Father() {
	}

	/**
	 * �����Լ���age
	 */
	public int getAge() {
		return this.age;
	}

//	/**
//	 * �����游��age
//	 */
//	public int getGrandFatherAge(GrandFather gf) {
//		return gf.age;
//	}

	/**
	 * ���ض��ӵ�age
	 */
	public int getSonAge(Son son) {
		return son.age;
	}

	/**
	 * ���������age
	 */
	public <T extends Father> int getChildAge(T t) {
		return t.age;
	}
	
	/**
	 * �����Լ���name
	 */
	public String getName() {
		return Father.name;
	}
	
	/**
	 * �����游��name
	 */
	public String getGrandFatherName() {
		return GrandFather.name;
	}
	
	/**
	 * ���ض��ӵ�name
	 */
	public String getSonName() {
		return Son.name;
	}
	
	/**
	 * ���������name
	 */
	public <T extends Father> String getChildName() {
		return T.name;
	}
}