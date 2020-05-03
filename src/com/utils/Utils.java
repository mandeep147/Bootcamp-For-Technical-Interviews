package com.utils;

import java.util.LinkedList;
import java.util.List;

public class Utils {
    public static <T> void printArray(T[]  arr) {
        for(T element : arr){
            System.out.print(element+" ");
        }
        System.out.println();
    }

    public static <T> void printList(List<T> arr) {
        for(T element : arr){
            System.out.print(element+" ");
        }
        System.out.println();
    }

    public static <T> void printInput(T inputString) {
        System.out.println(inputString);
    }

    public static <T> void printSameLine(T input) {
        System.out.print(input);
    }

    public static void swap(Integer[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    public static void addEdge(int v, int w, LinkedList<Integer> adj[]){
        adj[v].add(w);
    }
}
