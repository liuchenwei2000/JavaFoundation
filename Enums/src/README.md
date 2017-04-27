## 枚举 ##

新关键字enum，可以这样来定义一个枚举类型：
    
    public　enum　Color
    {
    　　　RED，
    　　　WHITE，
    　　　BLUE
    }

它里面的每一个元素都是 static 常量，都应该大写。然后可以这样来使用：
    
    Color　myColor　=　Color.RED;
    

因为 enum 继承自java.lang.Enum 所以不可再继承其他类。编译器会自动提供equals()和hashCode()方法，并且实现了Complarable和Serializable接口。

一个enum是定义一组值的对象，它可以包括零个或多个值成员。它是属于enum类型的，一个enum对象中不可有两个或多个相同的属性或值。
enum对象的值都会自动获得一个数字值，从0开始，依次递增。

枚举类型还提供了有用的静态方法values()可以很方便地使用它们，例如
    
    for　(Color　c　:　Color.values())
    {
        System.out.println(c);
    }


静态方法values()返回这个枚举所等同的数组，并且数组中的元素严格保持其在enum中声明的顺序。

一条普遍规则是，任何使用常量的地方，例如目前用 switch 代码切换常量的地方。
如果只有单独一个值(例如，鞋的最大尺寸，或者笼子中能装猴子的最大数目)，则还是把这个任务留给常量。
但是，如果定义了一组值，而这些值中的任何一个都可以用于特定的数据类型，那么将枚举用在这个地方最适合不过。
