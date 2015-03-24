/**
 * 
 */
package object.clone;

public class Int {

	private int i;

	public Int(int i) {
		this.i = i;
	}

	public void increment() {
		i++;
	}

	public String toString() {
		return Integer.toString(i);
	}
}
