/**
 * Given a sorted array, search for a target item
 */
package binarySearch;

import static util.Utils.printInput;
import static util.Utils.returnMid;

/**
 * @author mandeep
 */
public class SearchTargetItem {
    public static void main(String args[]) {
        int target = 2;
        Integer[] arr = {1, 2, 3, 5, 7};
        printInput(binarySearch(arr, target));
    }
    
    /**
     * mid = start + (end - start)/2​
     * Let's say ​start​ and ​end​ were very large integers. We know they cannot be larger than ​2^31 - 1 (~2billion)​,
     * because they are given to us as integers (assuming integer size of 32 bytes).
     * However, their sum could be larger. This is called an ​integer overflow​.In an integer overflow, ​
     * start + end​ would wrap around the max value into the negatives.
     * If it is an unsigned integer, the value would wrap around 0
     *
     * @param arr
     * @param target
     * @return
     */
    private static int binarySearch(Integer[] arr, int target) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = returnMid(start, end);
            if (arr[mid] < target)
                start = mid + 1;
            else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
