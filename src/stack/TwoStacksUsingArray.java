/**
 * Implement two stack using array
 */
package stack;

import util.Utils.StackEmptyException;
import util.Utils.StackFullException;

import static util.Utils.printInput;

/**
 * Constraints:
 * 1. size of array is fixed
 * 2. throw an exception if array is full
 * 3. implement push and pop for stack
 * <p>
 * Time Complexity of solution: O(1) for both push and pop operation on stacks
 * Space: O(1)
 *
 * @author mandeep
 */
public class TwoStacksUsingArray {
    private static int[] array;
    private static int s1Index;
    private static int s2Index;
    
    TwoStacksUsingArray(int arraySize) {
        array = new int[arraySize];
        s1Index = 0;
        s2Index = array.length - 1;
    }
    
    public static void main(String args[]) throws StackFullException, StackEmptyException{
        TwoStacksUsingArray stack = new TwoStacksUsingArray(5);
        stack.push(1, 5);
        stack.push(2, 10);
        stack.push(2, 15);
        stack.push(1, 11);
        stack.push(2, 7);
//        stack.push(1, 4); // should throw Stack full exception
    
        printInput("Element popped from stack1: " + stack.pop(1));
        printInput("Element popped from stack2: " + stack.pop(2));
        
    }
    
    private void push(int stackNumber, int value) throws StackFullException {
        if(stackNumber != 1 && stackNumber != 2) {
            throw new IllegalArgumentException("Invalid stack number");
        }
        
        if(s1Index > s2Index)
            throw new StackFullException();
        
        if(stackNumber == 1)
            array[s1Index++] = value;
        
        if(stackNumber == 2)
            array[s2Index--] = value;
    }
    
    private int pop(int stackNumber) throws StackEmptyException {
        if(stackNumber != 1 && stackNumber != 2) {
            throw new IllegalArgumentException("Invalid stack number");
        }
        if(stackNumber == 1 && s1Index > 0) {
            return array[--s1Index];
        } else if(stackNumber ==2 && s2Index < array.length - 1) {
            return array[++s2Index];
        }
        
        throw new StackEmptyException();
    }
}
