/**
 * AllZeroesToEnd
 * Given an array of integers, rearrange the elements such that all zeros are moved to the end of the array.
 */
package com.chapter1.arraysandstrings.partitioningarrays;

import static com.utils.Utils.printArray;
import static com.utils.Utils.swap;

/**
 * @author mandeep
 */
public class AllZeroesToEnd {
    public static void main(String args[]) {
        Integer[] arr = {4, 2, 0, 1, 0, 3, 0};
        moveZeroesToEnd(arr);
        printArray(arr);
    }
    
    private static void moveZeroesToEnd(Integer[] arr) {
        int j = arr.length - 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 0) {
                swap(arr, i, j);
                j--;
            }
        }
    }
}
