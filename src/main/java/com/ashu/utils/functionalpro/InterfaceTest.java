package com.ashu.utils.functionalpro;

/**
 * Created by ashishmishraw on 20/12/16.
 */
public class InterfaceTest {

    public static void main(String args[]) {

        MyInterface impl1 = new OneImpl();

        MyInterface impl2 = new NoImpl();

        System.out.println("Interface test with default methods: ");
        impl1.myTest();
        impl2.myTest();


        System.out.println("Interface test with implemented methods: ");
        impl1.test();
        impl2.test();

    }

}
