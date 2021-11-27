/**
 * Implement a Least Recently Used (LRU) cache.
 */
package linkedlists;

import java.util.HashMap;

import static util.Utils.printInput;

/** uses LinkedHashTable as backbone
 * @author mandeep
 */
public class LRUCache {
    int capacity;
    HashMap<Integer, LRUNode> map = new HashMap<>();
    LRUNode head = null;
    LRUNode tail = null;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public static void main(String[] args) {
        int capacity = 2;
        LRUCache cache = new LRUCache(capacity);
        cache.put(1, 1);
        cache.put(2, 2);
        printInput(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        printInput(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);
        printInput(cache.get(1));       // returns -1 (not found)
        printInput(cache.get(3));       // returns 3
        printInput(cache.get(4));       // returns 4
    }
    
    private int get(int key) {
        if(map.containsKey(key)) {
            LRUNode node = map.get(key);
            removeNode(node);
            setHead(node);
            return node.value;
        }
        return -1;
    }
    
    private void setHead(LRUNode node) {
        node.next = head;
        node.pre = null;
        if (head != null) {
            head.pre = node;
        }
        head = node;
        if (tail == null) {
            tail = head;
        }
    }
    
    private void removeNode(LRUNode node) {
        if (node.pre != null) {
            node.pre.next = node.next;
        } else {
            head = node.next;
        }
        
        if (node.next != null) {
            node.next.pre = node.pre;
        } else {
            tail = node.pre;
        }
    }
    
    private void put(int key, int value) {
        if (map.containsKey(key)) {
            LRUNode old = map.get(key);
            old.value = value;
            removeNode(old);
            setHead(old);
        } else {
            LRUNode created = new LRUNode(key, value);
            if(map.size() >= capacity) {
                map.remove(tail.key);
                removeNode(tail);
            }
            setHead(created);
            map.put(key, created);
        }
    }
    
    
}

class LRUNode {
    int key, value;
    LRUNode pre, next;
    public LRUNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}