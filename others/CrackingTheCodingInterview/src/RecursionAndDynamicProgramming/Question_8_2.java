package RecursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Question 8.2
 * Imagine a robot sitting on the upper left corner of grid with r rows and c columns.
 * The robot can only move in two directions, right and down, but certain cells are
 * "off limits" such that the robot cannot step on them.
 * Design an algorithm to find a path for the robot from the top left to the bottom right.
 */
public class Question_8_2 {

    // O(mn)
    public static ArrayList<Point> getPath(boolean[][] maze) {
        if (maze == null || maze.length == 0 || maze[0].length == 0) {
            return null;
        }
        
        ArrayList<Point> path = new ArrayList<Point>();
        HashSet<Point> failedPoints = new HashSet<Point>();
        if (getPathRecursively(maze, maze.length - 1, maze[0].length - 1, path, failedPoints)) {
            return path;
        }
        
        return null;
    }
    
    private static boolean getPathRecursively(boolean[][] maze, int row, int column, ArrayList<Point> path,
                                              HashSet<Point> failedPoints) {
        if (row < 0 || column < 0 || !maze[row][column]) {
            return false;
        }
        
        Point point = new Point(row, column);
        if (failedPoints.contains(point)) {
            return false;
        }
        
        boolean isStartPoint = (row == 0) && (column == 0);
        if (isStartPoint || getPathRecursively(maze, row - 1, column, path, failedPoints) ||
            getPathRecursively(maze, row, column - 1, path, failedPoints)) {
            path.add(point);
            return true;
        }
        
        failedPoints.add(point);
        
        return false;
    }
}

class Point {
    int row;
    int column;
    
    public Point(int row, int column) {
        this.row = row;
        this.column = column;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (!(obj instanceof Point)) {
            return false;
        }
        
        final Point other = (Point)obj;
        
        return this.row == other.row &&
               this.column == other.column;
    }
    
    @Override
    public int hashCode() {
        return row ^ column;
    }
}
