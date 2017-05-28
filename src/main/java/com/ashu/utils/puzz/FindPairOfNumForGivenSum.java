package com.ashu.utils.puzz;

import com.ashu.utils.algo.search.BinarySearchUtil;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Find (first) pair of numbers with a given sum in a list
 *
 *
 * Considerations :
 * 1. Should it work for negative integers?
 * 2. How big is the inputNumbers array? How often does this method gets called?
 * 3. What scenarios need to be tested? +ve numbers, negative numbers, positive sum, negative sum, etc.?
 * 4. What if the numbers are not sorted?
 * 5. What are the possible approaches to achieve this?
 *
 * Created by mishra.ashish@icloud.com
 */
public class FindPairOfNumForGivenSum {


    /**
     * Checks given list to find the pair of integer values which totals to the sum.
     * If found returns true, else returns false
     *
     * @param list - input array of Integers
     * @param sum - integer value of sum
     * @return boolean - true | false
     */
    public static boolean hasSum(int[] list, int sum) {

        boolean result =  hasSumQuadratic(list, sum);

        result =  hasSumSuperLinear(list, sum);

        result = hasSumLinearTime(list, sum);

        result = hasSumUsingTwoPointers(list, sum);

        return result;
    }

    //Approach 1 - basic dumb approach
    /**
     * Complexity is N*N - quadratic
     *
     * Pros - Works with non-sorted array; Works with -ve numbers
     * Cons - Not good for larger input list because of time complexity
     *
     * @param list
     * @param sum
     * @return
     */
    private static boolean hasSumQuadratic(int[] list, int sum) {

        for (int i=0; i < list.length; i ++ ) {
            for (int j = i+1; j < list.length; j++) {

                if ( list[i] +  list[j] == sum)
                    return true;
            }
        }
        return false;
    }


    //Approach 2 - Using Binary search
    /**
     * Complexity of binary search approach is O(logN) provided the arrays are sorted
     * Using Collections.sort() or quickSort the complexity will still be NlogN + logN = O(NlogN)
     * Pros -
     *
     * @param list
     * @param sum
     * @return
     */
    private static boolean hasSumSuperLinear(int[] list, int sum) {

        for (int i=0; i < list.length-1; i ++ ) {

            int[]x = Arrays.copyOfRange(list, i+1, list.length);
            int j = -1;

            if (x.length == 1 ) {
                return list[i] + x[0] == sum;
            }

            if (x.length > 1) {
                j = BinarySearchUtil.search(x, sum - list[i], true);
            }

            if ( j != -1 && (list[i] + x[j] == sum) ) {
                return true;
            }
        }
        return false;
    }


    //Approach 3 -  Using HashSet approach
    /**
     * Using another collection, searching could be reduced to linear time
     *
     * Pros - Efficient because of O(N) complexity
     * Cons: Require additional memory / space
     *
     * @param list
     * @param sum
     * @return
     */
    private static boolean hasSumLinearTime(int[] list, int sum) {

        Set<Integer> cache = new HashSet<>(list.length);

        for (int i=0; i < list.length; i ++ ) {

            int reqNumber = sum - list[i];

            if (cache.contains(list[i]))
                return true;
            else
                cache.add(reqNumber);
        }

        return false;
    }



    //Approach 4 - two pointer approach

    /**
     * Most efficient approach - O(N-1) complexity
     *
     * Pros - Most efficient time complexity
     * Cons - Collection/list must be sorted; else  will not work. Sorting may add up NlogN
     *
     * @param list
     * @param sum
     * @return
     */
    private static boolean hasSumUsingTwoPointers(int[] list, int sum) {

        int i = 0;
        int j = list.length-1;

        //Collections.sort(Arrays.asList(list), null);

        while (i < j) {

            if (list[i] + list[j] == sum)
                return true;

            if (list[i] + list[j] < sum)
                i++;

            if (list[i] + list[j] > sum) {
                j--;
            }
        }

        return false;
    }



    public static void main(String[] args) {

        System.out.println(hasSum(new int[ ]{3,5,8,9},8));
        System.out.println(hasSum(new int[ ]{3,5,8,9},7));
        System.out.println(hasSum(new int[ ]{3,5,8,9,8,9,7,8,9},3));
        System.out.println(hasSum(new int[ ]{9,8,5,3},8));
        System.out.println(hasSum(new int[ ]{9,8,-5,3},4));
        System.out.println(hasSum(new int[ ]{9,8,-5,-3},-8));
        System.out.println(hasSum(new int[ ]{9,8,-5,-3},5));

    }

}
