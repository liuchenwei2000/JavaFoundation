/**
 * 
 */
package syntax;

/**
 * if-else������
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2007-9-10
 */
public class IfElseDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int score = 76;
		char grade = ' ';
		// if-else���(��if������Ϊtrueʱ��ִ�����if�����ֱ������if-else��)
		if (score >= 90) {
			grade = 'A';
		} else if (score >= 80) {
			grade = 'B';
		} else if (score >= 70) {
			grade = 'C';
		} else if (score >= 60) {
			grade = 'D';
		} else {
			grade = 'E';
		}
		System.out.println("Grade " + grade);

		// ��if���(˳��ִ����ȥ)
		if (score >= 90) {
			grade = 'A';
		}
		if (score >= 80) {
			grade = 'B';
		}
		if (score >= 70) {
			grade = 'C';
		}
		if (score >= 60) {
			grade = 'D';
		}
		if (score < 60) {
			grade = 'E';
		}
		System.out.println("Grade " + grade);
	}
}