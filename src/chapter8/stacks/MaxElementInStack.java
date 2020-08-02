/**
 * Implement a Stack with O(1) lookup of the maximum element in the stack.
 * <p>
 * For example,
 * <p>
 * Stack: 3 -> 2 -> 1 -> 5
 * Max() => 5
 * <p>
 * After 1 pop():
 * Stack: 3 -> 2 -> 1
 * Max() => 3
 */
package chapter8.stacks;

import java.util.EmptyStackException;
import java.util.Stack;

import static util.Utils.printInput;

/**
 * Constraints:
 * <p>
 * 1. can use extra space
 * 2. throw exception if stack is empty
 * <p>
 * Approach: maintain a maxStack stack, every time a push operation is encountered,
 * insert item to mainStack stack and maxStack stack if condition is satisfied
 * example:
 * mainStack stack: 3, 1, 4, 2, 4, 6, 3
 * maxStack stack: 3, 4, 4, 6
 * <p>
 * push: 8
 * mainStack: 3, 1, 4, 2, 4, 6, 3, 8
 * maxStack: 3, 4, 4, 6, 8
 * <p>
 * push: 3
 * mainStack: 3, 1, 4, 2, 4, 6, 3, 8, 3
 * maxStack: 3, 4, 4, 6, 8 // no push on maxStack since 3 is not >= 8
 * <p>
 * <p>
 * On Pop operation make sure to remove item from both stacks
 * Space: O(n)
 *
 * @author mandeep
 */
public class MaxElementInStack {
    static Stack<Integer> mainStack;
    Stack<Integer> maxStack;
    
    MaxElementInStack() {
        mainStack = new Stack<>();
        maxStack = new Stack<>();
    }
    
    public static void main(String args[]) {
        MaxElementInStack maxElementInStack = new MaxElementInStack();
        maxElementInStack.push(3);
        maxElementInStack.push(1);
        maxElementInStack.push(4);
        maxElementInStack.push(2);
        
        printInput(maxElementInStack.max());    // max = 4
        maxElementInStack.push(6);
        printInput(maxElementInStack.max());    // max = 6
        
        maxElementInStack.pop();
        printInput(maxElementInStack.max());    // max = 4
        
        maxElementInStack.pop();
        printInput(maxElementInStack.max());    // max = 4
    }
    
    private void push(Integer value) {
        mainStack.push(value);
        if (maxStack.isEmpty() || maxStack.peek() <= value) {
            maxStack.push(value);
        }
    }
    
    private int pop() throws EmptyStackException {
        if (mainStack.isEmpty())
            throw new EmptyStackException();
        int current = mainStack.pop();
        if (maxStack.peek() == current) {
            maxStack.pop();
        }
        return current;
    }
    
    private int max() throws EmptyStackException {
        if (maxStack.isEmpty())
            throw new EmptyStackException();
        return maxStack.peek();
    }
}
