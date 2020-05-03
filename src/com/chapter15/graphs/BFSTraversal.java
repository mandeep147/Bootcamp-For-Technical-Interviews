/**
 * BFSTraversal
 */
package com.chapter15.graphs;

import java.util.Iterator;
import java.util.LinkedList;

import static com.utils.Utils.*;

/**
 * @author mandeep
 */
public class BFSTraversal {
    private int numberOfVertices;
    private static LinkedList<Integer> adjacencyList[];

    public BFSTraversal(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;

        adjacencyList = new LinkedList[numberOfVertices];
        for(int i = 0; i < numberOfVertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public static void main(String args[]) {
        BFSTraversal bfsTraversal = new BFSTraversal(4);

        addEdge(0, 1, adjacencyList);
        addEdge(0, 2, adjacencyList);
        addEdge(1, 2, adjacencyList);
        addEdge(2, 0, adjacencyList);
        addEdge(2, 3, adjacencyList);
        addEdge(3, 3, adjacencyList);

        printInput("BFS Traversal traversal from vertex 2: ");
        bfsTraversal.bfsTraversal(2);
    }

    /**
     * Complexity: O(V+E)
     *
     * @param source
     */
    public void bfsTraversal(int source) {
        boolean[] visited = new boolean[this.numberOfVertices];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[source] = true; //mark source visited
        queue.add(source);

        while(queue.size() > 0) {
            source = queue.poll();
            printSameLine(source + " ");

            Iterator<Integer> adjVertex = adjacencyList[source].listIterator();

            while (adjVertex.hasNext()) {
                int n = adjVertex.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
}
