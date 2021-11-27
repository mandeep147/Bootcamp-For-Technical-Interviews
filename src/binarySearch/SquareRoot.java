/**
 * SquareRoot
 */
package binarySearch;

import static util.Utils.printInput;
import static util.Utils.returnMid;

/**
 * @author mandeep
 */
public class SquareRoot {
    public static void main(String[] args) {
        printInput(squareRoot(5));
        printInput(squareRoot(2147395599));
    }
    
    private static int squareRoot(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int low = 0, high = x / 2;
        while (low <= high) {
            int mid = returnMid(low, high);
            if (square(mid) > x ) {
                high = mid - 1;
            } else if (square(mid) < x) {
                if (square(mid + 1) > x) {
                    return mid;
                }
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
    
    private static long square(int x) {
        return (long) x * x;
    }
}
