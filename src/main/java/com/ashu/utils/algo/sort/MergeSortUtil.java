package com.ashu.utils.algo.sort;

import java.util.Arrays;



/**
 * My mergesort implementation
 * 
 * Important Note:
 * In JDK-8 (x64) - Arrays.sort() uses a sorting algorithm which is a Dual-Pivot Quicksort.
   Collections.sort() implementation is a stable, adaptive, iterative mergesort. This implementation 
   dumps the specified list into an array, sorts the array, and iterates over the list resetting each
   element from the corresponding position in the array.
   If Collections.sort() uses an array, why doesn't it just call Arrays.sort() or use dual-pivot QuickSort? 
   Why use Mergesort?
   
   
   According to the Javadoc, only primitive arrays are sorted using Quicksort. 
   Object arrays are sorted with a Mergesort as well
   
   Quick Sort has two major drawbacks when it comes to merge sort:

	1. It's not stable while it comes to non primitive.
    2. It doesn't guarantee n log n performance.
	
	Stability is a non-issue for primitive types, as there is no notion of identity as distinct from (value) equality.
	Stability is a big deal when sorting arbitrary objects. 
	It's a nice side benefit that Merge Sort guarantees n log n (time) performance no matter what the input. 
	That's why merge sort is selected to provide a stable sort (Merge Sort) to sort object references.
	
	
	
   
 * @author https://www.github.com/ashismishraw
 *
 */
public class MergeSortUtil {
	
	
	public static void main(String[] args) {
		
		int[] unsortedArray = {51, 2, 17, 57, 0, 99, 201, 37, 3, 801, 8 };
		
		System.out.println("Unsorted array is " + Arrays.toString(unsortedArray));
		sort(unsortedArray);
		System.out.println("sorted array is " + Arrays.toString(unsortedArray)  );
		
		
	}
	
	
	public static void sort(int[] arr) {
				
		mergeSort(arr, 0, arr.length-1);
		
		System.out.println("" + Arrays.toString(arr));

	}
	
	
	
	public static void mergeSort(int[] arr, int p, int r) {
		
		if (p<r) {	
			int q = (p + r)/2;
			mergeSort(arr, p, q);
			mergeSort(arr, q+1, r);
			merge(arr, p, q, r);
		}
	}
	
	
	
	public static void merge(int[] array, int p, int q, int r) {
		
		int[] tempArray = new int[r-p + 1];
			
		int i = p;
		int j = q+1;
		int k = 0;
		
		while(i <=q && j <= r) { // O(N/2)
			if (array[i] < array[j]) {
				tempArray[k] = array[i];
				i = i+1;
			} else {
				tempArray[k] = array[j];
				j = j+1;
			}
			k = k+1;
		}
		
		//Above loop does sort, but does not guarantee that all the elements are copied into tempArray
		//Lets do the copying of leftover elements of either side
		if (i<=q) {
			while (i <=q) {
				tempArray[k] = array[i];
				i = i+1;
				k = k+1;
			}
		} else if (j <= r) {
			while (j <= r) {
				tempArray[k] = array[j];
				j = j+1;
				k = k+1;
			}
		}
		
		//copy the array again - O(N)
		for (int x = 0; x < tempArray.length; x++ ) { // O(N)
			array[p + x] = tempArray[x];
		}

	}
	
}
