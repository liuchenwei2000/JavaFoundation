## Java 和正则表达式 ##

指定为字符串的正则表达式必须首先被编译为Pattern类的实例，然后可将得到的模式用于创建Matcher对象，依照正则表达式，该对象可以与任意字符序列匹配。执行匹配所涉及的所有状态都驻留在匹配器中，所以多个匹配器可以共享同一模式。

因此，典型的调用顺序是 

	Pattern p = Pattern.compile("a*b");
	Matcher m = p.matcher("aaaaab");
	boolean b = m.matches();

在仅使用一次正则表达式时，可以方便地通过Pattern类定义matches方法。此方法编译表达式并在单个调用中将输入序列与其匹配
	
	boolean b = Pattern.matches("a*b", "aaaaab");

等效于上面的三个语句，但是对于重复的匹配而言它效率不高，因为它不允许重用已编译的模式。 