/**
 * If you found a cycle in a linked list, find the length of the cycle.
 */
package linkedlists;

import static util.Utils.printInput;

/**
 * @author mandeep
 */
public class LengthCycle {
    public static void main(String[] args) {
        Node head = new Node(50);
        head.next = new Node(20);
        head.next.next = new Node(15);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(10);
        // Creating a loop
        head.next.next.next.next.next = head.next;
        printInput(lengthIfCycle(head));
    }
    
    /**
     * Time: O(n)
     * Space: O(1)
     *
     * @param head
     * @return
     */
    private static int lengthIfCycle(Node head) {
        if (head == null || head.next == null)
            return 0;
        Node slow = head;
        Node fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if (fast == null || fast.next == null) {
            return 0; // no cycle
        }
        int count = 1;
        fast = fast.next;
        while (slow != fast) {
            count++;
            fast = fast.next;
        }
        return count;
    }
}
