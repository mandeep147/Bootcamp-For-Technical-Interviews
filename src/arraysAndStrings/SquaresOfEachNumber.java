/**
 * SquaresOfEachNumber
 * Given a sorted array in non-decreasing order, return an array of squares of each number, also in non-decreasing order.
 * For example:[-4,-2,-1,0,3,5] -> [0,1,4,9,16,25]
 * How can you do it in O(n) time?
 */
package arraysAndStrings;

import static util.Utils.checkIfArrayIsNull;
import static util.Utils.printArray;

/**
 * @author mandeep
 */
public class SquaresOfEachNumber {
    public static void main(String args[]) {
        Integer[] arr = {-4, -2, -1, 0, 3, 5};
        Integer[] square = squares(arr);
        printArray(square);
    }
    
    private static Integer[] squares(Integer[] arr) {
        if (checkIfArrayIsNull(arr))
            return null;
        int start = 0, end = arr.length - 1;
        Integer[] res = new Integer[arr.length];
        int i = res.length - 1;
        
        while (start <= end) {
            if (abs(arr[start]) > abs(arr[end])) {
                res[i] = square(arr[start]);
                start++;
            } else {
                res[i] = square(arr[end]);
                end--;
            }
            i--;
        }
        return res;
    }
    
    private static Integer square(Integer integer) {
        return integer * integer;
    }
    
    private static Integer abs(Integer value) {
        return Math.abs(value);
    }
}
