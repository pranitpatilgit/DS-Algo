package com.pranit.graph;

import java.util.HashMap;
import java.util.Map;

public class Graph {

    private Map<String, GraphNode> vertices = new HashMap();

    public Map<String, GraphNode> getVertices() {
        return vertices;
    }

    public void addVertex(GraphNode node){
        vertices.put(node.getData(), node);
    }

    public void addEdge(String g1, String g2){
        addEdge(vertices.get(g1), vertices.get(g2));
    }

    public void addEdge(GraphNode g1, GraphNode g2){
        g1.addConnection(g2);
        g2.addConnection(g1);
    }

    public GraphNode getVertex(String data){
        return vertices.get(data);
    }
}
