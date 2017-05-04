package com.ashu.utils.functionalpro;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ashishmishraw@github.com on 28/12/16.
 *
 * Examples to demonstrate behavior parameterization use-cases
 *
 * Behavior Parameterization - ability for a method to take multiple different behaviors as
 parameters and use them internally
 */
public class ParameterizeBehaviors {


    public static void main(String[] args) {

        Apple a1 = new Apple(115, "red");
        Apple a2 = new Apple(176, "green");
        Apple a3 = new Apple(200, "greenish red");

        List<Apple> apples = new ArrayList<>();
        apples.add(a1); apples.add(a2);  apples.add(a3);

        //Method 1 - traditional method call to verbose classes having boilerplate code
        prettyPrintApple(apples, new AppleObjectPrinterImpl() );

        //Method 2 - Using Anonymous Lambdas; No need of more implementations like AppleObjectPrinterImpl
        prettyPrintApple(apples, (Apple a) -> {
            return "Apple having " + a.getColor() + " color weighing " + a.getWeight() + " gm";
        });

        //Another example of using lamdas with Comparator
        apples.sort( (x, y) -> {
            if ( x.getWeight() == y.getWeight() )  return 0;
            else if (x.getWeight()  > y.getWeight()) return 1;
            else return -1;
        } );

        apples.forEach( e  -> System.out.println(e.getWeight()));
    }



    public static void prettyPrintApple(List<Apple> apples, AppleObjectPrinter behavior ) {

        for (Apple a: apples) {
            String output = behavior.print(a);
            System.out.println( "" + output );
        }
    }


    /**
     * This class implementation is not required if java 8 lambdas are used
     */
    static class AppleObjectPrinterImpl implements AppleObjectPrinter {

        public String print(Apple a) {
            return "A " + a.getColor() + " apple weighing " + a.getWeight() + " gm";
        }
    }


    /**
     * Simple bean for test
     */
    static class Apple {

        int weight ;
        String color;

        Apple(int wt, String clr) {
            weight = wt;
            color = clr;
        }

        String getColor() {
            return color;
        }

        int getWeight() {
            return weight;
        }

    }


}
