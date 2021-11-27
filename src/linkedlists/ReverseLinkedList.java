/**
 * Reverse a linked list in place.
 * Input: Head -> 1 -> 2 -> 3 -> 4 -> null
 * Output: Head -> 4 -> 3 -> 2 -> 1 -> null
 */
package linkedlists;

import static util.Utils.printInput;

/**
 * @author mandeep
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        Node head = new Node(50);
        head.next = new Node(20);
        head.next.next = new Node(15);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(10);
        printInput(reverseLinkedList(head).data);
    }
    
    private static Node reverseLinkedList(Node head) {
        Node prev = null, curr = head;
        while( curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
