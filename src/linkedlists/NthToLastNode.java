/**
 * Find the 3rd to last element in a given linked list.
 */
package linkedlists;

import static util.Utils.printInput;

/**
 * @author mandeep
 */
public class NthToLastNode {
    public static void main(String[] args) {
        Node head = new Node(50);
        head.next = new Node(20);
        //        printInput(nthLastElement(head, 4).data);// throws exception for not enough elements
        head.next.next = new Node(15);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(10);
        printInput(nthLastElement(head, 3).data);
        printInput(nthLastElement(head, 4).data);
        printInput(nthLastElement(head, 1).data);
        printInput(nthLastElement(null, 1));
    }
    
    /**
     * Time: O(n)
     * Space: O(1)
     *
     * @param head
     * @param n
     * @return
     */
    private static Node nthLastElement(Node head, int n) {
        if (head == null)
            return null;
        Node first = head;
        Node second = head;
        for (int i = 0; i < n; i++) {
            if (second.next != null) {
                second = second.next;
            } else {
                throw new IllegalArgumentException("not enough elements in list");
            }
        }
        while (second != null) {
            first = first.next;
            second = second.next;
        }
        return first;
    }
}
