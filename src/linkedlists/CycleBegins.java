/**
 * CycleBegins
 */
package linkedlists;

import static util.Utils.printInput;

/**
 * @author mandeep
 */
public class CycleBegins {
    public static void main(String[] args) {
        Node head = new Node(50);
        head.next = new Node(20);
        head.next.next = new Node(15);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(10);
        head.next.next.next.next.next = head.next.next.next;
        printInput(findCycleBegins(head).data);
    }
    
    /**
     * find cycle,
     * find length of cycle,
     * advance one pointer by length of cycle,
     * adv both pointers until they meet
     *
     * @param head
     * @return
     */
    private static Node findCycleBegins(Node head) {
        if (head == null || head.next == null) {
            return null; // no cycle
        }
        
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
            return null; // no cycle in list
        }
        int count = 1;
        fast = fast.next;
        while (slow != fast) {
            count++;
            fast = fast.next;
        }
        Node first = head, second = head;
        for (int i = 0; i < count; i++) {
            second = second.next;
        }
        while (first != second) {
            first = first.next;
            second = second.next;
        }
        return first;
    }
}
