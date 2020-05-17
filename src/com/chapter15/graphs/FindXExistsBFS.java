/**
 * FindXExistsBFS: undirected graph
 *
 * Given a graph and a target number T, find T exists in the graph.
 */
package com.chapter15.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Follow IC pattern here onwards
 * @author mandeep
 */
public class FindXExistsBFS {
    private static List<GraphNode> nodes = new ArrayList<>();

    public static void main(String args[]) {
        GraphNode n1 = new GraphNode(1);
        GraphNode n2 = new GraphNode(2);
        GraphNode n3 = new GraphNode(3);
        GraphNode n4 = new GraphNode(4);
        GraphNode n5 = new GraphNode(5);
        GraphNode n6 = new GraphNode(6);

        nodes.add(n1);
        nodes.add(n2);
        nodes.add(n3);
        nodes.add(n4);
        nodes.add(n5);
        nodes.add(n6);
        Graph g = new Graph(nodes);
        System.out.println(bfs(g, 7));
    }

    public static boolean bfs(Graph graph, int target) {
        for(GraphNode node: graph.getNodes()) {
            if(node.state == State.UNVISITED && bfsSearch(node, target))
                return true;
        }
        return false;
    }

    public static boolean bfsSearch(GraphNode node, int target) {
        Queue<GraphNode> que = new LinkedList<>();
        que.add(node);

        while(!que.isEmpty()) {
            GraphNode current = que.remove();
            if(current.data == target) {
                return true;
            }

            for(GraphNode neighbor: current.getNeighbors()) {
                if(neighbor.state == State.UNVISITED) {
                    que.add(neighbor);
                    neighbor.state = State.VISITING;
                }
            }
            current.state = State.VISITED;
        }
        return false;
    }
}
