/**
 * 
 */
package jdk7;

/**
 * 4��switch-case���֧���ַ�������
 * <p>
 * ��Java SE 7�У�switch-case������֧���ַ������͵����ݱ�����
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014��12��19��
 */
public class StringsInSwitchStatements {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String input = "Monday";
		String output = null;
		switch(input){
		case "Monday":
		    output = "����һ";
		    break;
		case "Tuesday":
		    output = "���ڶ�";
		    break;
		case "Wednesday":
		    output = "������";
		    break;
		case "Thursday":
		    output = "������";
		    break;
		case "Friday":
		    output = "������";
		    break;
		case "Saturday":
		    output = "������";
		    break;
		case "Sunday":
		    output = "������";
		    break;
		default:
		    throw new IllegalArgumentException("��Ч�����������" + input);
		}
		System.out.println(output); //���������һ
	}
}
