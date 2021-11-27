/**
 * Given a Linked List L, separate it into 2 Linked Lists.
 * One contains L's odd nodes and the other contains L's even nodes.
 * For example:
 * <p>
 * Input: Head -> 1 -> 2 -> 3 -> 4 -> 5
 * <p>
 * Result 1: Head -> 1 -> 3 -> 5
 * Result 2: Head -> 2 -> 4
 * <p>
 * Note: Odd and Even here refer to the node's position, not value.
 */
package linkedlists;

import static util.Utils.printInput;
import static util.Utils.printSameLine;

/**
 * @author mandeep
 */
public class OddEvenLinkedList {
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(1);
        head.next.next = new Node(0);
        head.next.next.next = new Node(32);
        head.next.next.next.next = new Node(1);
        head.next.next.next.next.next = new Node(0);
        Node[] result = oddEvenLinkedLists(head);
        for (Node list : result) {
            printInput("List: ");
            while (list != null) {
                printSameLine(list.data + " -> ");
                list = list.next;
            }
        }
    }
    
    /**
     * return array of head nodes for two linkedlists
     * @param head
     * @return
     */
    private static Node[] oddEvenLinkedLists(Node head) {
        int index = 0;
        Node evenL = new Node(), oddL = new Node();
        Node even = evenL, odd = oddL;
        Node curr = head;
        while (curr != null) {
            if (isEven(index)) {
                even.next = curr;
                even = even.next;
            } else {
                odd.next = curr;
                odd = odd.next;
            }
            index++;
            curr = curr.next;
        }
        even.next = null;
        odd.next = null;
        return new Node[]{evenL, oddL};
    }
    
    private static boolean isEven(int value) {
        return value % 2 == 0;
    }
}
