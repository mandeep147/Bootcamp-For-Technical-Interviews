/**
 * LinkedList
 */
package chapter7.linkedlist;

/**
 * @author mandeep
 */
public class LinkedList {
    Node head;
    int data;
    int length;
    
    public LinkedList() {
        head = null;
        data = 0;
    }
    
    public LinkedList(Node head, int data) {
        this.head = head;
        this.data = data;
    }
    
    public LinkedList(int data) {
        this.data = data;
    }
    
    public void appendToEnd(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            
            temp.next = node;
            node.next = null;
        }
        length++;
    }
    
    public void insertAtBegin(int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
        length++;
    }
    
    public void insertAtPosition(int position, int data) {
        if (position < 0) {
            position = 0;
        }
        if (position > length) {
            position = length;
        }
        if (head == null) {
            insertAtBegin(data);
        } else if (position == length) {
            appendToEnd(data);
        } else {
            Node curr = new Node(data);
            int count = 1;
            Node node = head;
            while (count != position - 1) {
                node = node.next;
                count++;
            }
            curr.next = node.next;
            node.next = curr;
            length++;
        }
    }
    
    public void printList() {
        Node curr = head;
        System.out.print(head.data + " -> ");
        while (curr.next != null) {
            curr = curr.next;
            System.out.print(curr.data + " -> ");
        }
        System.out.println();
    }
    
    public void deleteNode(int position) {
        if (position < 0) {
            position = 0;
        }
        
        if (position > length) {
            position = length;
        }
        if (head == null) {
            return;
        }
        
        if (position == 0) {
            deleteStartNode();
        } else if (position == length) {
            deleteEndNode();
        } else {
            int count = 1;
            Node node = head;
            while (count != position - 1) {
                node = node.next;
                count++;
            }
            node.next = node.next.next;
            length--;
        }
    }
    
    public void deleteStartNode() {
        if (head != null) {
            head = head.next;
        }
    }
    
    public void deleteEndNode() {
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        length--;
    }
}
