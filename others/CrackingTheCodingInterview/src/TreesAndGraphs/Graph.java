package TreesAndGraphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {

    private ArrayList<Node> nodes;
    private HashMap<String, Node> map;
    
    private static StringBuilder output;
    private static HashSet<String> visited;
    
    static {
        output = new StringBuilder();
        visited = new HashSet<String>();
    }
    
    public Graph() {
        nodes = new ArrayList<Node>();
        map = new HashMap<String, Node>();
    }
    
    public Node getOrCreateNode(String name) {
        if (!map.containsKey(name)) {
            Node node = new Node(name);
            nodes.add(node);
            map.put(name, node);
        }
        
        return map.get(name);
    }
    
    public void addEdge(String s, String e) {
        addEdge(s, e, 0);
    }
    
    public void addEdge(String s, String e, int weight) {
        Node start = getOrCreateNode(s);
        Node end = getOrCreateNode(e);
        start.AddNeighbor(end, weight);
    }
    
    public ArrayList<Node> getNodes() {
        return nodes;
    }
    
    public static String getResult() {
        String result = output.toString();
        output.setLength(0);
        visited.clear();
        
        return result;
    }
    
    // O(n)
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
    
    // O(n)
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
    
    // O(v+e)
    public static boolean topologicalSort(Graph graph) {
        if (graph == null) {
            return false;
        }
        
        Queue<Node> processNext = new LinkedList<Node>();
        for (Node node : graph.getNodes()) {
            if (node.getInbound() == 0) {
                processNext.add(node);
            }
        }
        
        Queue<Node> order = new LinkedList<Node>();
        while (!processNext.isEmpty()) {
            Node node = processNext.remove();
            order.add(node);
            
            for (Node neighbor : node.getNeighbors()) {
                neighbor.decreaseInbound();
                if (neighbor.getInbound() == 0) {
                    processNext.add(neighbor);
                }
            }
        }
        
        if (order.size() != graph.getNodes().size()) {
            return false;
        }
        
        while (!order.isEmpty()) {
            visit(order.remove());
        }
        
        return true;
    }
    
    // O(v^2)
    public static int dijkstraShortestPath(Graph graph, String start, String end) {
        HashMap<String, String> previous = new HashMap<String, String>();
        HashMap<String, Integer> pathWeights = initializePathWeights(graph, start);
        
        HashSet<String> remaining = new HashSet<String>();
        for (String key : pathWeights.keySet()) {
            remaining.add(key);
        }
        
        while (!remaining.isEmpty()) {
            String name = getMinWeight(remaining, pathWeights);
            if (name == null) {
                break;
            }
            
            Node min = graph.getOrCreateNode(name);
            for (Node node : min.getNeighbors()) {
                if (remaining.contains(node.getName())) {
                    int weight = pathWeights.get(name) + min.getWeight(node.getName());
                    if (weight < pathWeights.get(node.getName())) {
                        pathWeights.put(node.getName(), weight);
                        previous.put(node.getName(), name);
                    }
                }
            }
            
            remaining.remove(name);
        }
        
        int weight = pathWeights.get(end);
        if (weight != Integer.MAX_VALUE) {
            constructPath(previous, end);
        }
        
        return weight;
    }
    
    private static void constructPath(HashMap<String, String> previous, String end) {
        if (!previous.containsKey(end)) {
            output.append(end);
            return;
        }
        
        constructPath(previous, previous.get(end));
        output.append(end);
    }
    
    private static HashMap<String, Integer> initializePathWeights(Graph graph, String start) {
        HashMap<String, Integer> pathWeights = new HashMap<String, Integer>();
        for (Node node : graph.getNodes()) {
            pathWeights.put(node.getName(), Integer.MAX_VALUE);
        }
        
        pathWeights.put(start, 0);
        
        return pathWeights;
    }
    
    private static String getMinWeight(HashSet<String> remaining, HashMap<String, Integer> pathWeights) {
        String name = null;
        int minWeight = Integer.MAX_VALUE;
        
        for (String s : remaining) {
            int weight = pathWeights.get(s);
            if (weight < minWeight) {
                minWeight = weight;
                name = s;
            }
        }
        
        return name;
    }
    
    private static void visit(Node node) {
        output.append(node.getName());
    }
}

class Node {
    private String name;
    private int inbound;
    private ArrayList<Node> neighbors;
    private HashMap<String, Node> map;
    private HashMap<String, Integer> weights;
    
    public Node(String name) {
        this.name = name;
        inbound = 0;
        neighbors = new ArrayList<Node>();
        map = new HashMap<String, Node>();
        weights = new HashMap<String, Integer>();
    }
    
    public String getName() {
        return name;
    }
    
    public int getInbound() {
        return inbound;
    }
    
    public ArrayList<Node> getNeighbors() {
        return neighbors;
    }
    
    public void AddNeighbor(Node target, int weight) {
        String name = target.getName();
        if (!map.containsKey(name)) {
            map.put(name, target);
            neighbors.add(target);
            weights.put(name, weight);
            target.increaseInbound();
        }
    }
    
    public int getWeight(String target) {
        if (!weights.containsKey(target)) {
            return Integer.MAX_VALUE;
        }
        
        return weights.get(target);
    }
    
    public void increaseInbound() {
        ++inbound;
    }
    
    public void decreaseInbound() {
        --inbound;
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
        
        return this.name.equals(other.name);
    }
    
    @Override
    public int hashCode() {
        return name.hashCode();
    }
}