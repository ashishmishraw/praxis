package com.ashu.utils.algo.sort;

import java.util.Arrays;

/**
 * SelectioSort algorithm implementation
 * @author ashismishraw@github.com
 *
 */
public class SelectionSortUtil {
	
	
	public static void main(String[] args) {
		
		int[] unsortedArray = {51, 2, 17, 57, 0, 99, 201, 37, 3, 801, 8 };
		
		System.out.println("Unsorted array is " + Arrays.toString(unsortedArray));
		
		System.out.println("sorted array is " + Arrays.toString( sort(unsortedArray, false) )  );
		
		int[] anotherArray = {51, 2, 17, 57, -1, 99, 201, 37, 3, 801, 8 };
		
		System.out.println("Calling recursive selection sort on " +  Arrays.toString(anotherArray));
		System.out.println("sorted array is " + Arrays.toString( sort(anotherArray, true)) );
		
	}
	
	
	/**
	 * Complexity - O(N*N)
	 * @param arr
	 * @param recursive
	 * @return
	 */
	public static int[] sort(int[] arr, boolean recursive) {
		
		if (recursive) { //use recursion
			System.out.println("mode is recursive ? " + recursive);
			sortRecursively(arr,0);
		} else { //use looping 
					
			for (int cursor = 0; cursor< arr.length; cursor ++) {
				
				int pivot = cursor+1;
				int min = cursor;
				
				while (pivot < arr.length) { //find min
					if (arr[min] > arr[pivot]) {
						min = pivot;
					}
					pivot++;
				}
				
				arr = swap(min, cursor, arr); //swap min with element in cursor position		
			}
		}	
		return arr;
	}
	
	
	/**
	 * Sorts using selectionSort algo recursively
	 * @param arr
	 * @param cursor
	 * @return
	 */
	public static int[] sortRecursively(int[] arr, int cursor) {
		
		if ( cursor>= arr.length) {
			return arr;
		} else {
			int pivot = cursor+1;
			int min = cursor;
			
			while (pivot < arr.length) { //find min
				if (arr[min] > arr[pivot]) {
					min = pivot;
				}
				pivot++;
			}
			
			arr = swap(min, cursor, arr); //swap min with element in cursor position
			
			return sortRecursively(arr, cursor+1); //next iteration
		}
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
