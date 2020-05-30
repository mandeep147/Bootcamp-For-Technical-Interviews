/**
 * Given a sorted array of Integers, find the target. If the target is not found,return the element closest to the target.
 * <p>
 * For example,
 * A = [1,2,4,5,7,8,9], Target = 6 -> Output Index = 3 or 4 (since both 5 and 7 are equally close)
 */
package chapter5.binarysearch;

import static util.Utils.*;

/**
 * @author mandeep
 */
public class FindClosest {
    public static void main(String args[]) {
        Integer[] arr = {1, 2, 4, 5, 7, 8, 9};
        int target = 6;
        printInput(returnClosest(arr, target));
        printInput(returnClosest(null, target));
    }
    
    private static int returnClosest(Integer[] arr, int target) {
        if (checkIfArrayIsNull(arr))
            return -1;
        int start = 0, end = arr.length - 1;
        int result = -1;
        while (start <= end) {
            int mid = returnMid(start, end);
            result = record(arr, mid, result, target);
            if (arr[mid] > target) {
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return result;
    }
    
    private static int record(Integer[] arr, int mid, int result, int target) {
        if (result == -1 || arr[mid] < arr[result])
            return mid;
        return result;
    }
}
