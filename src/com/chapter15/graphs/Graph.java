/**
 * Graph
 */
package com.chapter15.graphs;

import java.util.List;

/**
 * @author mandeep
 */
public class Graph {
    List<Node> nodes;

    public Graph(List<Node> nodes) {
        this.nodes = nodes;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }
}
