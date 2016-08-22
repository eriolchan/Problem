package RecursionAndDynamicProgramming;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class Question_8_2Test {

    @Test
    public void testGetPath_NoLimit() {
        boolean[][] maze = new boolean[4][4];
        for (boolean[] row : maze) {
            Arrays.fill(row, true);
        }
        
        ArrayList<Point> expected = new ArrayList<Point>();
        expected.add(new Point(0,0));
        expected.add(new Point(0,1));
        expected.add(new Point(0,2));
        expected.add(new Point(0,3));
        expected.add(new Point(1,3));
        expected.add(new Point(2,3));
        expected.add(new Point(3,3));
        ArrayList<Point> actual = Question_8_2.getPath(maze);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testGetPath_HasPath() {
        boolean[][] maze = new boolean[][] {
            { true, true, true, false },
            { true, true, false, true },
            { true, false, true, false },
            { true, true, true, true },
        };
        
        ArrayList<Point> expected = new ArrayList<Point>();
        expected.add(new Point(0,0));
        expected.add(new Point(1,0));
        expected.add(new Point(2,0));
        expected.add(new Point(3,0));
        expected.add(new Point(3,1));
        expected.add(new Point(3,2));
        expected.add(new Point(3,3));
        ArrayList<Point> actual = Question_8_2.getPath(maze);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testGetPath_NoPath() {
        boolean[][] maze = new boolean[][] {
            { true, true, true, true },
            { true, true, true, true },
            { true, true, true, false },
            { true, true, false, true },
        };
        
        ArrayList<Point> actual = Question_8_2.getPath(maze);
        assertNull(actual);
    }
    
    @Test
    public void testGetPath_EndIsNotAvailable() {
        boolean[][] maze = new boolean[4][4];
        for (boolean[] row : maze) {
            Arrays.fill(row, true);
        }
        maze[3][3] = false;
        
        ArrayList<Point> actual = Question_8_2.getPath(maze);
        assertNull(actual);
    }
    
    @Test
    public void testGetPath_OneElement() {
        boolean[][] maze = new boolean[1][1];
        maze[0][0] = true;
        
        ArrayList<Point> expected = new ArrayList<Point>();
        expected.add(new Point(0, 0));
        ArrayList<Point> actual = Question_8_2.getPath(maze);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testGetPath_Null() {
        boolean[][] maze = new boolean[1][];
        maze[0] = new boolean[0];
        
        ArrayList<Point> actual = Question_8_2.getPath(maze);
        assertNull(actual);
        
        maze = new boolean[0][];
        actual = Question_8_2.getPath(maze);
        assertNull(actual);
        
        maze = null;
        actual = Question_8_2.getPath(maze);
        assertNull(actual);
    }
}
