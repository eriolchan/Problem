package ArraysAndStrings;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ExamplesTest {

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
    public void testJoinWords() {
        String[] words = new String[] { "This", "is", "words" };
        
        String expected = "Thisiswords";
        String actual = Examples.joinWords(words);
        assertEquals(expected, actual);
    }
}
