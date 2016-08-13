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
    
    public static String findBuildOrderByDFS(String[] projects, String[][] dependencies) {
        Graph graph = buildGraph(projects, dependencies);
    }
    
    private static boolean findBuildOrderByDFSRecursively(Node project, Stack<String> stack, HashMap<String, Status> status) {
        if (status.get(project) == Status.VISITING) {
            return false;
        }
        
        for (Node node : )
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
