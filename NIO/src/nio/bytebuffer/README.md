## 缓存器和通道 ##

如果想把一个字节数组写到文件中去，那么就应该使用 ByteBuffer.wrap() 方法把字节数组包装起来，然后用 getChannel()方法在 FileOutputStream 上打开一个通道，接着将来自于ByteBuffer 的数据写到 FileChannel 中。

ByteBuffer 是将数据移进移出通道的唯一方式，并且只能创建一个独立的基本类型缓冲器或者使用"as"方法从 ByteBuffer 中获得。也就是说，不能把基本类型的缓冲器转换成 ByteBuffer。然而，由于可以经由视图缓冲器将基本类型数据移进移出 ByteBuffer，所以这也就不是什么真正意义上的限制。
