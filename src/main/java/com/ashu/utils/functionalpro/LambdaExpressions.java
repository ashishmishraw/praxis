package com.ashu.utils.functionalpro;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by ashishmishraw on 20/12/16.
 *
 * Lambdas also known as closures
 */
public class LambdaExpressions {


    public static void main(String[] args) {

        List<String> xlist = Arrays.asList( "b", "a", "d" );

        //notice the type of argument e is being inferred by the compiler.
        // We can provide the type of the parameter, wrapping the definition in brackets
        xlist.forEach( (String e) -> System.out.print( e ));

        System.out.println("");
        //Alternatively this can be done ..
        xlist.forEach(e -> System.out.print( e ) );

        System.out.println("");
        //.. which alternatively will work same if we pass method reference ..
        xlist.forEach(System.out::print);//.. this one


        //Traditional imperative anonymous function passing
        xlist.sort(new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.compareTo(b);
            }
        });

        //one liner lambda expression with method passing
        xlist.sort( (a,b) -> a.compareTo(b));

        //print sorted list
        System.out.print("\nSorted -> ");
        xlist.forEach(System.out::print);



    }
}
