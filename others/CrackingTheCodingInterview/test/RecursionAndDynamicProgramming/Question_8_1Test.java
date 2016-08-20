package RecursionAndDynamicProgramming;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question_8_1Test {

    @Test
    public void testCountWays_BaseCase() {
        assertEquals(1, Question_8_1.countWays(0));
        assertEquals(1, Question_8_1.countWays(1));
        assertEquals(2, Question_8_1.countWays(2));
    }
    
    @Test
    public void testCountWays_More() {
        assertEquals(4, Question_8_1.countWays(3));
        assertEquals(149, Question_8_1.countWays(9));
        assertEquals(121415, Question_8_1.countWays(20));
    }
    
    @Test
    public void testCountSteps_Invalid() {
        assertEquals(0, Question_8_1.countWays(-1));
    }
}
