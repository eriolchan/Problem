package ArraysAndStrings;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class HashMapListTest {

    @Test
    public void testHashMapList() {
        String[] strings = new String[] {
            "Alex",
            "Adam",
            "Alice",
            "Bob",
        };
        
        HashMapList<Integer, String> maplist = new HashMapList<Integer, String>();
        for (String s : strings) {
            int key = computeValue(s);
            maplist.put(key, s);
        }
        
        ArrayList<String> nameWithA = maplist.get(computeValue("a"));
        assertEquals(3, nameWithA.size());
        assertEquals("Alex", nameWithA.get(0));
        assertEquals("Adam", nameWithA.get(1));
        assertEquals("Alice", nameWithA.get(2));
        
        int key = computeValue("b");
        ArrayList<String> nameWithB = maplist.get(key);
        assertEquals(1, nameWithB.size());
        assertEquals("Bob", nameWithB.get(0));
        
        ArrayList<String> nameWithB2 = new ArrayList<String>();
        nameWithB2.add("Black");
        nameWithB2.add("Brian");
        maplist.put(key, nameWithB2);
        nameWithB = maplist.get(key);
        assertEquals(2, nameWithB.size());
        assertEquals("Black", nameWithB.get(0));
        assertEquals("Brian", nameWithB.get(1));
        
        assertTrue(maplist.containsKey(key));
        assertFalse(maplist.containsKey(computeValue("e")));
        
        assertTrue(maplist.containsKeyValue(key, "Black"));
        assertFalse(maplist.containsKeyValue(key, "Bob"));
    }
    
    private int computeValue(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        
        return s.toUpperCase().charAt(0) - 'A';
    }
}
