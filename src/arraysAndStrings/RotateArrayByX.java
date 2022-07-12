/**
 * Rotate an array A by X items. For example,
 * A = [1,2,3,4,5,6] and X = 2, Result = [5,6,1,2,3,4]
 */
package arraysAndStrings;

import static util.Utils.*;

/**
 * @author mandeep
 */
public class RotateArrayByX {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{2, 3, 1, 4, 5, 7, 5, 4};
        rotate(arr, 2);
        printArray(arr);
        rotate(arr, 3);
        printArray(arr);
    }
    
    /**
     * Time: O(n)
     * Space: O(1)
     *
     * @param arr
     * @param X
     */
    private static void rotate(Integer[] arr, int X) {
        if (checkIfArrayIsNull(arr) || X == 0) {
            return;
        }
        X = X % arr.length;
        reverse(arr, 0, arr.length - 1);
        reverse(arr, 0, X - 1);
        reverse(arr, X, arr.length - 1);
    }
    
    private static void reverse(Integer[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start++, end--);
        }
    }
}
