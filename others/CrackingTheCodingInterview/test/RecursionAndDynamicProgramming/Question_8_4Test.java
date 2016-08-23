package RecursionAndDynamicProgramming;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class Question_8_4Test {

    @Test
    public void testGetSubsets_SizeIsOdd() {
        ArrayList<Integer> array = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
        
        ArrayList<ArrayList<Integer>> expected = new ArrayList<ArrayList<Integer>>();
        expected.add(new ArrayList<Integer>());
        expected.add(new ArrayList<Integer>(Arrays.asList(1)));
        expected.add(new ArrayList<Integer>(Arrays.asList(2)));
        expected.add(new ArrayList<Integer>(Arrays.asList(1, 2)));
        expected.add(new ArrayList<Integer>(Arrays.asList(3)));
        expected.add(new ArrayList<Integer>(Arrays.asList(1, 3)));
        expected.add(new ArrayList<Integer>(Arrays.asList(2, 3)));
        expected.add(new ArrayList<Integer>(Arrays.asList(1, 2, 3)));
        ArrayList<ArrayList<Integer>> actual = Question_8_4.getSubsetsRecursively(array);
        assertEquals(expected, actual);
        
        actual = Question_8_4.getSubsetsByBits(array);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testGetSubsets_SizeIsEven() {
        ArrayList<Integer> array = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
        
        ArrayList<ArrayList<Integer>> expected = new ArrayList<ArrayList<Integer>>();
        expected.add(new ArrayList<Integer>());
        expected.add(new ArrayList<Integer>(Arrays.asList(1)));
        expected.add(new ArrayList<Integer>(Arrays.asList(2)));
        expected.add(new ArrayList<Integer>(Arrays.asList(1, 2)));
        expected.add(new ArrayList<Integer>(Arrays.asList(3)));
        expected.add(new ArrayList<Integer>(Arrays.asList(1, 3)));
        expected.add(new ArrayList<Integer>(Arrays.asList(2, 3)));
        expected.add(new ArrayList<Integer>(Arrays.asList(1, 2, 3)));
        expected.add(new ArrayList<Integer>(Arrays.asList(4)));
        expected.add(new ArrayList<Integer>(Arrays.asList(1, 4)));
        expected.add(new ArrayList<Integer>(Arrays.asList(2, 4)));
        expected.add(new ArrayList<Integer>(Arrays.asList(1, 2, 4)));
        expected.add(new ArrayList<Integer>(Arrays.asList(3, 4)));
        expected.add(new ArrayList<Integer>(Arrays.asList(1, 3, 4)));
        expected.add(new ArrayList<Integer>(Arrays.asList(2, 3, 4)));
        expected.add(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4)));
        ArrayList<ArrayList<Integer>> actual = Question_8_4.getSubsetsRecursively(array);
        assertEquals(expected, actual);
        
        actual = Question_8_4.getSubsetsByBits(array);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testGetSubsets_SizeIsOne() {
        ArrayList<Integer> array = new ArrayList<Integer>(Arrays.asList(1));
        
        ArrayList<ArrayList<Integer>> expected = new ArrayList<ArrayList<Integer>>();
        expected.add(new ArrayList<Integer>());
        expected.add(new ArrayList<Integer>(Arrays.asList(1)));
        ArrayList<ArrayList<Integer>> actual = Question_8_4.getSubsetsRecursively(array);
        assertEquals(expected, actual);
        
        actual = Question_8_4.getSubsetsByBits(array);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testGetSubsets_Empty() {
        ArrayList<Integer> array = new ArrayList<Integer>();
        
        ArrayList<ArrayList<Integer>> expected = new ArrayList<ArrayList<Integer>>();
        expected.add(new ArrayList<Integer>());
        ArrayList<ArrayList<Integer>> actual = Question_8_4.getSubsetsRecursively(array);
        assertEquals(expected, actual);
        
        actual = Question_8_4.getSubsetsByBits(array);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testGetSubsets_Null() {
        ArrayList<Integer> array = null;
        
        ArrayList<ArrayList<Integer>> actual = Question_8_4.getSubsetsRecursively(array);
        assertNull(actual);
        
        actual = Question_8_4.getSubsetsByBits(array);
        assertNull(actual);
    }
}
