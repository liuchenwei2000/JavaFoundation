/**
 * 
 */
package string;

/**
 * String类的基本方法
 * <p>
 * String类是非可变类(对象一旦创建了就不能够改变其内在状态了)。
 * <p>
 * String s1 = new String("kill"); 
 * 不管怎么样都要在堆中创建一个对象。
 * <p>
 * String s2 = "kill"; 
 * 首先在String Pool池(栈)中找(通过equal)有没有"kill"这个对象，
 * 如果有则直接把引用指向这个"kill"对象；如果没有则在堆中创建一个对象。
 * 并且把该引用添加到String Pool中，而对第一种情况JVM是不会主动添加到String Pool中去的。
 * <p>
 * String类中的每一个看起来会修改String值的方法， 实际上都是创建了一个全新的String对象以包含修改后的字符串， 而最初的String对象则丝毫未动。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2007-8-8
 */
public class StringDemo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
        String s = "This is a string.";
        // 通过字符数组创建字符串
		char[] ch = { 't', 'h', 'i', 's', ' ', 'i', 's', ' ', 'a', ' ', 's',
				't', 'r', 'i', 'n', 'g' };
		s = new String(ch);
		System.out.println("s : " + s);
		// 返回此字符串的哈希码
		System.out.println("s.hashCode()=" + s.hashCode());
		// 返回此字符串的长度
		System.out.println("s.length()=" + s.length());
		// 返回指定索引处的char值
		System.out.println("s.charAt(0) : " + s.charAt(0));
		String as = "Another string.";
		System.out.println("as : " + as);
		/*
		 * compareTo(String str)按字典顺序比较两个字符串 
		 * 如果按字典顺序此String对象在参数字符串之前、之后、相等 则比较结果为一个负整数、正整数、0 
		 * 
		 * compareToIgnoreCase(String str)
		 * 不考虑大小写，按字典顺序比较两个字符串
		 */
		if (s.compareTo(as) < 0) {
			System.out.println("s is before as.");
		} else if (s.compareTo(as) > 0) {
			System.out.println("s is after as.");
		} else {
			System.out.println("s equals as.");
		}
		/*
		 * equals(Object anObject)比较此字符串与指定的对象 
		 * 
		 * equalsIgnoreCase(String anotherString) 
		 * 将此 String 与另一个 String 进行比较，不考虑大小写
		 */
		as = "this is a string.";
		System.out.println("Now as : " + as);
		if (s.equals(as)) {
			System.out.println("s equals as.");
		} else if (s.equalsIgnoreCase(as)) {
			System.out.println("s equals as (ignore case).");
		} else {
			System.out.println("s not equals as.");
		}
		/*
		 * contentEquals(StringBuffer sb) 
		 * 当且仅当此String表示与指定的StringBuffer相同的字符序列时，才返回 true。
		 */
		StringBuffer sb = new StringBuffer();
		sb.append("This is a string.");
		System.out.println("sb : " + sb);
		if (s.contentEquals(sb)) {
			System.out.println("s content equals sb.");
		} else {
			System.out.println("s content not equals sb.");
		}
		/*
		 * indexOf(int ch)返回指定字符在此字符串中第一次出现处的索引 
		 * indexOf(String str)返回第一次出现的指定子字符串在此字符串中的索引 
		 * lastIndexOf(int ch)返回最后一次出现的指定字符在此字符串中的索引
		 * lastIndexOf(String str)返回在此字符串中最右边出现的指定子字符串的索引
		 */
		System.out.println("'s' is first found at " + s.indexOf('s'));
		System.out.println("'s' is last found at " + s.lastIndexOf('s'));
		/*
		 * replace(char oldChar, char newChar)返回一个新的字符串
		 * 它是通过用newChar替换此字符串中出现的所有oldChar而生成的 
		 * 
		 * replaceAll(String regex, String replacement) 
		 * 使用给定的replacement字符串替换此字符串匹配给定的正则表达式的每个子字符串
		 * 
		 * replaceFirst(String regex, String replacement)
		 * 使用给定的replacement字符串替换此字符串匹配给定的正则表达式的第一个子字符串
		 */
		System.out.println("After replacing s is : " + s.replace('s', 'S'));
		/*
		 * endsWith(String suffix)测试此字符串是否以指定的后缀结束
		 * 
		 * startsWith(String prefix)测试此字符串是否以指定的前缀开始
		 * 
		 * startsWith(String prefix,int toffset)测试此字符串是否以指定前缀开始，该前缀以指定索引开始
		 */
		if (s.startsWith("Th"))
			System.out.println("s starts with 'Th'.");
		else
			System.out.println("s not starts with 'Th'.");
		if (s.startsWith("hi", 1))
			System.out.println("s starts with 'hi' at index = 1.");
		else
			System.out.println("s not starts with 'hi' at index = 1.");
		if (s.endsWith("ing"))
			System.out.println("s ends with 'ing'.");
		else
			System.out.println("s not ends with 'ing'.");
		// substring(int beginIndex)从索引位置返回一个新的字符串，它是此字符串的一个子字符串。
		System.out.println("Sub string after 3 of s : " + s.substring(3));
		// toCharArray()将此字符串转换为一个新的字符数组
		char[] c = s.toCharArray();
		System.out.print("s to char array : ");
		for (int i = 0; i < c.length; i++) {
			System.out.print(c[i]);
		}
		System.out.println();
		/*
		 * toLowerCase()使用默认语言环境的规则将此String中的所有字符都转换为小写
		 * 
		 * toUpperCase()使用默认语言环境的规则将此String中的所有字符都转换为大写
		 */
		System.out.println("s.toLowerCase() : " + s.toLowerCase());
		System.out.println("s.toUpperCase() : " + s.toUpperCase());
		// split(String regex)根据给定的正则表达式的匹配来拆分此字符串
		String[] sArray = s.split(" ");
		System.out.print("After s.split(\" \") s :");
		for (int i = 0; i < sArray.length; i++) {
			System.out.print(sArray[i]);
		}
		System.out.println();
		/*
		 * intern()方法返回一个字符串，内容与调用该方法的字符串相同，但它保证来自字符串池中
		 * 
		 * String类有一个初始时为空的字符串池，它由类String私有地维护
		 * 当调用intern方法时，如果池已经包含一个等于此String对象的字符串(该对象由equals(Object)方法确定)
		 * 则返回池中的字符串。否则，将此 String 对象添加到池中，并且返回此 String 对象的引用 
		 * 它遵循对于任何两个字符串s和t，当且仅当s.equals(t)为true时，s.intern() == t.intern()才为true
		 */
		s = "test intern";
		String s1 = "test intern".intern();
		String result = s == s1 ? "" : " not";
		System.out.println("s and s1 " + result + "have the same string object");
		// trim()使得字符串删除最前或最后的空格
		s = "  I see it  ";
		System.out.println("s.trim() : " + s.trim());
	}
}