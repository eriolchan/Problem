package RecursionAndDynamicProgramming;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class Question_8_9Test {

    @Test
    public void testGenerateParens_Odd() {
        int n = 3;
        
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("((()))");
        expected.add("(()())");
        expected.add("(())()");
        expected.add("()(())");
        expected.add("()()()");
        ArrayList<String> actual = Question_8_9.generateParens(n);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testGenerateParens_Even() {
        int n = 4;
        
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("(((())))");
        expected.add("((()()))");
        expected.add("((())())");
        expected.add("((()))()");
        expected.add("(()(()))");
        expected.add("(()()())");
        expected.add("(()())()");
        expected.add("(())(())");
        expected.add("(())()()");
        expected.add("()((()))");
        expected.add("()(()())");
        expected.add("()(())()");
        expected.add("()()(())");
        expected.add("()()()()");
        ArrayList<String> actual = Question_8_9.generateParens(n);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testGenerateParens_One() {
        int n = 1;
        
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("()");
        ArrayList<String> actual = Question_8_9.generateParens(n);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testGenerateParens_Zero() {
        int n = 0;
        
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("");
        ArrayList<String> actual = Question_8_9.generateParens(n);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testGenerateParens_Invalid() {
        int n = -1;
        
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("");
        ArrayList<String> actual = Question_8_9.generateParens(n);
        assertEquals(expected, actual);
    }
}
