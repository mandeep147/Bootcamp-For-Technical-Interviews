package util;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Utils {
    public static <T> void printArray(T[] arr) {
        for (T element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
    
    public static <T> void printArrayToIndex(T[] arr, int index) {
        for (int i = 0; i < index; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    public static <T> void printList(List<T> arr) {
        for (T element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
    
    public static <T> void printInput(T inputString) {
        System.out.println(inputString);
    }
    
    public static <T> void printSameLine(T input) {
        System.out.print(input);
    }
    
    public static <T> void print2DMatrix(T[][] input) {
        for (T[] ts : input) {
            for (T t : ts) {
                printSameLine(t + " ");
            }
            printInput("");
        }
    }
    
    public static <T> void swap(T[] arr, int start, int end) {
        T temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
    
    public static void addEdge(int v, int w, LinkedList<Integer> adj[]) {
        adj[v].add(w);
    }
    
    public static <T> boolean checkIfArrayIsNull(T[] arr) {
        return arr == null || arr.length == 0;
    }
    
    public static int returnMid(int start, int end) {
        return start + (end - start) / 2;
    }
    
    public static Stack<Integer> createStack() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(10);
        stack.push(11);
        stack.push(12);
        stack.push(2);
        stack.push(31);
        stack.push(51);
        return stack;
    }
    
    public static class EmptyQueueException extends Exception {
        public EmptyQueueException() {
        }
    }
    
    public static class FullQueueException extends Exception {
        public FullQueueException(){}
    }
    
    public static class StackFullException extends Exception {
        public StackFullException() {
        }
    }
    
    public static class StackEmptyException extends Exception {
        public StackEmptyException() {
        }
    }
}
