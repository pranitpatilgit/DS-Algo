package com.pranit.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GraphNode {

    private String data;
    private List<GraphNode> connections = new ArrayList<>();

    public GraphNode(String data) {
        this.data = data;
    }

    public void addConnection(GraphNode node){
        connections.add(node);
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public List<GraphNode> getConnections() {
        return connections;
    }

}