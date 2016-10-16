package com.ashu.utils.algo.sort;

import java.util.Arrays;

/**
 * Insertion sort implementation
 * Sorts at time of insertion, by taking each element next to start and comparing it with it
 * Maintains two set of arrays (one sorted, other unsorted) in each iteration
 * 
 * @author ashishmishraw@github.com
 *
 */
public class InsertionSortUtil {
	
	
	public static void main(String[] args) {
			
		int[] unsortedArray = {51, 2, 17, 57, 0, 99, 201, 37, 3, 801, 8 };
		
		System.out.println("Unsorted array is " + Arrays.toString(unsortedArray));
		System.out.println("sorted array is " + Arrays.toString( sort(unsortedArray, false) )  );
		
		int[] anotherArray = {51, 2, 17, 57, -1, 99, 201, 37, 3, 801, 8 };
		
		System.out.println("Calling  selection sort on " +  Arrays.toString(anotherArray));
		System.out.println("sorted array is " + Arrays.toString( sort(anotherArray, false)) );
	}	
	
	
	/**
	 * Insertion sort impl
	 * Complexity - O(N*N) - quadratic
	 * @param arr
	 * @param recursive - boolean flag 
	 * @return
	 */
	public static int[] sort(int[] arr, boolean recursive) {
		
		if (recursive) { //use recursion
			System.out.println("mode is recursive ? " + recursive);
			sortRecursively(arr,0);		
		} else { //using loop
			int candidate = 0;
			for (int i = 0; i< arr.length-1; i++) {
				if (arr[i] > arr[i+1]) {
					candidate = i+1;
					for (int j = 0; j<=i; j++) {
						if (arr[candidate] < arr[j]) {
							swap(candidate, j, arr);
						}
					}
				}
			}
		}
		return arr;
	}
	
	
	public static int[] sortRecursively(int[] arr, int cursor) {
		
		
		
		return arr;
	}
	
	
	/**
	 * Swaps values between the two given indices in the given array
	 * @param to
	 * @param from
	 * @param arr
	 * @return
	 */
	private static int[] swap(int to, int from, int[] arr) {
		
		int temp = arr[to];
		arr[to] = arr[from];
		arr[from] = temp;	
		
		return arr;
	}
}
