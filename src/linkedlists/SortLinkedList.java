/**
 * You are given a Linked List with nodes that have values 0, 1 or 2.
 * Sort the linked list. For example,
 * <p>
 * Input: 1 -> 0 -> 2 -> 1 -> 2 -> 1
 * Output: 0 -> 1 -> 1 -> 1 -> 2 -> 2
 */
package linkedlists;


import static util.Utils.printInput;

/**
 * @author mandeep
 */
public class SortLinkedList {
    public static void main(String[] args) {
        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(0);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        head.next.next.next.next.next = new Node(0);
        Node sortedList = sortList(head);
        
        while (sortedList != null) {
            printInput(sortedList.data + " -> ");
            sortedList = sortedList.next;
        }
    }
    
    /**
     * Time: O(n)
     * Aux space: O(1)
     *
     * @param head
     * @return
     */
    private static Node sortList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node zeroL = new Node(), oneL = new Node(), twoL = new Node();
        Node zero = zeroL, one = oneL, two = twoL;
        Node curr = head;
        while (curr != null) {
            switch (curr.data) {
                case 0:
                    zero.next = curr;
                    zero = zero.next;
                    break;
                case 1:
                    one.next = curr;
                    one = one.next;
                    break;
                case 2:
                    two.next = curr;
                    two = two.next;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid node value");
            }
            curr = curr.next;
        }
        // combine 0, 1 and 2 lists
        zero.next = (oneL.next != null) ? oneL.next : twoL.next;
        one.next = twoL.next;
        two.next = null;
        return zeroL.next;
    }
}
