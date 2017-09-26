package jdk8.lambda;

/**
 * 2，方法引用示例
 * <p>
 *     方法引用其实是 Lambda 表达式的一个简化写法，所引用的方法其实是 Lambda 表达式的方法体实现。
 *     语法很简单，左边是容器（可以是类名、实例名），中间是"::"，右边是相应的方法名。如下所示：
 *
 *     ObjectReference::methodName
 *
 *     一般方法的引用格式是：
 *     如果是静态方法，则是ClassName::methodName。如 Object::equals
 *     如果是实例方法，则是Instance::methodName。如 Object obj=new Object(); obj::equals;
 *     构造函数，则是 ClassName::new
 * <p>
 * Created by liuchenwei on 2017/9/26.
 */
public class MethodReferenceTest {

    /**
     * 这里是函数式接口 Runnable 的实现方法
     */
    private static void doSomething() {
        System.out.println("这里是方法引用实现方式");
    }

    public static void main(String[] args) {
        // 使用方法引用方式，如果 Lambda 的方法体很长，影响可读性，可以使用方法引用。
        new Thread(MethodReferenceTest::doSomething).start();
    }
}
