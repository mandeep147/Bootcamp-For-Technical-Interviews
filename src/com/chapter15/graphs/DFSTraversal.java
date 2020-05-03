/**
 * DFSTraversal
 */
package com.chapter15.graphs;

import java.util.Iterator;
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
        DFSTraversal dfsTraversal = new DFSTraversal(4);

        addEdge(0, 1, adjacencyList);
        addEdge(0, 2, adjacencyList);
        addEdge(1, 2, adjacencyList);
        addEdge(2, 0, adjacencyList);
        addEdge(2, 3, adjacencyList);
        addEdge(3, 3, adjacencyList);

        printInput("DFS Traversal traversal: ");
        dfsTraversal.dfsTraversal(2);

    }

    /**
     * Complexity: O(V+E)
     * @param source
     */
    public void dfsTraversal(int source) {
        boolean[] visited = new boolean[numberOfVertices];
        helper(source, visited);
    }

    public void helper(int v, boolean[] visited) {
        visited[v] = true;
        printSameLine(v +" ");

        Iterator<Integer> adjVertex = adjacencyList[v].listIterator();

        while(adjVertex.hasNext()) {
            int n = adjVertex.next();
            if(!visited[n]){
                helper(n, visited);
            }
        }

    }
}
