/**
 * Given a Linked List, find if it has a cycle
 */
package chapter7.linkedlist;

import java.util.HashSet;
import java.util.Set;

import static util.Utils.printInput;

/**
 * @author mandeep
 */
public class IsCycle {
    public static void main(String[] args) {
        Node head = new Node(50);
        head.next = new Node(20);
        head.next.next = new Node(15);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(10);
        printInput(hasCycleHashMap(head));
        printInput(hasCycle(head));
        
        // Creating a loop for testing
        head.next.next.next.next.next = head.next.next;
        printInput(hasCycleHashMap(head));
        printInput(hasCycle(head));
    }
    
    /**
     * Time = O(n)
     * Space = O(1)
     *
     * @param head
     */
    private static boolean hasCycle(Node head) {
        if (head == null || head.next == null)
            return false;
        Node slow = head;
        Node fast = head.next;
        
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
    
    /**
     * Space = Time = O(n)
     *
     * @param head
     */
    private static boolean hasCycleHashMap(Node head) {
        Set<Node> seen = new HashSet<>();
        while (head != null) {
            if (seen.contains(head)) {
                return true;
            }
            seen.add(head);
            head = head.next;
        }
        return false;
    }
}
