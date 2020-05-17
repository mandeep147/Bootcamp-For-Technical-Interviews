/**
 * BFSLevelOrder: Print Graph in Level Order: Given a graph and a node N, print the Graph in order of distance
 * from N. Each level should be in a new line.
 */
package com.chapter15.graphs;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author mandeep
 */
public class BFSLevelOrder {

    public static void main(String args[]) {
        GraphNode n1 = new GraphNode(1);
        GraphNode n2 = new GraphNode(2);
        GraphNode n3 = new GraphNode(3);
        GraphNode n4 = new GraphNode(4);
        GraphNode n5 = new GraphNode(5);
        GraphNode n6 = new GraphNode(6);
        GraphNode n7 = new GraphNode(7);
        GraphNode n8 = new GraphNode(8);

        n1.addNeighbors(n2, n3);
        n2.addNeighbors(n4, n5);
        n3.addNeighbors(n6, n7);
        n7.addNeighbors(n8);

        Graph g = new Graph(Arrays.asList(n1, n2, n3, n4, n5, n6, n7, n8));
        printInLevelOrder(g);
    }

    public static void printInLevelOrder(Graph graph) {
        for (GraphNode node : graph.getNodes()) {
            if (node.getState() != State.UNVISITED) {
                continue;
            }
//            printLevels(node);
            printWithQueues(node);
        }
    }

    //using marker
    public static void printLevels(GraphNode node) {
        Queue<GraphNode> queue = new LinkedList<>();
        queue.add(node);
        queue.add(new GraphNode(0)); // Using 0 as marker nodes.
        node.setState(State.VISITING);
        System.out.println(node.data);

        while (!queue.isEmpty()) {
            GraphNode n = queue.remove();
            if (n.data == 0 && !queue.isEmpty()) { // check if its a marker node.
                System.out.print("\n");
                queue.add(new GraphNode(0));
            }
            for (GraphNode node2 : n.getNeighbors()) {
                if (node2.getState() == State.UNVISITED) {
                    queue.add(node2);
                    System.out.print(node2.getData() + " ");
                }
            }
            n.setState(State.VISITED);
        }
    }

    //using 2 queues
    public static void printWithQueues(GraphNode root) {
        Queue<GraphNode> currentLevel = new LinkedList<>();
        Queue<GraphNode> nextLevel = new LinkedList<>();

        currentLevel.add(root);
        root.state = State.VISITING;
        System.out.println(root.data);
        while (!currentLevel.isEmpty()) {
            GraphNode currNode = currentLevel.remove();

            for(GraphNode neighbor: currNode.getNeighbors()) {
                if(neighbor.state == State.UNVISITED) {
                    nextLevel.add(neighbor);
                    neighbor.state = State.VISITING;
                    System.out.print(neighbor.data + " ");
                }
            }

            currNode.state = State.VISITED;

            if(currentLevel.isEmpty()) {
                System.out.println();
                currentLevel = nextLevel;
                nextLevel = new LinkedList<>();
            }

        }
    }
}


