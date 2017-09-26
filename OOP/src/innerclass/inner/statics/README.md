## 静态内部类概述 ##

静态内部类的名字和访问性由外部类决定，剩下的特性和一般的类（接口）是一样的。
访问控制符可以用于修饰静态内部类（接口），但是在接口中的静态内部类（接口）只能是public的。

静态内部类可以继承任何其他类，包括它的外部类，也可以实现任何接口，也可以被能访问它的类继承
（但是不能继承到它能访问其外部类的特权），可以声明为abstract或者final，特性和一般的类是一样的。

嵌套接口因为不用像嵌套类那样关心实现问题所以一般都是static的，声明在接口中的内部类自动是 public static 修饰的。

静态内部类和非静态内部类的区别
                   
* 1，非静态内部类对象有着指向其外部类对象的引用，它从属于创建它的外部类的对象；而静态内部类对象没有这个引用，相当于外部类的一个静态成员，并且类内只能操纵静态成员。
* 2，在任何非静态内部类中，都不能有静态数据，静态方法或者又一个静态内部类；不过静态内部类中却可以。