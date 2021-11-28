/**
 * Given a list of stock prices for a company, find the maximum amount of money you can make with two trades.
 * A trade is a buy and sell.
 * The two trades cannot overlap.
 * At max two trades, solution can do just one if that's the best case scenario
 * result should return max amount
 */
package arraysAndStrings;

import static util.Utils.checkIfArrayIsNull;
import static util.Utils.printInput;

/**
 * @author mandeep
 */
public class MaxAmountTwoTradesBuySell {
    public static void main(String[] args) {
        printInput(maxAmountTwoTrades(new Integer[]{3, 3, 5, 0, 0, 3, 1, 4})); // expects 6
        printInput(maxAmountTwoTrades(new Integer[]{1, 2, 3, 4, 5})); // expects 4
        printInput(maxAmountTwoTrades(new Integer[]{7, 6, 4, 3, 1})); // expects 0
        printInput(maxAmountTwoTrades(new Integer[]{1})); // expects 0
    }
    
    /**
     * Time: O(n)
     * Space: O(n)
     *
     * @param arr
     * @return
     */
    private static Integer maxAmountTwoTrades(Integer[] arr) {
        if (checkIfArrayIsNull(arr) || arr.length < 2) {
            return 0;
        }
        int maxAmount = 0;
        int[] bestTill = new int[arr.length];
        int minSoFar = Integer.MAX_VALUE;
        int maxDiff = 0;
        for (int i = 0; i < arr.length; i++) {
            minSoFar = Math.min(minSoFar, arr[i]);
            maxDiff = Math.max(maxDiff, arr[i] - minSoFar);
            bestTill[i] = maxDiff;
        }
        int[] bestFrom = new int[arr.length];
        int maxSoFar = Integer.MIN_VALUE;
        maxDiff = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            maxSoFar = Math.max(maxSoFar, arr[i]);
            maxDiff = Math.max(maxDiff, maxSoFar - arr[i]);
            bestFrom[i] = maxDiff;
        }
        for (int i = 0; i < arr.length; i++) {
            int maxSecondTrade = (i + 1 < arr.length) ? bestFrom[i + 1] : 0;
            maxAmount = Math.max(maxAmount, maxSecondTrade + bestTill[i]);
        }
        return maxAmount;
    }
}
