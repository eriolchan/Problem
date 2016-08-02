package TreesAndGraphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {

    private ArrayList<Node> nodes;
    
    private static StringBuilder output;
    private static HashSet<String> visited;
    
    static {
        output = new StringBuilder();
        visited = new HashSet<String>();
    }
    
    public Graph() {
        nodes = new ArrayList<Node>();
    }
    
    public void addEdge(String s, String t) {
        Node source = getNode(s);
        if (source == null) {
            source = new Node(s);
            nodes.add(source);
        }
        
        Node target = getNode(t);
        if (target == null) {
            target = new Node(t);
            nodes.add(target);
        }
        
        if (!source.getNeighbors().contains(target)) {
            source.getNeighbors().add(target);
        }
    }
    
    public Node getNode(String name) {
        for (Node node : nodes) {
            if (node.getName().equals(name)) {
                return node;
            }
        }
        
        return null;
    }
    
    public static String getResult() {
        String result = output.toString();
        output.setLength(0);
        visited.clear();
        
        return result;
    }
    
    public static void depthFirstSearch(Node root) {
        if (root == null) {
            return;
        }
        
        visit(root);
        visited.add(root.getName());
        
        for (Node node : root.getNeighbors()) {
            if (!visited.contains(node.getName())) {
                depthFirstSearch(node);
            }
        }
    }
    
    public static void breadthFirstSearch(Node root) {
        if (root == null) {
            return;
        }
        
        Queue<Node> queue = new LinkedList<Node>();
        visited.add(root.getName());
        queue.add(root);
        
        while (!queue.isEmpty()) {
            Node current = queue.remove();
            visit(current);
            
            for (Node node : current.getNeighbors()) {
                if (!visited.contains(node.getName())) {
                    visited.add(node.getName());
                    queue.add(node);
                }
            }
        }
    }
    
    private static void visit(Node node) {
        output.append(node.getName());
    }
}

class Node {
    private String name;
    private ArrayList<Node> neighbors;
    
    public Node(String name) {
        this.name = name;
        neighbors = new ArrayList<Node>();
    }
    
    public String getName() {
        return name;
    }
    
    public ArrayList<Node> getNeighbors() {
        return neighbors;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (!(obj instanceof Node)) {
            return false;
        }
        
        final Node other = (Node)obj;
        
        return this.name.equals(other.getName());
    }
    
    @Override
    public int hashCode() {
        return name.hashCode();
    }
}