package com.pranit.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class GraphOperations {

    static Map<GraphNode, Boolean> visitedDfs = new HashMap<>();

    static Map<GraphNode, Boolean> visitedBfs = new HashMap<>();
    static Queue<GraphNode> bfsQueue = new LinkedList<>();

    public static void main(String[] args) {
        Graph graph = createGraph();

        System.out.println("Printing DFS");
        dfs(graph);

        System.out.println("Printing BFS");
        bfs(graph);
    }

    public static void dfs(Graph graph){
        GraphNode root = graph.getVertex("0");
        dfs(root);
        System.out.println("\n");
    }

    private static void dfs(GraphNode current){
        visitedDfs.put(current, true);
        System.out.print(current.getData() + " , ");
        for(GraphNode g : current.getConnections()){
            if(!visitedDfs.containsKey(g)){
                dfs(g);
            }
        }
    }

    public static void bfs(Graph graph){
        GraphNode root = graph.getVertex("0");
        bfsQueue.add(root);
        visitedBfs.put(root, true);

        while (!bfsQueue.isEmpty()){
            GraphNode node = bfsQueue.poll();
            System.out.print(node.getData() + " , ");

            for(GraphNode g : node.getConnections()){
                if(!visitedBfs.containsKey(g)){
                    bfsQueue.add(g);
                    visitedBfs.put(g, true);
                }
            }

        }
    }

    private static Graph createGraph() {
        Graph graph = new Graph();
        graph.addVertex(new GraphNode("0"));
        graph.addVertex(new GraphNode("1"));
        graph.addVertex(new GraphNode("2"));
        graph.addVertex(new GraphNode("3"));
        graph.addVertex(new GraphNode("4"));
        graph.addVertex(new GraphNode("5"));
        graph.addVertex(new GraphNode("6"));
        /*graph.addVertex(new GraphNode("7"));
        graph.addVertex(new GraphNode("8"));
        graph.addVertex(new GraphNode("9"));
        graph.addVertex(new GraphNode("10"));
        graph.addVertex(new GraphNode("11"));
        graph.addVertex(new GraphNode("12"));*/

        graph.addEdge("0", "1");
        graph.addEdge("0", "2");
        graph.addEdge("0", "5");
        graph.addEdge("0", "6");
        graph.addEdge("6", "4");
        graph.addEdge("3", "4");
        graph.addEdge("3", "5");
        graph.addEdge("4", "5");

        /*graph.addEdge("7", "8");

        graph.addEdge("9", "10");
        graph.addEdge("9", "11");
        graph.addEdge("9", "12");
        graph.addEdge("11", "12");*/

        return graph;
    }
}
