/**
 * 
 */
package inner;

/**
 * �ڲ�����ʾ4
 * <p>
 * ��;4��</br>
 * ������һ�������������������������ڶ����ڲ��࣬�������������ǣ�
 * <li>1��ʵ����ĳ���͵Ľӿڣ����Դ��������ض�������á�
 * <li>2����Ҫ���һ�����ӵ�������Ҫ����һ������������������� �����ֲ�ϣ��������ǹ������õġ�
 * 
 * @author ����ΰ
 *
 * �������ڣ�2008-4-13
 */
public class InnerClass4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InnerClass4 d = new InnerClass4();
		d.track();
	}

	private void internalTracking(boolean b) {
		/*
		 * ��Ȼ�ڲ����Ǳ�Ƕ����if������������
		 * �Ⲣ����˵����Ĵ�������������
		 * ����ʵ������һ��������
		 * �����ڶ������������������ǲ����õ�
		 * ����֮��ͱ����ͨ����һ����
		 */
		if (b) {
			class TrackingSlip {
				private String id;

				TrackingSlip(String s) {
					id = s;
				}

				String getSlip() {
					return id;
				}
			}
			TrackingSlip ts = new TrackingSlip("slip");
			ts.getSlip();
		}
		// ������������TrackingSlip�Ͳ�������
		// TrackingSlip ts = new TrackingSlip("cannot use");
	}

	public void track() {
		internalTracking(true);
	}
}