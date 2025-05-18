package com.pranit.graph;

import java.util.*;

public class DijktrasSPA {
    private DirectedGraph graph;
    private Map<String, PathDistance> distances = new HashMap<>();
    private PriorityQueue<DistanceFromSource> edgeQueue = getEdgeQueue();
    
    public static void main(String[] args) {
        DijktrasSPA spa = new DijktrasSPA();
        spa.graph = spa.createGraph();
        
        spa.run(spa.graph, "0");

        System.out.println(spa.distances.toString().replaceAll("],", "],\n"));
    }
    
    public void run(DirectedGraph graph, String src) {
        DirectedGraphNode source = graph.getVertex(src);
        
        //Setup distances
        for (DirectedGraphNode vertex : graph.getAllVertexes()){
            if (vertex != source)
                distances.put(vertex.node(), new PathDistance(Double.POSITIVE_INFINITY, null));
            else 
                distances.put(vertex.node(), new PathDistance(0, null));
        }
        
        edgeQueue.add(new DistanceFromSource(source.node(), 0.0));
        
        while (!edgeQueue.isEmpty()) {
            DirectedGraphNode currentProcessingNode = graph.getVertex(edgeQueue.poll().vertex());
            for (DirectedEdge edge :  currentProcessingNode.connections()) {
                relax(edge);
            }
        }
    }
    
    public void relax(DirectedEdge edge) {
        if (distances.get(edge.to()).distance() > distances.get(edge.from()).distance() + edge.weight() ) {
            double newDistance = distances.get(edge.from()).distance() + edge.weight();
            distances.put(edge.to(), new PathDistance(
                    newDistance,
                    edge
            ));

            DistanceFromSource to = new DistanceFromSource(edge.to(), newDistance);
            if (edgeQueue.contains(to)) {
                edgeQueue.remove(to);
                edgeQueue.add(to);
            } else {
                edgeQueue.add(new DistanceFromSource(edge.to(), newDistance));
            }
        }
    }
    
    private static PriorityQueue<DistanceFromSource> getEdgeQueue() {
        return new PriorityQueue<>(new Comparator<DistanceFromSource>() {
            @Override
            public int compare(DistanceFromSource o1, DistanceFromSource o2) {
                if (o1.distance() > o2.distance())
                    return 1;
                else if (o1.distance() < o2.distance())
                    return -1;

                return 0;
            }
        });
    }

    public DirectedGraph createGraph(){
        DirectedGraph graph = new DirectedGraph();
        graph.addVertex("0");
        graph.addVertex("1");
        graph.addVertex("2");
        graph.addVertex("3");
        graph.addVertex("4");
        graph.addVertex("5");
        graph.addVertex("6");
        graph.addVertex("7");
        
        graph.addEdge(new DirectedEdge("0", "1", 5.0));
        graph.addEdge(new DirectedEdge("0", "4", 9.0));
        graph.addEdge(new DirectedEdge("0", "7", 8.0));
        graph.addEdge(new DirectedEdge("1", "2", 12.0));
        graph.addEdge(new DirectedEdge("1", "3", 15.0));
        graph.addEdge(new DirectedEdge("1", "7", 4.0));
        graph.addEdge(new DirectedEdge("2", "3", 3.0));
        graph.addEdge(new DirectedEdge("2", "6", 11.0));
        graph.addEdge(new DirectedEdge("3", "6", 9.0));
        graph.addEdge(new DirectedEdge("4", "5", 4.0));
        graph.addEdge(new DirectedEdge("4", "6", 20.0));
        graph.addEdge(new DirectedEdge("4", "7", 5.0));
        graph.addEdge(new DirectedEdge("5", "2", 1.0));
        graph.addEdge(new DirectedEdge("5", "6", 13.0));
        graph.addEdge(new DirectedEdge("7", "5", 6.0));
        graph.addEdge(new DirectedEdge("7", "2", 7.0));
        
        return graph;
    }
}

record PathDistance(double distance, DirectedEdge path){}
record DistanceFromSource(String vertex, double distance){
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        DistanceFromSource that = (DistanceFromSource) o;
        return Objects.equals(vertex, that.vertex);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(vertex);
    }
}
