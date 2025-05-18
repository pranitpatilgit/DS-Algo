package com.pranit.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DirectedGraph {
    private Map<String, DirectedGraphNode> vertexes = new HashMap<>();
    private List<DirectedEdge> edges = new ArrayList<>();
    
    public void addEdge(DirectedEdge edge) {
        edges.add(edge);
        vertexes.get(edge.from()).addEdge(edge);
    }
    
    public void addVertex(String vertex) {
        vertexes.put(vertex, new DirectedGraphNode(vertex, new ArrayList<>()));
    }
    
    public DirectedGraphNode getVertex(String name) {
        return vertexes.get(name);
    }
    
    public List<DirectedGraphNode> getAllVertexes() {
        return vertexes.values().stream().toList();
    }
}
