package com.ashu.utils.functionalpro;

/**
    The functional interface is an interface with just one single method
    As such, it may be implicitly converted to a lambda expression. The java.lang.Runnable
    and java.util.concurrent.Callable are two great examples of functional interfaces

     @author ashishmishraw
*/

@FunctionalInterface
public interface MyInterface {

    default String myTest() {
        System.out.println("Default implementation in interface ..");
        return "x";
    }

    public void test();
}


class OneImpl implements MyInterface {

    public void test() {
        System.out.println("One implementation ..");
    }

    public String myTest() {
        System.out.println("Default implemented by OneImpl class ..");
        return "y";
    }
}


class NoImpl implements MyInterface {

    public void test() {
        System.out.println("Another implementation ..");
    }

    //No implementation of Default
}
