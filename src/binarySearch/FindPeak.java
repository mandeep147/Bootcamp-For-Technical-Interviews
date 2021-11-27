/**
 * A peak element in an array A is an A[i] where its neighboring elements are less than A[i].
 * So, A[i - 1] < A[i] and A[i + 1] < A[i].Assume there are no duplicates.
 * Also, assume that A[-1] and A[length] are negative infinity (-∞).
 * So A[0] can be a peak if A[1] < A[0].
 * A = [1,3,4,5,2] => Peak = 5
 * A = [5,3,1] => Peak = 5
 * A = [1,3,5] => Peak = 5
 */
package binarySearch;

import static util.Utils.*;

/**
 * @author mandeep
 */
public class FindPeak {
    public static void main(String[] args) {
        printInput(findPeakElement(new Integer[]{1, 3, 4, 5, 2}));
//        printInput(findPeakElement(new Integer[]{5, 3, 1}));
//        printInput(findPeakElement(new Integer[]{1, 3, 5}));
    }
    
    private static int findPeakElement(Integer[] arr) {
        if (checkIfArrayIsNull(arr)) {
            return -1;
        }
        
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = returnMid(start, end);

            int left = (mid > 0) ? arr[mid -1] : Integer.MIN_VALUE;
            int right = (mid < arr.length - 1) ? arr[mid + 1] : Integer.MAX_VALUE;

            if (left < arr[mid] && right > arr[mid]) {
                start = mid + 1;
            } else if (right < arr[mid] && left > arr[mid]) {
                end = mid - 1;
            } else if (right > arr[mid] && left > arr[mid]) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
