package com.ashu.utils.puzz;

import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Fibonacci fun
 A Fibonacci like sequence satisfies the following recurrence relation: F(N) = F(N-2) + F(N-1), N >= 2.

 It is easy to see that if you specify explicitly the values of F(a) and F(b) where a and b are two indices,
 the whole sequence is defined.
 Your task is very simple. Given two non-negative integers a and b, the values of F(a) and F(b),
 and two non-negative integers M and N, compute the sum (F(N) + F(N+1) + … + F(M)) mod 1000000007.

 Note: You may assume that the given Fibonacci-like sequence has all integer values.

 Constraints
 1 <= T <= 1000
 0 <= N <= M <= 50
 0<=a<=50 0<=b<=50; a != b
 -32767 <= F(a) <= 32768
 -32767 <= F(b) <= 32768

 Input Format:
 The first line contains an integer T (the number of test cases). Then, T lines follow with the input as follows:
 a b F(a) F(b) N M

 Output Format:
 For each test case you have to output a single line containing the answer for the task.


 Sample Input:

 3
 0 1 0 1 0 3
 2 8 1 21 3 5
 3 7 2 13 10 19
 Sample Output:

 4
 10
 10857
 */

class FibonacciFun {

    private static int a, b = 0;
    private static int m, n = 0;


    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(System.in);

            String tests = scanner.nextLine();
            int t = Integer.parseInt(tests);

            if (t <= 0) {
                System.err.println("Invalid input - no. of tests");
                System.exit(200);
            }

            int i = 1;

            while (i <= t) {
                String inputs = scanner.nextLine();

                //System.out.println("input: " + inputs);
                String[] inputArray = inputs.split("\\s+");
                a = Integer.parseInt(inputArray[0]);
                b = Integer.parseInt(inputArray[1]);
                n = Integer.parseInt(inputArray[4]);
                m = Integer.parseInt(inputArray[5]);

                System.out.println(fibonacciSum(n, m));
                i++;
            }
        } catch( NumberFormatException nfex) {
            nfex.printStackTrace();
            System.out.println("Invalid input ");
        }
    }


    private static int fibonacciSum(int n , int m) {

        Map<Integer, Integer> cache = new ConcurrentHashMap<>();

        int fibN = 0;//fibonacci(n);
        while (n <= m) {
            fibN = fibN + fibonacci(cache, n);
            n++;
        }
        return fibN % 1000000007;
    }


    private static int fibonacci(Map<Integer, Integer> cache, int n) {

        if (n == 0 || n == 1)
            return n;

        Integer result = cache.get(n);

        if (result == null) {
            result = fibonacci(cache, n - 2) + fibonacci(cache, n - 1);
            cache.put(n, result);
        }
        return result;
    }
}
