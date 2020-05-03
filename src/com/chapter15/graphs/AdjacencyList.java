/**
 * AdjacencyList
 */
package com.chapter15.graphs;

import java.util.LinkedList;

/**
 * @author mandeep
 */
public class AdjacencyList {

    private int numVertices;
    private LinkedList<Integer> adjLists[];

    public static void main(String args[]) {
        AdjacencyList graph = new AdjacencyList(4);
        graph.addEdge(1, 2);
        graph.addEdge(2, 2);
        graph.addEdge(3, 2);
        graph.addEdge(4, 2);
    }

    public void addEdge(int u, int v) {
        this.adjLists[u].add(v);
    }


    AdjacencyList(int vertices) {
        numVertices = vertices;
        adjLists = new LinkedList[vertices];

        for (int i = 0; i < vertices; i++)
            adjLists[i] = new LinkedList();
    }
}
