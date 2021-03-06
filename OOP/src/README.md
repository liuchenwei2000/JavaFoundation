## 面向对象相关概念 ##

现实的对象有state和behavior，对应到代码就是类的fields和methods。

### 三大特征

* Encapsulation 封装
* Inheritance 继承
* Polymorphism 多态

### 封装的好处

* 1，只对客户端程序员暴露他们感兴趣的信息，而隐藏他们不需要的信息，从而减少了错误调用。
* 2，当修改类内部某些实现的时候，不需要担心对客户端程序员造成的影响。

### 多态

多态通过分离做什么和怎么做，从另一个角度将接口和实现分离开来。
多态不但能够改善代码的组织结构和可读性，还能够创建可扩展的程序，即无论项目最初创建时还是在需要添加新功能时都可以"生长"的程序。

### new操作符

* 1，调用对象的构造方法
* 2，为新对象分配内存，然后由构造函数初始化这个对象
* 3，返回一个对这个新对象的引用

### 类之间的关系

依赖(uses-a 关系)  聚合(has-a 关系)  继承(is-a 关系)

依赖：
如果一个类的方法操纵另一个类的对象，那就说一个类依赖于另一个类。应该尽可能地将相互依赖的类减至最少，也就是使类之间的耦合度最小。

聚合：
意味着一个类的对象包含另一个类的对象(作为它的属性)

组合(composition)
新的类可以由任意数量、任意类型的其它对象以任意可以实现新的类中想要的功能的方式所组成，使用现有的类合成新的类叫做组合。
如果组合是动态发生的，那就叫做聚合(aggregation)

继承：
根据已有的类构造一个新类，复用(继承)已有类的域和方法。
