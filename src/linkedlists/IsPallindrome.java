/**
 * Given a Linked List, determine if it is a Palindrome.
 * For example, the following lists are palindromes:
 * A -> B -> C -> B -> A
 * A -> B -> B -> A
 * K -> A -> Y -> A -> K
 *
 * Note: Can you do it with O(N) time and O(1) space? (Hint: Reverse a part of the list)
 */
package linkedlists;

import static util.Utils.printInput;

/**
 * @author mandeep
 */
public class IsPallindrome {
    public static void main(String[] args) {
        Node head = new Node(50);
        head.next = new Node(20);
        head.next.next = new Node(15);
        head.next.next.next = new Node(20);
        head.next.next.next.next = new Node(50);
        printInput(isPallindrome(head));
    }
    
    private static boolean isPallindrome(Node head) {
        if (head == null) {
            return false;
        }
        Node median = findMedianNode(head);
        Node last = reverseList(median);
        Node start = head, end = last;
        while (start != null && end != null) {
            if (start.data != end.data) {
                return false;
            }
            start = start.next;
            end = end.next;
        }
        return true;
    }
    
    private static Node reverseList(Node head) {
        Node prev = null, curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    
    private static Node findMedianNode(Node head) {
        Node fast = head, slow = head;
        while (fast.next != null) {
            fast = fast.next;
            if (fast.next != null) {
                break;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
