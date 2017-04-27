## Java 基本类型 ##
               
	   类型          存储要求
	
	   byte           1字节
	   short          2字节
	   int            4字节
	   long           8字节
	   char           2字节
	   float          4字节
	   double         8字节
               
* 1，long 类型的数值有一个后缀 L，十六进制数值有一个前缀 0x
* 2，八进制有一个前缀 0，但是易混淆，最好不用。
* 3，float 型浮点数有效位数 7，有一个后缀是 F。
* 4，double 型浮点数有效位数 15。
* 5，所有的浮点数值计算都遵循IEEE 754规范，另外还有三个特殊的浮点数值：

	正无穷大：Double.POSITIVE_INFINITY  
	负无穷大：Double.NEGATIVE_INFINITY  
	NaN(Not a Number)：Double.NaN

* 6，浮点数值不适用于禁止出现舍入误差的金融计算中。
* 7，如果在数值计算中不含有任何舍入误差，就应该使用 BigDecimal 类。
* 8，char 是用 UTF-16 表示的，2 个字节。

### 特殊字符的转义序列符

	\b 退格
	\t 制表
	\n 换行
	\r 回车
