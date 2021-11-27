/**
 * SmallestSubstringWithAllCharacters
 * Let's say you are given a large text document Doc.
 * You are also given a set S of words.
 * You want to find the smallest substring of Doc that contains all the words in S.
 * For example:
 * S: ["and", "of", "one"]
 * Doc: "a set of words that is complete in itself, typically containing a subject and predicate, conveying a statement, question, exclamation, or command, and consisting of a main clause and sometimes one or more subordinate clauses"
 * Ans: "of a main clause and sometimes are"
 *
 * Note: order in which words appear does not matter
 * Length of substring: number of characters (doh)
 */
package linkedlists;

import java.util.*;

import static util.Utils.printInput;

/**
 * @author mandeep
 */
public class SmallestSubstringWithAllCharacters {
    
    public static void main(String[] args) {
        String doc = "one of the car and bike and one of those";
        printInput(smallestSubstring(new String[]{}, doc));
        printInput(smallestSubstring(new String[]{"and", "of", "one"}, doc));
    }
    
    /**
     * substring can contain a word multiple times, assume input in all lowercase
     * assume input has no duplicates, ignore punctuation
     * Time: O(len of doc)
     * Space: O(len of doc)
     * ** store starting index of word in doc in LinkedHashTable,
     * calculate length of string once map.size == length of words[], using index_of_word_last_in_map - index_of_word_0_in_map + length(last word in map)
     * update map if new length of substring is smaller than the current running length
     * @param input
     * @param doc
     * @return
     */
    private static String smallestSubstring(String[] input, String doc) {
        String res = null;
        Map<String, NodePrev> map = new HashMap<>();
        Set<String> wordSet = new HashSet<>(Arrays.asList(input));
        LinkedListWord list = new LinkedListWord();
        WordIterator iter = new WordIterator(doc);
        while(iter.hasNext()) {
            WordIndex wordIndex = iter.next();
            String word = wordIndex.getWord();
            if(!wordSet.contains(word)) {
                continue;
            }
            
            if(map.containsKey(word)) {
                NodePrev deleteNode = map.get(word);
                list.delete(deleteNode);
            }
            NodePrev node = new NodePrev(word, wordIndex.getIndex());
            list.append(node);
            map.put(word, node);
            
            if(map.size() == wordSet.size()) {
                int startIndex = list.head.getIndex();
                int endIndex = list.tail.getIndex() + list.tail.getWord().length() - 1;
                if (res == null || (endIndex - startIndex + 1) < res.length()) {
                    res = doc.substring(startIndex, endIndex + 1);
                }
            }
        }
        return res;
    }
}

class WordIndex {
    String word;
    int index;
    
    public WordIndex(String word, int index) {
        super();
        this.word = word;
        this.index = index;
    }
    
    public String getWord() {
        return word;
    }
    
    public int getIndex() {
        return index;
    }
}

/**
 * position variable will always be at the start of the next word in the string
 */
class WordIterator implements Iterator<WordIndex> {
    String str;
    int position;
    
    public WordIterator(String str) {
        this.str = str.trim();
        this.position = 0;
        advanceToNextAlphabet();
    }
    
    private void advanceToNextAlphabet() {
        while(position < str.length() && !Character.isAlphabetic(str.charAt(position))) {
            position++;
        }
    }
    
    @Override
    public boolean hasNext(){
        return position < str.length();
    }
    
    @Override
    public WordIndex next() {
        if(!hasNext()) {
            return  null;
        }
        int wordStartIndex = position;
        while (position < str.length() && Character.isAlphabetic(str.charAt(position))) {
            position++;
        }
        int wordEndIndex = position - 1;
        advanceToNextAlphabet();
        return new WordIndex(str.substring(wordStartIndex, wordEndIndex + 1), wordStartIndex);
    }
}

class LinkedListWord {
    NodePrev head;
    NodePrev tail;
    public LinkedListWord() {
        head = null;
        tail = null;
    }
    
    public void append(NodePrev node) {
        if (head == null) {
            head = node;
        } else {
            tail.next = node;
            node.prev = tail;
        }
        tail = node;
    }
    
    public void delete(NodePrev node) {
        if (node == null) {
            return;
        }
        if(node.prev != null) {
            node.prev.next = node.next;
        }
        if(node.next != null) {
            node.next.prev = node.prev;
        }
        
        if(node == tail) {
            tail = node.prev;
        }
        
        if (node == head) {
            head = node.next;
        }
    }
}

class NodePrev {
    NodePrev next;
    NodePrev prev;
    String word;
    int index;
    public NodePrev(String word, int index) {
        super();
        this.word = word;
        this.index = index;
    }
    
    public String getWord() {
        return word;
    }
    
    public int getIndex() {
        return index;
    }
}