/**
 * FirstDuplicateElement
 * Given a sorted array that can contain duplicates, find the first occurrence of the target element.
 * <p>
 * For example:
 * A = [1,3,4,6,6,6,7] and Target = 6, return index 3.
 */
package chapter5.binarysearch;

import static util.Utils.*;

/**
 * @author mandeep
 */
public class FirstDuplicateElement {
    public static void main(String args[]) {
        Integer[] arr = {1, 3, 4, 6, 6, 6, 7};
        int target = 6;
        printInput(firstDuplicate(arr, target));
    }
    
    /**
     * other approach is using hashmap
     *
     * @param arr
     * @param target
     * @return
     */
    private static int firstDuplicate(Integer[] arr, int target) {
        if (checkIfArrayIsNull(arr))
            return -1;
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = returnMid(start, end);
            if (arr[mid] < target) {
                start = mid + 1;
            } else if (arr[mid] > target || (arr[mid] == target && mid > 0 && arr[mid - 1] == target)) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
