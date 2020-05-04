/**
 * DFSTraversal
 */
package com.chapter15.graphs;

import java.util.LinkedList;

import static com.utils.Utils.*;

/**
 * @author mandeep
 */
public class DFSTraversal {
    private int numberOfVertices;
    private static LinkedList<Integer> adjacencyList[];

    public DFSTraversal(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;

        adjacencyList = new LinkedList[numberOfVertices];
        for(int i = 0; i < numberOfVertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public static void main(String args[]) {
        int vertices = 4;
        int source = 2;
        DFSTraversal dfsTraversal = new DFSTraversal(vertices);

        addEdge(0, 1, adjacencyList);
        addEdge(0, 2, adjacencyList);
        addEdge(1, 2, adjacencyList);
        addEdge(2, 0, adjacencyList);
        addEdge(2, 3, adjacencyList);
        addEdge(3, 3, adjacencyList);

        printInput("DFS Traversal traversal: ");
        dfsTraversal.dfsTraversal(source);

    }

    /**
     * Complexity: O(V+E)
     * @param source int value
     */
    private void dfsTraversal(int source) {
        boolean[] visited = new boolean[numberOfVertices];
        helper(source, visited);
    }

    private void helper(int v, boolean[] visited) {
        visited[v] = true;
        printSameLine(v +" ");

        for (Integer n : adjacencyList[v]) {
            if (!visited[n]) {
                helper(n, visited);
            }
        }

    }
}
