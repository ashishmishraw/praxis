package com.ashu.utils.algo.sort;

import java.util.Arrays;

/**
 * My impl of quickSort Algo
 * 
 * Quick Sort has similar complexity of O(nlogn) like Merge sort but it provides
 * an edge over mergesort 
 * 
 *  It does not involve tedious copying of arrays during merge process
 *  It saved space compared to merge-sort	
 * 
 * Quick Sort has two major drawbacks when it comes to merge sort:

	1. It's not stable while it comes to non primitive.
    2. It doesn't guarantee n log n performance.
    
    
    
 * @author http://github.com/ashismishraw
 *
 */
public class QuickSort {
	
	public static void main(String[] args) {
		
		int[] unsortedArray = {51, 2, 17, 57, 0, 99, 201, 37, 3, 801, 8 };
		
		System.out.println("Unsorted array is " + Arrays.toString(unsortedArray));
		sort(unsortedArray, 0, unsortedArray.length-1);
		System.out.println("sorted array is " + Arrays.toString(unsortedArray)  );
		
		
		unsortedArray = new int[] {15, -1, 7, 2, 0, 69, 54, 371, 43, 26, 9 };
		
		System.out.println("another un-sorted array is " + Arrays.toString(unsortedArray));
		sort(unsortedArray, 0, unsortedArray.length-1);
		System.out.println("sorted array is " + Arrays.toString(unsortedArray)  );
		
		
	}
	
	
	/**
	 * Quick sort -complexity O(NlogN) best case
	 * Worst case could go to O(N^2)
	 * 
	 * @param arr
	 * @param p
	 * @param r
	 */
	public static void sort(int[] arr, int p, int r) {
		
		if (p<r) {	// condition iterated logN times
			int q = partition(arr, p, r); // O(N)
			sort(arr, p, q-1); 
			sort(arr, q+1, r); 
		}
	}
	
	
	/**
	 * Partition logic is the core of quick-sort
	 * It finds the index of a mid element (based on pivot), left of which are 
	 * all elements lesser-than it AND right of which are all elements greater-than it
	 * @param arr
	 * @param start
	 * @param end
	 * @return index of mid element
	 */
	public static int partition(int[] arr, int start, int end) {
		
		int j = start;
		int i = j-1;
		int pivot = arr[end];
		
		while ( j <= end) {
			if (arr[j] <= pivot) {
				
				i = i+1; //advance i
				
				//swap elements on i and j
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			} 
			j = j+1;
		}
		
		return i;
	}
	
	

}
