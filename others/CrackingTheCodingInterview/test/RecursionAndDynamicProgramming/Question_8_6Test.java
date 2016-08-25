package RecursionAndDynamicProgramming;

import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.Test;

public class Question_8_6Test {

    @Test
    public void testHanoiTower_Odd() {
        Question_8_6[] towers = createHanoiTowers();
        int n = 5;
        initializeTower(n, towers[0]);
        
        towers[0].moveDisks(n, towers[2], towers[1]);
        assertTrue(towers[0].isEmpty());
        assertTrue(towers[1].isEmpty());
        assertFalse(towers[2].isEmpty());
        
        assertStackEquals(n, towers[2].getStack());
    }
    
    @Test
    public void testHanoiTower_Even() {
        Question_8_6[] towers = createHanoiTowers();
        int n = 4;
        initializeTower(n, towers[0]);
        
        towers[0].moveDisks(n, towers[2], towers[1]);
        assertTrue(towers[0].isEmpty());
        assertTrue(towers[1].isEmpty());
        assertFalse(towers[2].isEmpty());
        
        assertStackEquals(n, towers[2].getStack());
    }
    
    @Test
    public void testHanoiTower_One() {
        Question_8_6[] towers = createHanoiTowers();
        int n = 1;
        initializeTower(n, towers[0]);
        
        towers[0].moveDisks(n, towers[2], towers[1]);
        assertTrue(towers[0].isEmpty());
        assertTrue(towers[1].isEmpty());
        assertFalse(towers[2].isEmpty());
        
        assertStackEquals(n, towers[2].getStack());
    }
    
    @Test
    public void testHanoiTower_Empty() {
        Question_8_6[] towers = createHanoiTowers();
        int n = 0;
        initializeTower(n, towers[0]);
        
        towers[0].moveDisks(n, towers[2], towers[1]);
        assertTrue(towers[0].isEmpty());
        assertTrue(towers[1].isEmpty());
        assertTrue(towers[2].isEmpty());
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testHanoiTower_Invalid() {
        Question_8_6 tower = new Question_8_6();
        tower.add(1);
        tower.add(2);
    }
    
    private static Question_8_6[] createHanoiTowers() {
        Question_8_6[] towers = new Question_8_6[3];
        for (int i = 0; i < 3; ++i) {
            towers[i] = new Question_8_6();
        }
        
        return towers;
    }
    
    private static void initializeTower(int n, Question_8_6 tower) {
        for (int i = n; i > 0; --i) {
            tower.add(i);
        }
    }
    
    private static void assertStackEquals(int n, Stack<Integer> stack) {
        for (int i = 1; i <= n; ++i) {
            assertEquals(i, stack.pop().intValue());
        }
    }
}
