package com.ashu.utils.puzz;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by mishra.ashish@icloud.com
 */
public class FibonnacciUtil {


    public FibonnacciUtil(){
    }

    public static void main(String[] args) {

        //System.out.println(getNthFibonnacciElement(4));
       // int []series =  generateFibonnacciSeries(8);
       // for (int i = 0; i < series.length ; i++) {
           // System.out.print(series[i] + " ");
       // }
        System.out.println(fibonacci(7));
        //normal recursive fibonacci implementation
        //int nThfibonacciNo = new FibonnacciUtil().fibonacci(4);
        //System.out.println(nThfibonacciNo);

        //improvement using cache
       // nThfibonacciNo =  new FibonnacciUtil().fibonacciWithCache(10);
        //System.out.println(nThfibonacciNo);


        //improvement with java 8
       // nThfibonacciNo = new FibonnacciUtil().fibonacci(5);
       // System.out.println(nThfibonacciNo);

    }


    public static int getNthFibonnacciElement(int n) {

        int []series =  generateFibonnacciSeries(n);
        for (int i = 0; i < series.length ; i++) {
            System.out.print(series[i] + " ");
        }
        return series[n-1];
    }

    private static int[] generateFibonnacciSeries(int n) {

        int[] feb = new int[n];
        feb[0] = 0;
        feb[1] = 1;
        for(int i=2; i < n; i++){
            feb[i] = feb[i-1] + feb[i-2];
        }
        return feb;
    }


    //Complimenting Fibonacci number coding – iterative and recursive approach, we can improve performance by caching. If you run this
    //public class RecursiveFibonacci {

    public static int fibonacci(int n) {
        if (n == 0 || n == 1)
            return n;

        //System.out.println("evaluating fibonacci(" + n + ")");
        return fibonacci(n - 2) + fibonacci(n - 1);
    }


/**
    Output
    evaluating fibonacci(5)
    evaluating fibonacci(3)
    evaluating fibonacci(2)
    evaluating fibonacci(4)
    evaluating fibonacci(2)
    evaluating fibonacci(3)
    evaluating fibonacci(2)
//    and you can see “fibonacci(3)” is repeated 2 times,“fibonacci(2)” is repeated 3 times, and so on.
// If you pick a larger number like 21, there will be many repeats.
// Let’s use cache to store evaluated values to improve performance.
*/
    //public class RecursiveFibWithCache {

    private Map<Integer, Integer> cache = new ConcurrentHashMap<>(20);

    public int fibonacciWithCache(int n) {
        if (n == 0 || n == 1)
            return n;

        Integer result = cache.get(n);

        if (result == null) {
            synchronized (cache) {
                result = cache.get(n);

                if (result == null) {
                    System.out.println("evaluating fibonacci(" + n + ")");
                    result = fibonacci(n - 2) + fibonacci(n - 1);
                    cache.put(n, result);
                }
            }
        }

        return result;

    }

/**
    Output

    evaluating fibonacci(5)
    evaluating fibonacci(3)
    evaluating fibonacci(2)
    evaluating fibonacci(4)

    //Now, no repetitions.
    // Can we further improve on this?
    // If we use Java 8, we can make use of the ConcurrentHashMap.computeIfAbsent(..) addition.
*/

    public int fibonacciUsingJava8(int n) {
        if (n == 0 || n == 1)
            return n;
/*
        return cache.computeIfAbsent(n, (key) -> {
            System.out.println("evaluating fib(" + n + ")");
            return fibonacci(n - 2) + fibonacci(n - 1);
        });
*/
        //If you remove the print statement, it becomes even simpler
        return cache.computeIfAbsent(n, (key) -> fibonacci(n - 2) + fibonacci(n - 1));
    }



    /**
     * Super efficient fibonacci
     */
    public int fib(int n) {

        // edge cases:
        if (n < 0) {
            throw new IllegalArgumentException("Index was negative. No such thing as a negative index in a series.");
        } else if (n == 0 || n == 1) {
            return n;
        }

        // we'll be building the fibonacci series from the bottom up
        // so we'll need to track the previous 2 numbers at each step
        int prevPrev = 0;   // 0th fibonacci
        int prev = 1;       // 1st fibonacci
        int current = 0;    // Declare and initialize current

        for (int i = 1; i < n; i++) {

            // Iteration 1: current = 2nd fibonacci
            // Iteration 2: current = 3rd fibonacci
            // Iteration 3: current = 4th fibonacci
            // To get nth fibonacci ... do n-1 iterations.
            current = prev + prevPrev;
            prevPrev = prev;
            prev = current;
        }

        return current;
    }

}


