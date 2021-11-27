/**
 * Graph
 */
package graph;

import java.util.List;

/**
 * @author mandeep
 */
class Graph {
    List<GraphNode> nodes;

    public Graph(List<GraphNode> nodes) {
        this.nodes = nodes;
    }

    public List<GraphNode> getNodes() {
        return nodes;
    }

    public void addNode(GraphNode node) {
        nodes.add(node);
    }
}
