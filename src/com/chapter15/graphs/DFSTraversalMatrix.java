/**
 * DFS
 */
package com.chapter15.graphs;

import java.util.ArrayList;
import java.util.List;

import static com.utils.Utils.printInput;
import static com.utils.Utils.printSameLine;

/**
 * @author mandeep
 */
public class DFSTraversalMatrix {
    private static List<Node> nodes = new ArrayList<>();

    public static void main(String args[]) {
        Node n4 = new Node(40);
        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(30);
        Node n6 = new Node(60);
        Node n5 = new Node(50);
        Node n7 = new Node(70);

        nodes.add(n4);
        nodes.add(n1);
        nodes.add(n2);
        nodes.add(n3);
        nodes.add(n6);
        nodes.add(n5);
        nodes.add(n7);
        int adjacency_matrix[][] = {
                { 0, 1, 1, 0, 0, 0, 0 }, // Node 1: 40
                { 0, 0, 0, 1, 0, 0, 0 }, // Node 2 :10
                { 0, 1, 0, 1, 1, 1, 0 }, // Node 3: 20
                { 0, 0, 0, 0, 1, 0, 0 }, // Node 4: 30
                { 0, 0, 0, 0, 0, 0, 1 }, // Node 5: 60
                { 0, 0, 0, 0, 0, 0, 1 }, // Node 6: 50
                { 0, 0, 0, 0, 0, 0, 0 }, // Node 7: 70
        };

        printInput("DFS:" );
        searchDFS(adjacency_matrix, n4);
    }

    /**
     * Complexity: O(V+E)
     *
     * @param adjacency_matrix int[][] matrix
     * @param root Node
     */
    private static void searchDFS(int[][] adjacency_matrix, Node root) {
        printSameLine(root.data + " ");
        List<Node> neighbors = findNeighbors(adjacency_matrix, root);

        for (Node node : neighbors) {
            if (node != null && !node.visited) {
                searchDFS(adjacency_matrix, node);
                node.visited = true;
            }
        }
    }

    private static List<Node> findNeighbors(int[][] adjacency_matrix, Node root) {
        List<Node> neighbors = new ArrayList<>();
        int index = -1;

        for(int i = 0; i < nodes.size(); i++) {
            if(nodes.get(i).equals(root)) {
                index = i;
                break;
            }
        }

        if(index != -1) {
            for(int i = 0; i < adjacency_matrix[index].length; i++) {
                if(adjacency_matrix[index][i] == 1) {
                    neighbors.add(nodes.get(i));
                }
            }
        }

        return neighbors;
    }
}

class Node {
    int data;
    boolean visited;

    Node(int data) {
        this.data = data;
    }
}
