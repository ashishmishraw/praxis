package com.ashu.utils.puzz;

/**
 * Created by mishra.ashish@icloud.com
 */
public class FibonnacciUtil {


    public static void main(String[] args) {
        System.out.println(getNthFibonnacciElement(5));
    }

    public static int getNthFibonnacciElement(int n) {

        int []series =  generateFibonnacciSeries(n);
        for (int i = series.length - 1; i >= 0; i--) {
            System.out.println(i);
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




}


