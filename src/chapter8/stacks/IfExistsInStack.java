/**
 * Find if a given number N exists in a stack S.
 */
package chapter8.stacks;

import java.util.Stack;

import static util.Utils.createStack;
import static util.Utils.printInput;

/**
 * @author mandeep
 */
public class IfExistsInStack {
    public static void main(String args[]) {
        int target = 2;
        Stack<Integer> stack = createStack();
        printInput(ifExistsInStack(target, stack));
        printInput(ifExistsInStack(target, null));
        printInput(ifExistsInStack(target, new Stack<>()));
    }
    
    /**
     * Time: O(n)
     * Space: O(1)
     *
     * @param target
     * @param stack
     * @return
     */
    private static boolean ifExistsInStack(int target, Stack<Integer> stack) {
        if (stack == null || stack.isEmpty()) {
            return false;
        }
        
        Stack<Integer> temp = new Stack<>();
        boolean found = false;
        
        while (!stack.isEmpty()) {
            if (stack.peek() == target) {
                found = true;
                break;
            }
            
            temp.push(stack.pop());
        }
        return found;
    }
}
