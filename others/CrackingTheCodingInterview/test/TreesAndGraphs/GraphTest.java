package TreesAndGraphs;

import static org.junit.Assert.*;

import org.junit.Test;

public class GraphTest {

    @Test
    public void testGraphSearch() {
        Graph graph = new Graph();
        graph.addEdge("a", "b");
        graph.addEdge("a", "e");
        graph.addEdge("a", "f");
        graph.addEdge("b", "d");
        graph.addEdge("b", "e");
        graph.addEdge("c", "b");
        graph.addEdge("d", "c");
        graph.addEdge("d", "e");
        
        Node root = graph.getNode("a");
        Graph.depthFirstSearch(root);
        assertEquals("abdcef", Graph.getResult());
        
        Graph.breadthFirstSearch(root);
        assertEquals("abefdc", Graph.getResult());
    }

}
