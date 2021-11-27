/**
 * Implement a Queue using two stacks
 */
package stack;

import util.Utils.EmptyQueueException;

import java.util.Stack;

import static util.Utils.printInput;
import static util.Utils.printSameLine;

/**
 * Constraints:
 * Use only constant memory
 * Throw an exception if a dequeue is tried on empty queue
 * <p>
 * Note: Stack is LIFO where Queue is FIFO
 *
 * @author mandeep
 */
public class QueueUsingTwoStacks {
    
    private static Stack<Integer> s1;
    private static Stack<Integer> s2;
    
    QueueUsingTwoStacks() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public static void main(String args[]) throws EmptyQueueException {
        QueueUsingTwoStacks q = new QueueUsingTwoStacks();
        q.enqueue(1);
        q.enqueue(12);
        q.enqueue(13);
        q.enqueue(14);
        
        printInput(q.dequeue());
        printInput(q.dequeue());
        printInput(q.dequeue());
        
        q = new QueueUsingTwoStacks();
        printSameLine(q.dequeue()); // should throw empty queue exception
    }
    
    /**
     * Time: O(1)
     *
     * @param value
     */
    public void enqueue(Integer value) {
        s1.push(value);
    }
    
    /**
     * Time: O(n) worst case
     * Space: O(1)
     *
     * @return
     * @throws EmptyQueueException
     */
    public int dequeue() throws EmptyQueueException {
        if (s2.isEmpty()) {
            flushToS2();
        }
        
        if (s2.isEmpty())
            throw new EmptyQueueException();
        
        return s2.pop();
    }
    
    private void flushToS2() {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
    }
    
}
