## 对象序列化 ##

### 对象序列化产生背景

Java 的对象序列化将那些实现了 Serializable 接口的对象转换成一个字节序列，并能够在以后将这个字节序列完全恢复为原来的对象。
这一过程甚至可通过网络进行；这意味着序列化机制能自动弥补不同操作系统之间的差异。
也就是说，可以在运行 Windows 系统的计算机上创建一个对象，将其序列化，通过网络将它发送给一台运行 Unix 系统的计算机，然后在那里准确地重新组装。
而不必担心数据在不同机器上的表示会不同，也不必关心字节的顺序或者其他任何细节。

### 对象序列化的概念

对象的序列化可以实现"轻量级持久化"(lightweight persistence)。"持久化"意味着一个对象的生存周期并不取决于程序是否正在执行；它可以生存于程序的调用之外。
通过将一个序列化对象写入磁盘，然后在重新调用程序时恢复该对象，就能够实现持久化的效果。
之所以称其为"轻量级"，是因为不能用某种"persistent"(持久)关键字来简单地定义一个对象，并让系统自动维护其他细节问题(尽管将来有可能实现)。
相反，对象必须在程序中显式地序列化(serialize)和反序列化还原(deserialize)

### 对象序列化的用途

对象序列化的概念加入到语言中是为了支持两种主要特性：

* a，Java的"远程方法调用"(RMI，Remote Method Invocation)
它使存活于其他计算机上的对象使用起来就像是存活于本机上一样，当向远程对象发送消息时，需要通过对象序列化来传输参数和返回值。

* b，Java Beans
使用一个Bean 时，一般情况下是在设计阶段对它的状态信息进行配置，这种状态信息必须保存下来并在程序启动以后进行后期恢复，具体工作由对象序列化完成。

只要对象实现了 Serializable 接口(该接口仅是一个标记接口，不包括任何方法)，对象的序列化处理就会非常简单。