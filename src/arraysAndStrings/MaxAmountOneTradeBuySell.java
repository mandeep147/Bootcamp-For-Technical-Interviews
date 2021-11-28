/**
 * Given a list of stock prices for a company, find the maximum amount of money you can make with one trade.
 * A trade is a buy and sell.
 * For example, if A = [2,3,1,4,5,7,5,4], the max money with a single trade is 6, if you buy at 1 and sell at 7.
 */
package arraysAndStrings;

import static util.Utils.checkIfArrayIsNull;
import static util.Utils.printInput;

/**
 * @author mandeep
 */
public class MaxAmountOneTradeBuySell {
    public static void main(String[] args) {
        printInput(maxAmountOneTrade(new Integer[]{2, 3, 1, 4, 5, 7, 5, 4}));
    }
    
    /**
     * Time: O(n)
     * Space: O(1)
     *
     * @param arr
     * @return
     */
    private static Integer maxAmountOneTrade(Integer[] arr) {
        if (checkIfArrayIsNull(arr) || arr.length < 2) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int maxAmount = 0;
        // commented code to find index of trade elements
        //        int endIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            maxAmount = Math.max(maxAmount, arr[i] - min);
            // if we want to return indices/elements
            //            int max = arr[i] - min;
            //            if (max > maxAmount) {
            //                maxAmount = max;
            //                endIndex = i;
            //            }
        }
        
        //        int startIndex = endIndex - 1;
        //        while (startIndex >= 0) {
        //            if (maxAmount == (arr[endIndex] - arr[startIndex]))
        //                break;
        //            startIndex--;
        //        }
        //        printInput(startIndex);
        //        printInput(endIndex);
        return maxAmount;
    }
}
