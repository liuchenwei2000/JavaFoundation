## 文件新 API ##

Java7中对文件管理提供了大量的新API，这些新的接口可以使我们操纵文件以及文件夹更加方便。
它们大多位于java.nio.file包下。 

* java.nio.file.Paths
包含了用于创建Path对象的静态方法。

* java.nio.file.Path 
包含了大量用于操纵文件路径的方法。

* java.nio.file.FileSystems 
用于访问文件系统的类。

* java.nio.file.FileSystem 
代表了一种文件系统，例如Unix下的根目录为 / ，而Windows下则为C盘。

* java.nio.file.FileStore 
代表了真正的存储设备（如硬盘），提供了设备的详尽信息。

* java.nio.file.attribute.FileStoreAttributeView 
提供了访问文件的信息。
