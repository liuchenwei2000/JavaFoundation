package jdk8.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * 4，内部迭代示例
 * <p>
 *     以前 Java 集合是不能够表达内部迭代的，而只提供了一种外部迭代的方式，也就是 for 或者 while 循环。
 *     外部迭代模式下，循环是固定的顺序循环。在现在多核的时代，如果想并行循环，不得不修改既有代码。
 *     效率能有多大提升还说不定，且会带来一定的风险（线程安全问题等）。
 * <p>
 * Created by liuchenwei on 2017/9/26.
 */
public class InnerIteration {

    private static String[] languages = {"Java", "C++", "Python", "C#"};

    /**
     * 外部迭代示例
     */
    private static void outerIteration() {
        List<String> strings = Arrays.asList(languages);
        for (String string : strings) {
            System.out.println(string.toUpperCase());
        }
    }

    /**
     * 内部迭代示例
     * <p>
     * 内部迭代是由 JDK 库来控制循环，库可以根据运行环境来决定怎么做，并行、乱序或者懒加载方式。
     * 这就是内部迭代，客户端将行为 System.out.println(s.toUpperCase()) 当做参数传给了 JDK API。
     */
    private static void innerIteration() {
        List<String> strings = Arrays.asList(languages);
        strings.forEach(s -> System.out.println(s.toUpperCase()));
    }

    public static void main(String[] args) {
        InnerIteration.outerIteration();
        InnerIteration.innerIteration();
    }
}
