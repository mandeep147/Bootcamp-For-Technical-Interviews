/**
 * GraphNode
 */
package chapter15.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mandeep
 */
class GraphNode {
    int data;
    List<GraphNode> neighbors;
    State state;

    public GraphNode(int data) {
        super();
        this.data = data;
        state = State.UNVISITED;
        neighbors = new ArrayList<>();
    }

    public void addNeighbors(GraphNode... nodes) {
        neighbors.addAll(Arrays.asList(nodes));
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public List<GraphNode> getNeighbors() {
        return neighbors;
    }

    public void addNeighbor(GraphNode node) {
        neighbors.add(node);
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}