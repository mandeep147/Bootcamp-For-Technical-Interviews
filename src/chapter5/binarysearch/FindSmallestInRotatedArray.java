/**
 * Given an array that is cyclically sorted, find the minimum element.
 * A cyclically sorted array is a sorted array rotated by some number of elements.
 * Assume all elements are unique.
 * <p>
 * For example:
 * A = [4,5,1,2,3], which is just [1,2,3,4,5] rotated by 2
 * Result = index 2
 */
package chapter5.binarysearch;

import static util.Utils.printInput;
import static util.Utils.returnMid;

/**
 * @author mandeep
 */
public class FindSmallestInRotatedArray {
    public static void main(String args[]) {
        Integer[] arr = {4, 5, 1, 2, 3};
        printInput(minimumInCyclicallySortedArray(arr));
        printInput(minimumInCyclicallySortedArray(new Integer[]{}));
        printInput(minimumInCyclicallySortedArray(null));
        printInput(minimumInCyclicallySortedArray(new Integer[]{1, 2, 3, 4, 5}));
        
        printInput(minimumInCyclicallySortedArrayBinarySearch(arr));
        printInput(minimumInCyclicallySortedArrayBinarySearch(new Integer[]{}));
        printInput(minimumInCyclicallySortedArrayBinarySearch(null));
        printInput(minimumInCyclicallySortedArrayBinarySearch(new Integer[]{1, 2, 3, 4, 5}));
    }
    
    /**
     * Time: O(n)
     * Space: O(1)
     *
     * @param arr
     * @return
     */
    private static int minimumInCyclicallySortedArray(Integer[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int max = arr[0];
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < max) {
                return i;
            }
        }
        return 0; //first element
    }
    
    /**
     * Time: O(log n)
     * Space: O(1)
     *
     * @param arr
     * @return
     */
    private static int minimumInCyclicallySortedArrayBinarySearch(Integer[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int start = 0, end = arr.length - 1, right = arr[end];
        while (start <= end) {
            int mid = returnMid(start, end);
            if (arr[mid] <= right && (mid == 0 || arr[mid - 1] > arr[mid])) {
                return mid;
            } else if (arr[mid] > right) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return -1;
    }
}
