package TreesAndGraphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Question 4.1
 * Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
 */
public class Question_4_1 {

    public static boolean hasRoute(Graph graph, Node start, Node end) {
        if (graph == null || start == null || end == null) {
            return false;
        }
        
        if (start == end) {
            return true;
        }
        
        HashSet<String> visited = new HashSet<String>();
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(start);
        visited.add(start.getName());
        
        while (!queue.isEmpty()) {
            Node current = queue.remove();
            for (Node node : current.getNeighbors()) {
                if (!visited.contains(node.getName())) {
                    if (node == end) {
                        return true;
                    } else {
                        queue.add(node);
                        visited.add(node.getName());
                    }
                }
            }
        }
        
        return false;
    }
}
