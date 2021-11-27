/**
 * You are given a sorted array A and a target T. Return the index where it would be placed if inserted in order.
 * <p>
 * For example,
 * A = [1,2,4,4,5,6,8] and T = 3, return index 2
 * A = [1,2,4,4,5,6,8] and T = 0, return index 0
 * A = [1,2,4,4,5,6,8] and T = 4, return index 2, 3 or 4 (they're all valid).
 */
package binarySearch;

import static util.Utils.printInput;
import static util.Utils.returnMid;

/**
 * @author mandeep
 */
public class InsertInOrder {
    public static void main(String args[]) {
        Integer[] arr = {1, 2, 4, 4, 5, 6, 8};
        int target = 3;
        printInput(insertionIndex(arr, target));
        printInput(insertionIndex(arr, 0));
        printInput(insertionIndex(arr, 4));
        printInput(insertionIndex(null, 4));
        printInput(insertionIndex(new Integer[0], 4));
    }
    
    /**
     * read problem as "Given an array A and target T, Find the first element larger than T"
     *
     * @param arr
     * @param target
     * @return
     */
    private static int insertionIndex(Integer[] arr, int target) {
        if (arr == null)
            return -1;
        if (arr.length == 0)
            return 0;
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = returnMid(start, end);
            if (arr[mid] <= target) {
                if (mid == arr.length - 1)
                    return arr.length;
                start = mid + 1;
            } else {
                if (mid == 0 || arr[mid - 1] <= target) {
                    return mid;
                }
                end = mid - 1;
            }
        }
        return -1;
    }
}
