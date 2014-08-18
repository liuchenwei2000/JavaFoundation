/**
 * 
 */
package object;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 为类创建一个好的hashCode()方法
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2007-8-8
 */
public class GoodHashCode {
	
    private static List<String> created = new ArrayList<String>();
	private String s;
	private int id = 0;

	public GoodHashCode(String s) {
		this.s = s;
		// id代表包含相同String的对象的编号
		created.add(s);
		Iterator<String> it = created.iterator();
		while (it.hasNext()) {
			if (it.next().equals(s))
				id++;
		}
	}

	/**
	 * 对象的各属性相同则认为equals
	 *
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		return (o instanceof GoodHashCode) && (s.equals(((GoodHashCode) o).s))
				&& id == ((GoodHashCode) o).id;
	}

	/**
	 * 基于s和id这两个字段产生hashCode
	 *
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int result = 17;
		result = 37 * result + s.hashCode();
		result = 37 * result + id;
		return result;
	}

	/**
	 * 形式为：String:hi  id:2  hashCode():146448 = 1
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "String:" + s + "  id:" + id + "  hashCode():" + hashCode();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<GoodHashCode, Integer> map = new HashMap<GoodHashCode, Integer>();
		GoodHashCode[] ghc = new GoodHashCode[10];
		for (int i = 0; i < ghc.length; i++) {
			ghc[i] = new GoodHashCode("hi");
			map.put(ghc[i], new Integer(i));
		}
		System.out.println(map);
	}
}