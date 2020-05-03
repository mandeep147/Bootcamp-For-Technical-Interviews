/**
 * Node
 */
package com.chapter15.graphs;

import java.util.List;

/**
 * @author mandeep
 */
public class Node {
    List<Node> neighbors;
    int data;

    public Node(List<Node> neighbors, int data) {
        this.neighbors = neighbors;
        this.data = data;
    }

    public List<Node> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(List<Node> neighbors) {
        this.neighbors = neighbors;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
