package com.ashu.utils.puzz;

/**
 * Created by mishra.ashish@icloud.com
 */
public class FindDup {

    static int[] listOfNumbers = {1,2,3,4,5,5,6};

    /**
     * Comlexity - O(NxN)
     * @param array
     * @return
     */
    public static int findFirstDupNotSoEfficient( int[] array ) {

        for (int i = 0; i <= array.length - 1; i++) {
            if (  contains( array, i+1 )) {
                return array[i+1];
            }
        }
        return -1;
    }

    private static boolean contains(int[] array, int index) {

        for ( int x = 0; x < index; x++) {
            if ( array[x] == array[index] ) {
                return true;
            }
        }
        return false;
    }

    /**
     * Complexity - O(NlogN)
     * @param array
     * @return
     */
    public static int findFirstDupWithLogNTime( int[] array, int start, int end) {

        int mid = (start + end) / 2;
        if ( array.length > 1 && array[start] == array[mid] )
            return array[mid];

        if (array[start] > array[mid] )
            return findFirstDupWithLogNTime(array, mid + 1, end);
        else
            return findFirstDupWithLogNTime(array, start, mid -1);

    }

    /**
     * Compexity O(N)
     * @param array
     * @return
     */
    public static int findFirstDupBeastMode(int [] array) {


        for (int i = 0; i <= array.length - 1; i++) {
            swap(array, i);

        }

        return -1;
    }

    private static void swap(int[] array, int i) {

        int tmp = array[i] ;
        array[i] = array[tmp-1];
        array[tmp-1] = tmp;
    }


    public static void main(String[] args) {

        System.out.println(findFirstDupNotSoEfficient(listOfNumbers));

        System.out.println(findFirstDupWithLogNTime(listOfNumbers, 0, listOfNumbers.length-1));

    }


}
