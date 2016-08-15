package TreesAndGraphs;

import java.util.HashMap;
import java.util.Stack;

/**
 * Question 4.7
 * You are given a list of projects and a list of dependencies (which is a list of pairs of
 * projects, where the first project is dependent on the second project). All of a project's
 * dependencies must be built before the project is. Find a build order that will allow the projects
 * to be built. If there is no valid build order, return an error.
 */
public class Question_4_7 {

    // O(v+e)
    public static String findBuildOrderByTopologicalSort(String[] projects, String[][] dependencies) {
        Graph graph = buildGraph(projects, dependencies);
        
        return Graph.topologicalSort(graph) ? Graph.getResult() : null;
    }
    
    // O(v+e)
    public static String findBuildOrderByDFS(String[] projects, String[][] dependencies) {
        Graph graph = buildGraph(projects, dependencies);
        
        HashMap<String, Status> status = new HashMap<String, Status>();
        for (String project : projects) {
            status.put(project, Status.NONE);
        }
        
        Stack<String> stack = new Stack<String>();
        for (Node node : graph.getNodes()) {
            if (status.get(node.getName()) == Status.NONE) {
                if (!findBuildOrderByDFSRecursively(node, stack, status)) {
                    return null;
                }
            }
        }
        
        return getResult(stack);
    }
    
    private static boolean findBuildOrderByDFSRecursively(Node node, Stack<String> stack, HashMap<String, Status> status) {
        if (status.get(node.getName()) == Status.VISITING) {
            return false;
        }
        
        if (status.get(node.getName()) == Status.NONE) {
            status.put(node.getName(), Status.VISITING);
            for (Node neighbor : node.getNeighbors()) {
                if (!findBuildOrderByDFSRecursively(neighbor, stack, status)) {
                    return false;
                }
            }
            
            status.put(node.getName(), Status.VISITED);
            stack.push(node.getName());
        }
        
        return true;
    }
    
    private static String getResult(Stack<String> stack) {
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        
        return result.toString();
    }
    
    private static Graph buildGraph(String[] projects, String[][] dependencies) {
        Graph graph = new Graph();
        
        for (String project : projects) {
            graph.getOrCreateNode(project);
        }
        
        for (String[] dependency : dependencies) {
            graph.addEdge(dependency[0], dependency[1]);
        }
        
        return graph;
    }
    
    private enum Status {
        NONE,
        VISITING,
        VISITED,
    }
}
