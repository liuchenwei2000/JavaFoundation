## 流 ##

I/O 类库中常使用"流"这个抽象概念，它代表任何有能力产生数据的数据源对象或者是有能力接收数据的接收端对象，"流"屏蔽了实际的 I/O 设备中处理数据的细节。很少使用单一的类来创建流对象，而是通过组合多个对象来提供所期望的功能。Java 中的"流"类库让人迷惑的主要原因就在于：创建单一的结果流却需要创建多个对象。

Java 中有两种类型的流：**字节流**(byte stream)和**字符流**(character stream)。字节流为处理字节的输入输出提供了方便的方法，例如读取或者书写二进制数据；字符流为字符的输入和输出处理提供了方便，在最底层，所有的输入输出都是字节形式的。字节流相关类的后缀都是 Stream，字符流相关类的后缀都是  Reader/Writer。

### 字节流

I/O 类库基类是 InputStream 和 OutputStream，可以读取字节序列的对象被称为输入流(input stream)，可以写入字节序列的对象被称为输出流(output stream)。

**InputStream** 的作用是用来表示那些从不同数据源产生输入的类，这些数据源包括：

* 1，字节数组(ByteArrayInputStream)
* 2，String 对象(StringBufferInputStream)
* 3，文件(FileInputStream)
* 4，管道、由其他种类的流组成的序列、其他数据源如互联网

**OutputStream** 决定了输出所要去往的目标：

* 1，字节数组(ByteArrayOutputStream)
* 2，文件(FileOutputStream)

### 字符流

由于以字节为单位流处理存储为 Unicode 码（Unicode 的每个代码单元占用两个字节）的信息很不方便，所以有一个专门的类层次来处理 Unicode 字符。
Reader 和 Writer 提供兼容 Unicode 与面向字符的 I/O 功能，这些类继承于 Reader 和 Writer。它们的读写操作都是基于双字节的 Unicode 代码单元，而不是单字节。

几乎所有原始的 I/O "流"类都有相应的 Reader 和 Writer 类来提供天然的 Unicode 操作，然而在某些场合面向字节的 InputStreams 和 OutputStream 才是正确的解决方案。特别是 java.util.zip 类库就是面向字节的而不是面向字符的。因此，最明智的做法是尽量尝试使用 Reader 和  Writer，一旦程序代码无法成功编译就会发现不得不使用面向字节的类库。

### 注意事项

使用 IO 流的注意事项：当完成了对一个流的读取或者写入后，就应该调用 close 方法将它关闭，这样就可以释放流所占用的操作系统资源。关闭一个输出流也可以刷新(flush)输出流占用的缓存区，即临时存储在缓冲区中等待形成较大的数据包后再发送的那些字符，此时将它们发送出去。如果不关闭文件，最后一个字节包可能永远也不会被发送，当然可以用 flush 方法手工刷新输出。

### 过滤流

在 Java 中，一些流可以从文件以及其他地方接收字节，另一些流可以将字节组合成更加有用的数据类型。Java 采用将一个已经存在的流传递给另一个流的构造器方法，将这两种流结合起来，结合后的流被称为过滤流(filtered stream)。

例如，为了能够从文件中读取数值，首先创建一个 FileInputStream，然后将它传递给一个 DataInputStream 的构造器：
	
	FileInputStream fin = new FileInputStream("file");
	DataInputStream din = new DataInputStream(fin);
	double d = din.readDouble();

利用上面的代码建立的数据输入流并没有与一个新的磁盘文件对应，新创建的流依然通过访问与文件输入流相联系的文件获取数据，但是现在可以使用一种功能更多的接口。

### 缓冲流

缓冲输入流从内存缓冲区读取数据，只有当缓冲为空时才调用 OS 本地的输入流从数据源读取数据。缓冲输出流将数据从数据源输出到内存缓冲区，只有当缓冲区满的时候才调用 OS 本地的输出流输出到目的地。因为每次调用 OS 本地的输入输出流代价是昂贵的，并且频繁调用对程序而言是低效的，因此当每次向流读写时，不必每次都进行实际的物理读写动作，所以在进行读写时更经常用到缓冲流。可以使用缓冲流包装类将非缓冲流转换成缓冲流，其中 BufferedInputStream 和 BufferedOutputStream 可以缓冲字节流，BufferedReader 和 BufferedWriter 可以缓冲字符流。