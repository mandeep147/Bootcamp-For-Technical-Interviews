/**
 * SumsToXUsingSlidingWindow
 * (Level: Easy)
 * Given an array of positive integers, find the contiguous subarray that sums to a given number X.
 * <p>
 * For example,
 * input = [1,2,3,5,2] and X=8,
 * Result = [3,5]
 * <p>
 * non sorted, all positive integers, contiguous
 */
package subarrayProblems;

import javafx.util.Pair;

import static util.Utils.checkIfArrayIsNull;
import static util.Utils.printInput;

/**
 * @author mandeep
 */
public class SumsToXUsingSlidingWindow {
    public static void main(String args[]) {
        Integer[] arr = {1, 2, 3, 5, 2};
        int x = 8;
        printInput(sumToX(arr, x));
    }
    
    /**
     * sum will always inc if window is expanded
     * sum will always dec if window is contracted
     * @param arr
     * @param x
     * @return
     */
    private static Pair sumToX(Integer[] arr, int x) {
        if (checkIfArrayIsNull(arr))
            return null;
        int start = 0, end = 0;
        int sum = arr[0];
        
        while (start < arr.length) {
            if (start > end) {
                // start new window
                end = start;
                sum = arr[start];
            }
            if (sum < x) {
                if (end == arr.length - 1)
                    break;
                end++;
                sum += arr[end]; // add value to sum
            } else if (sum > x) {
                sum -= arr[start]; // subtract value
                start++;
            } else {
                return new Pair<>(start, end);
            }
        }
        return null;
    }
}
