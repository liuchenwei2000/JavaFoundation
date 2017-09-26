package jdk8.lambda;

/**
 * 3，默认方法
 * <p>
 *     简单说，就是接口可以有实现方法，而且不需要实现类去实现该方法。
 *     只需在接口类中的方法名前面加个 default 关键字即可。
 * <p>
 *     为什么要有这个特性？当需要修改接口时候，需要修改全部实现该接口的类，
 *     然而对于已经发布的版本，是没法在给接口添加新方法的同时不影响已有的实现。
 *     所以引入默认方法的目的是为了解决接口的修改与现有的实现不兼容的问题。
 * <p>
 * Created by liuchenwei on 2017/9/26.
 */
public class DefaultMethodTest {

    interface A {

        /**
         * 这是个默认方法
         */
        default void foo(){
            System.out.println("Calling A.foo()");
        }
    }

    /**
     * A1 没有实现接口中的 foo 方法
     */
    static class A1 implements A {
    }

    /**
     * A2 实现了接口中的 foo 方法
     */
    static class A2 implements A {

        public void foo(){
            System.out.println("Calling A2.foo()");
        }
    }

    public static void main(String[] args){
        A a1 = new A1();
        a1.foo();

        A a2 = new A2();
        a2.foo();
    }
}
