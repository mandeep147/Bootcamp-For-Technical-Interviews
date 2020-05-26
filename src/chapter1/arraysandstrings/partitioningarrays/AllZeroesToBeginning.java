/**
 * AllZeroesToBeginning
 * You are given an array of integers. Rearrange the array so that all zeroes are at the beginning of the array.
 * <p>
 * For example,
 * a = [4,2,0,1,0,3,0] -> [0,0,0,4,1,2,3]
 */
package chapter1.arraysandstrings.partitioningarrays;

import static util.Utils.printArray;
import static util.Utils.swap;

/**
 * @author mandeep
 */
public class AllZeroesToBeginning {
    public static void main(String args[]) {
        Integer[] arr = {4, 2, 0, 1, 0, 3, 0};
        moveZeroesToBeginning(arr);
        printArray(arr);
    }
    
    // order doesn't matter
    private static void moveZeroesToBeginning(Integer[] arr) {
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                swap(arr, i, j);
                j++;
            }
        }
    }
}
