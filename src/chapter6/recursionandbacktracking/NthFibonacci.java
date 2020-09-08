/**
 * Find the nth number in the Fibonacci series. Fibonacci series is as follows:
 * 1, 1, 2, 3, 5, 8, 13, 21, ..
 * After the first two 1’s, each number is the sum of the previous two numbers.
 */
package chapter6.recursionandbacktracking;

import java.util.HashMap;

import static util.Utils.printInput;

/**
 * @author mandeep
 */
public class NthFibonacci {
    public static void main(String args[]) {
        printInput(fibonacci(1));
        printInput(fibonacci(3));
        printInput(fibonacci(25));
        printInput(fibonacci(null));
    }
    
    /**
     * Time: O(n)
     * Space: O(n)
     *
     * @param n
     * @return
     */
    private static int fibonacci(Integer n) {
        if (n == null) {
            return -1;
        }
        return fibonacci(n, new HashMap<>());
    }
    
    private static int fibonacci(Integer n, HashMap<Integer, Integer> map) {
        if (n == 1 || n == 2) {
            return 1;
        }
        
        if (map.containsKey(n)) {
            return map.get(n);
        }
        
        int result = fibonacci(n - 1, map) + fibonacci(n - 1, map);
        map.put(n, result);
        return result;
    }
}
