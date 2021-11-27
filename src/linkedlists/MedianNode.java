/**
 * Given a linked list, find its median node. You may assume the list does not have a cycle.
 */
package linkedlists;

import static util.Utils.printInput;

/**
 * @author mandeep
 */
public class MedianNode {
    public static void main(String[] args) {
        Node head = new Node(5);
        head.next = new Node(20);
        head.next.next = new Node(15);
        head.next.next.next = new Node(4);
        printInput(medianNode(head).data);
        head.next.next.next.next = new Node(10);
        printInput(medianNode(head).data);
    }
    
    /**
     * use two pointers, slow and fast, when fast reaches end, slow will be at median node.
     * modification: both starts at head
     * Time: O(n)
     * Space: O(1)
     *
     * @param head
     * @return
     */
    private static Node medianNode(Node head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;
        
        Node slow = head;
        Node fast = head;
        while (fast.next != null) {
            fast = fast.next;
            if (fast.next != null) {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return slow;
    }
}
