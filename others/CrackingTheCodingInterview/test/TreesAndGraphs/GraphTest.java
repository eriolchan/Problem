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
        
        assertFalse(Graph.topologicalSort(graph));
    }
    
    @Test
    public void testTopologicalSort() {
        Graph graph = new Graph();
        graph.addEdge("a", "b");
        graph.addEdge("a", "d");
        graph.addEdge("b", "c");
        graph.addEdge("c", "d");
        graph.addEdge("c", "e");
        graph.addEdge("d", "e");
        graph.addEdge("f", "e");
        
        assertTrue(Graph.topologicalSort(graph));
        assertEquals("afbcde", Graph.getResult());
    }
    
    @Test
    public void testDijkstraShortestPath() {
        Graph graph = new Graph();
        graph.addEdge("a", "b", 5);
        graph.addEdge("a", "c", 3);
        graph.addEdge("a", "e", 2);
        graph.addEdge("b", "d", 2);
        graph.addEdge("c", "b", 1);
        graph.addEdge("c", "d", 1);
        graph.addEdge("d", "a", 1);
        graph.addEdge("d", "g", 2);
        graph.addEdge("d", "h", 1);
        graph.addEdge("e", "a", 1);
        graph.addEdge("e", "h", 4);
        graph.addEdge("e", "i", 7);
        graph.addEdge("f", "b", 3);
        graph.addEdge("f", "g", 1);
        graph.addEdge("g", "c", 3);
        graph.addEdge("g", "i", 2);
        graph.addEdge("h", "c", 2);
        graph.addEdge("h", "f", 2);
        graph.addEdge("h", "g", 2);
        
        assertEquals(8, Graph.dijkstraShortestPath(graph, "a", "i"));
        assertEquals("acdgi", Graph.getResult());
        
        assertEquals(5, Graph.dijkstraShortestPath(graph, "e", "b"));
        assertEquals("eacb", Graph.getResult());
        
        assertEquals(Integer.MAX_VALUE, Graph.dijkstraShortestPath(graph, "i", "a"));
    }
}
