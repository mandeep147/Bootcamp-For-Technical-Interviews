/**
 * BFSTraversal
 */
package graph;

import java.util.LinkedList;

import static util.Utils.*;

/**
 * @author mandeep
 */
public class BFSTraversal {
    private static LinkedList<Integer> adjacencyList[];
    private int numberOfVertices;

    public BFSTraversal(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;

        adjacencyList = new LinkedList[numberOfVertices];
        for(int i = 0; i < numberOfVertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public static void main(String args[]) {
        int vertices = 4;
        int source = 2;
        BFSTraversal bfsTraversal = new BFSTraversal(vertices);

        addEdge(0, 1, adjacencyList);
        addEdge(0, 2, adjacencyList);
        addEdge(1, 2, adjacencyList);
        addEdge(2, 0, adjacencyList);
        addEdge(2, 3, adjacencyList);
        addEdge(3, 3, adjacencyList);

        printInput("BFS Traversal traversal from vertex 2: ");
        bfsTraversal.bfsTraversal(source);
    }

    /**
     * Complexity: O(V+E)
     *
     * @param source int value
     */
    private void bfsTraversal(int source) {
        boolean[] visited = new boolean[this.numberOfVertices];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[source] = true; //mark source visited
        queue.add(source);

        while(queue.size() > 0) {
            source = queue.poll();
            printSameLine(source + " ");

            for (Integer n : adjacencyList[source]) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
}
