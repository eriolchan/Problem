package TreesAndGraphs;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question_4_7Test {

    @Test
    public void testFindBuildOrder() {
        String[] projects = new String[] {
            "a", "b", "c", "d", "e", "f", "g",
        };
        
        String[][] dependencies = new String[][] {
            { "f", "c" },
            { "f", "b" },
            { "f", "a" },
            { "c", "a" },
            { "b", "a" },
            { "a", "e" },
            { "b", "e" },
            { "d", "g" },
        };
        
        String expected = "dfgcbae";
        String actual = Question_4_7.findBuildOrderByTopologicalSort(projects, dependencies);
        assertEquals(expected, actual);
        
        expected = "fdgcbae";
        actual = Question_4_7.findBuildOrderByDFS(projects, dependencies);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testFindBuildOrder_HasCycle() {
        String[] projects = new String[] {
            "a", "b", "c", "d", "e", "f", "g",
        };
        
        String[][] dependencies = new String[][] {
            { "f", "c" },
            { "f", "b" },
            { "f", "a" },
            { "c", "a" },
            { "b", "a" },
            { "a", "e" },
            { "e", "b" },
            { "d", "g" },
        };
        
        String actual = Question_4_7.findBuildOrderByTopologicalSort(projects, dependencies);
        assertNull(actual);
        
        actual = Question_4_7.findBuildOrderByDFS(projects, dependencies);
        assertNull(actual);
    }
}
