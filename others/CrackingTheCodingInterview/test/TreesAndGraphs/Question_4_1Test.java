package TreesAndGraphs;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question_4_1Test {

    @Test
    public void testHasRoute_OneRoute() {
        Graph graph = new Graph();
        graph.addEdge("a", "b");
        graph.addEdge("b", "c");
        graph.addEdge("c", "a");
        
        Node start = graph.getOrCreateNode("a");
        Node end = graph.getOrCreateNode("c");
        assertTrue(Question_4_1.hasRoute(graph, start, end));
    }
    
    @Test
    public void testHasRoute_MultipleRoutes() {
        Graph graph = new Graph();
        graph.addEdge("a", "b");
        graph.addEdge("b", "c");
        graph.addEdge("a", "c");
        
        Node start = graph.getOrCreateNode("a");
        Node end = graph.getOrCreateNode("c");
        assertTrue(Question_4_1.hasRoute(graph, start, end));
    }
    
    @Test
    public void testHasRoute_NoRoute() {
        Graph graph = new Graph();
        graph.addEdge("a", "b");
        graph.addEdge("b", "c");
        
        Node start = graph.getOrCreateNode("c");
        Node end = graph.getOrCreateNode("a");
        assertFalse(Question_4_1.hasRoute(graph, start, end));
    }
    
    @Test
    public void testHasRoute_Same() {
        Graph graph = new Graph();
        graph.addEdge("a", "b");
        graph.addEdge("b", "c");
        
        Node start = graph.getOrCreateNode("a");
        Node end = start;
        assertTrue(Question_4_1.hasRoute(graph, start, end));
    }
    
    @Test
    public void testHasRoute_Null() {
        Graph graph = null;
        Node start = new Node("a");
        Node end = new Node("b");
        assertFalse(Question_4_1.hasRoute(graph, start, end));
        
        graph = new Graph();
        graph.addEdge("a", "b");
        graph.addEdge("b", "c");
        end = null;
        assertFalse(Question_4_1.hasRoute(graph, start, end));
    }
}
