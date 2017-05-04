package com.ashu.utils.collections;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by mishra.ashish@icloud.com
 */
public class HashSetSize {

    static class A {

        public A(int a) {
            this.a = a;
        }

        private int a = 2;

        @Override
        public int hashCode() {
            return a;
        }
    }


    public static void main(String[] args) {

        Set<A> set = new HashSet<>(3);

        set.add(new A(2));
        set.add(new A(2));
        set.add(new A(2));

        System.out.println("Size of set is: " + set.size());
    }

}
