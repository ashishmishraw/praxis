package com.ashu.utils.puzz;

/**
 * Partition a list/array of numbers so that the lower values are in front of it and higher values are behind it
 *
 * Partitionining coud be around a given pivotal number or assume last element is pivot
 *
 * Created by mishra.ashish@icloud.com
 */
public class PartitionInPlaceUsingPivot {

    public static void main(String[] args) {
        int[] list = {7, 3, 6, 8, 2, 9, 5, 4};

        partition(list, 0, list.length - 1);

        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i]);
            if(i < list.length-1)
                System.out.print(",");
        }
    }

    /**
     * Partition logic
     * @param list
     * @param start
     * @param end
     */
    private static void partition(int[] list, int start, int end) {

        int i = -1;
        int j = start;
        int pivotIndex = end;

        while (j <= end) {
            if (list[j] <= list[pivotIndex]) {
                i++;
                //swap
                int temp = list[j];
                list[j] = list[i];
                list[i] = temp;
            }
            j++;
        }
    }

}
