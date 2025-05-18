package com.pranit.graph;

import java.util.List;

public record DirectedGraphNode(
        String node,
        List<DirectedEdge> connections
) {
    public void addEdge(DirectedEdge edge) {
        connections.add(edge);
    }
}
