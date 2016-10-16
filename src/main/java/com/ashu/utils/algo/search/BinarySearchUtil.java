package com.ashu.utils.algo.search;

/**
 * Simple binary serach implementation utility
 * @author ashismishraw
 *
 */
public class BinarySearchUtil {
	
	/**
	 * 
	 * @param array - array holding a list of elements 
	 * @param elem - element to be searched
	 * @param recursive - boolean flag sygnifies whether to search recursively or not
	 * @return index at which element is found at within the given array
	 */
	public static int search (int[] array, int elem, boolean recursive) {
		
		int start = 0;
		int end = array.length -1;
		int mid = 0;
		int result = -1;
		
		if (!recursive) {
			
			while (start <= end) { // important! common mistake : do not use "while (true) " !!
				System.out.println("Looking for " + elem + " between position " + start + " and " + end + " .... ");
				mid = (start + end)/2;
				if (elem == array[mid]) {
					result = mid;
					//break;  --> used this earlier with while (true) but common mistake 
					        //--> this will keep finding a non-existing element infinitely in loop
				}
				if (elem > array[mid]) {
					start = mid+1;
				} else {
					end = mid -1;
				}
			}
			return result;
		} else {
			result = searchRecursively(array, 0, array.length-1 , elem );
			return result;
		}
	}
	
	
	/**
	 * Recursive implementation
	 * @param array - array holding a list of elements 
	 * @param start
	 * @param end
	 * @param elem
	 * @return
	 */
	private static int searchRecursively(int[] array, int start, int end, int elem) {
		
		System.out.println("Looking for " + elem + " between position " + start + " and " + end + " .... ");
		if (start > end)  {
			return -1;
		} else {
			int mid = (start + end)/2;

			if ( elem == array[mid]) {
				return mid;
			} else if (elem > array[mid]) {
				return searchRecursively(array, mid+1, end, elem);
			} else {
				return searchRecursively(array, start, mid-1, elem);
			}
		}
		//return result;
	}
	
	
	public static void main(String[] args) {
		
		int[] orderedArray = {5, 12, 17, 57, 83, 99, 201, 566, 776, 801, 994 };
		
		System.out.println("index of 801 in array is " + search(orderedArray, 801, false));
		
		System.out.println("index of 12 in array is " + search(orderedArray, 12, true));
		
		System.out.println("index of 99 in array is " + search(orderedArray, 99, false));
		
		System.out.println("index of 100 in array is " + search(orderedArray, 100, true));
		
	}

}
