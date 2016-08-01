package TreesAndGraphs;

import static org.junit.Assert.*;

import org.junit.Test;

public class TrieTest {

    @Test
    public void testTrie() {
        String[] list = new String[] {
            "many",
            "much",
            "master",
            "man",
            "manage",
        };
        
        Trie trie = new Trie(list);
        assertTrue(trie.contains("m"));
        assertFalse(trie.contains("n"));
        
        assertTrue(trie.contains("ma"));
        assertFalse(trie.contains("ma", true));
        
        assertTrue(trie.contains("man"));
        assertTrue(trie.contains("man", true));
    }
}
