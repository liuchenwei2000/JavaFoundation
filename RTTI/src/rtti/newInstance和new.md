## newInstance 方法和 new 区别 ##

在初始化一个类生成一个实例的时候 newInstance() 方法和 new 关键字除了一个是方法，一个是关键字外。它们的区别在于创建对象的方式不一样，前者是使用类加载机制，后者是创建一个新类。那么为什么会有两种创建对象方式？这主要考虑到软件的可伸缩、可扩展和可重用等软件设计思想。 

Java中工厂模式经常使用 newInstance() 方法来创建对象

例如：
	
	Class c = Class.forName("Example");
	factory = (ExampleInterface)c.newInstance(); 

其中ExampleInterface是Example的接口，可以写成如下形式： 
	
	String className = "Example";
	Class c = Class.forName(className);
	factory = (ExampleInterface)c.newInstance();

进一步可以写成如下形式：
	
	String className = readfromXMlConfig;//从xml 配置文件中获得字符串
	Class c = Class.forName(className);
	factory = (ExampleInterface)c.newInstance();

上面代码已经不存在Example的类名称，它的优点是:无论Example类怎么变化，上述代码不变，甚至可以更换Example的兄弟类Example2…… 只要它们继承ExampleInterface就可以。

从JVM的角度看，使用关键字new创建一个对象的时候，这个类可以没有被加载。但是使用newInstance()方法的时候，就必须保证：1、这个类已经加载；2、这个类已经连接了。而完成上面两个步骤的正是Class的静态方法forName()所完成的，这个静态方法调用了启动类加载器。

其实newInstance()实际上是把new这个方式分解为两步：首先调用Class加载方法加载某个类，然后实例化。好处是可以在调用Class的静态加载方法forName时获得更好的灵活性，提供给了一种解耦的手段。

最后用最简单的描述来区分new关键字和newInstance()方法的区别：

* newInstance: 弱类型，低效率，只能调用无参构造。 
* new: 强类型，相对高效，能调用任何public构造。
