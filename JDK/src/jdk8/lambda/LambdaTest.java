package jdk8.lambda;

/**
 * 1，Lambda 示例
 * <p>
 *     函数式接口（functional interface），简单来说，函数式接口是只包含一个方法的接口。
 *     比如 Java 标准库中的 java.lang.Runnable 和 java.util.Comparator 都是典型的函数式接口。
 *     Java8 提供 @FunctionalInterface 作为注解，这个注解是非必须的，只要接口符合函数式接口的标准（即只包含一个方法的接口），
 *     虚拟机会自动判断，但最好在接口上使用 @FunctionalInterface 进行声明，以免其他人员错误地往接口中添加新的方法。
 *     Java 中的 Lambda 无法单独出现，它需要一个函数式接口来盛放，Lambda 表达式方法体其实就是函数接口的实现，
 * <p>
 *     Lambda 语法包含三个部分：
 *     <li>一个括号内用逗号分隔的形式参数，参数是函数式接口里面方法的参数；
 *     <li>一个箭头符号：-> ；
 *     <li>方法体，可以是表达式和代码块，方法体是函数式接口里面方法的实现，
 *     如果是代码块，则必须用 {} 来包裹起来，且需要一个 return 返回值，若函数式接口里面方法返回值是 void，则无需 return。
 * <p>
 *     总体看起来像这样
 *     (parameters) -> expression 或者 (parameters) -> { statements; }
 * <p>
 * Created by liuchenwei on 2017/9/26.
 */
public class LambdaTest {

    /**
     * Java8 之前的方式
     */
    private static void runThreadUseInnerClass() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("内部类实现的线程");
            }
        }).start();
    }

    /**
     * Java8 Lambda 的方式
     */
    private static void runThreadUseLambda() {
        // Runnable 是一个函数接口，只包含一个无参数的返回 void 的 run 方法；
        // 所以 Lambda 表达式左边没有参数，右边也没有 return
        new Thread(() -> System.out.println("lambda 实现的线程")).start();
    }

    public static void main(String[] args) {
        LambdaTest.runThreadUseLambda();
        LambdaTest.runThreadUseInnerClass();
    }
}
