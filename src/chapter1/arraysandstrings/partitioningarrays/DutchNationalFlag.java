/**
 * DutchNationalFlag
 * Level: Medium
 * You are given an array of integers and a pivot. Rearrange the array in the following order:
 * [all elements less than pivot, elements equal to pivot, elements greater than pivot]
 * <p>
 * For example,
 * a = [5,2,4,4,6,4,4,3] and pivot = 4 --> result = [3,2,4,4,4,4,5,6].
 */
package chapter1.arraysandstrings.partitioningarrays;

import static util.Utils.*;

/**
 * @author mandeep
 */
public class DutchNationalFlag {
    public static void main(String args[]) {
        Integer[] arr = {5, 2, 4, 4, 6, 4, 4, 3};
        int pivot = 4;
        printArray(dutchNationalFlag(arr, pivot));
    }
    
    /**
     * Time: O(n)
     * Space: O(1)
     * <p>
     * | < pivot | == pivot | > pivot|
     *
     * @param arr
     * @param pivot
     * @return
     */
    private static Integer[] dutchNationalFlag(Integer[] arr, int pivot) {
        if (checkIfArrayIsNull(arr))
            return null;
        int low = 0, high = arr.length - 1;
        int i = 0;
        
        while (i <= high) {
            if (arr[i] < pivot) {
                swap(arr, i, low);
                low++;
                i++;
            } else if (arr[i] > pivot) {
                swap(arr, i, high);
                high--;
            } else {
                i++;
            }
        }
        return arr;
    }
}
