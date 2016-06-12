package ArraysAndStrings;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ExamplesTest {

    @Test
    public void testBuildMap() {
        Student s1 = new Student(1, "Eric");
        Student s2 = new Student(2, "Chen");
        
        Student[] students = new Student[] { s1, s2 };
        
        HashMap<Integer, Student> expected = new HashMap<Integer, Student>();
        expected.put(1, s1);
        expected.put(2, s2);
        
        HashMap<Integer, Student> actual = Examples.buildMap(students);
        
        assertEquals(expected, actual);
   }
    
    @Test
    public void testMerge() {
        String[] words = new String[] { "This", "is", "words" };
        String[] more = new String[] { "and", "more" };
        
        ArrayList<String> expected = new ArrayList<String>(Arrays.asList(
            "This",
            "is",
            "words",
            "and",
            "more"
        ));
        
        ArrayList<String> actual = Examples.merge(words, more);
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void testMakeSentence() {
        String[] words = new String[] { "This", "is", "words" };
        
        String expected = "Thisiswords";
        String actual = Examples.makeSentence(words);
        
        assertEquals(expected, actual);
    }
}
