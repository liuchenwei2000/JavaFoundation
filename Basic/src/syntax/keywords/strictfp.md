## strictfp 关键字概论 ##
                          
浮点数运算有两种方式：严格的(FP-strict)和非严格的(not FP-strict)。

FP-strict 方式下的运算结果都是精确的，遵循IEEE754标准，并且和JVM和底层硬件没有关系。not FP-strict 方式的运算规则有些松散，它可以使用避免 FP-strict 方式下运算时的数据溢出的表示法。这样使得它在不同的JVM上的运算结果可能不同，但是它要比FP-strict方式运算的快，因为它所使用的表示法是底层硬件直接支持的。

Java 默认的是运算方式是not FP-strict，如果想要让某个类或者方法是 FP-strict 运算方式，则需要声明为strictfp。
strictfp关键字不参与继承体系，即子类继承strictfp修饰的父类时自身并不是strictfp的。

一旦使用了strictfp来声明一个类、接口或者方法时，那么所声明的范围内Java的编译器以及运行环境会完全依照浮点规范IEEE-754来执行。例如一个类被声明为strictfp，那么该类中所有的方法都是strictfp的。因此如果你想让你的浮点运算更加精确，而且不会因为不同的硬件平台所执行的结果不一致的话，那就请用关键字strictfp。

可以将一个类、接口以及方法声明为strictfp，但是不允许对接口中的方法以及构造函数声明strictfp关键字，例如下面的代码：

* 合法的使用关键字strictfp

		strictfp interface A {}
		
		public strictfp class FpDemo1 {
		    strictfp void f() {}
		}

* 错误的使用方法

		interface A {
		    strictfp void f();
		}
		
		public class FpDemo2 {
		    strictfp FpDemo2() {}
		}


