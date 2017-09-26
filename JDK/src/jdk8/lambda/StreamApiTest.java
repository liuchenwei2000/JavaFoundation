package jdk8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 5，Stream API 示例
 * <p>
 *     流（Stream）仅仅代表着数据流，并没有数据结构，所以它遍历完一次之后便再也无法遍历。
 *     这点在编程时候需要注意，不像 Collection 遍历多少次里面都还有数据，它的来源可以是 Collection、数组、IO 等。
 * <p>
 *     流作用是提供了一种操作数据的接口，让数据操作更容易和更快。
 *     它具有过滤、映射以及减少遍历数等方法，这些方法分两种：中间方法和终点方法。
 *     Stream 天生就该是持续的，中间方法永远返回的是 Stream，
 *     因此如果要获取最终结果的话，必须使用终点操作才能收集流产生的最终结果。
 *     区分这两类方法是看其返回值，如果是 Stream 则是中间方法，否则是终点方法。
 * <p>
 * Created by liuchenwei on 2017/9/26.
 */
public class StreamApiTest {

    private static String[] languages = {"Java", "C++", "Python", "C#", "VB", "SQL"};

    /**
     * Stream 的基本操作
     */
    private static void stream(){
        List<String> strings = Arrays.asList(languages);
        // Stream 的 filter 方法可以接受表示操作的 Predicate 实现来使用定义了过滤条件的 Lambda 表达式
        long count = strings.stream().filter(s -> s.length()>=4)// 过滤长度在 4 以下的字符串
        // map 方法允许执行一个 Function 的实现，它接受入参并返回转换后的对象
        .map(str -> new Language(str.toUpperCase()))// 将字符串转换成 Language 对象
        // count 方法是一个流的终点方法，可对流的结果进行统计，返回 long
        .count();

        List<Language> result = strings.stream().filter(s -> s.length() >= 4)
                .map(str -> new Language(str.toUpperCase()))
                // collect 方法也是一个流的终点方法，可收集最终的结果
                .collect(Collectors.toList());

        System.out.println(result);
    }

    /**
     * 顺序流与并行流
     */
    private static void stream2(){
        List<String> strings = Arrays.asList(languages);
        // 使用顺序方式去遍历时，每个元素读完后再读下一个元素。
        List<String> list1 = strings.stream().collect(Collectors.toList());
        System.out.println(list1);
        // 使用并行去遍历时，数组会被分成多个段，其中每一个都在不同的线程中处理，然后将结果一起输出。
        // 与 MapReduce 不同，Stream 是利用多核技术将大数据通过多核并行处理，而 MapReduce 则是分布式的
        // 如果是多核机器，理论上并行流则会比顺序流快上一倍
        List<String> list2 = strings.parallelStream().collect(Collectors.toList());
        System.out.println(list2);
    }

    /**
     * 如果没有 Lambda 表达式，则 Stream 用起来相当别扭，它会产生大量的匿名内部类。
     * 如果没有 default method，集合框架更改势必会引起大量的改动，所以 Lambda + default method
     * 使得 JDK 库更加强大、灵活，Stream 以及集合框架的改进便是最好的证明。
     */
    public static void main(String[] args) {
        stream();
        stream2();
    }

    private static class Language {

        private String name;

        public Language(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Language{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
