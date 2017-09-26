## nio ##

JDK1.4 的 java.nio.* 包中引入了 Java 新的I/O类库，其目的在于提高速度。
实际上，旧的 I/O 包已经使用 nio 重新实现过，以便充分利用这种速度提高。因此，即使我们不显式地用 nio 编写代码，也能从中受益。

速度的提高来自于所使用的结构更接近于操作系统执行I/O的方式：通道和缓冲器。
我们可以把它想象成一个煤矿：通道是一个包含煤层（数据）的矿藏，而缓冲器则是派送到矿藏的卡车。卡车载满煤炭而归，我们再从卡车上获得煤炭。
也就是说，我们并没有直接和通道交互而只是和缓冲器交互，并把缓冲器派送到通道。通道要么从缓冲器获得数据，要么向缓冲器发送数据。
 
唯一直接与通道交互的缓冲器是 ByteBuffer————也就是说，可以存储未加工字节的缓冲器用于以原始的字节形式或基本数据类型输出和读取数据。
但是，没办法输出或读取对象，即使是字符串对象也不行。这种处理虽然是低水平但却正好，因为这是大多数操作系统中更有效的映射方式。