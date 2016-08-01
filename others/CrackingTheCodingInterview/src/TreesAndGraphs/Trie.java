package TreesAndGraphs;

import java.util.HashMap;

/**
 * The trie data structure is used in a few problems to make it easier to look up if a word
 * is a prefix of any other words in a dictionary (or list of valid words). This is often used
 * when we're recursively building words so that we can short circuit when the word is not valid.
 */
public class Trie {

    // The root of this trie.
    private TrieNode root;
    
    // Takes a list of strings as an argument, and constructs a trie that stores these strings.
    public Trie(String[] list) {
        root = new TrieNode();
        for (String word : list) {
            root.addWord(word);
        }
    }
    
    // Checks whether this trie contains a string with the prefix passed in as argument.
    public boolean contains(String prefix, boolean exact) {
        TrieNode lastNode = root;
        
        for (int i = 0; i < prefix.length(); ++i) {
            lastNode = lastNode.getChild(prefix.charAt(i));
            if (lastNode == null) {
                return false;
            }
        }
        
        return !exact || lastNode.terminates();
    }
    
    public boolean constains(String prefix) {
        return contains(prefix, false);
    }
    
    public TrieNode getRoot() {
        return root;
    }
    
    private class TrieNode {
        // The children of this node in the trie.
        private HashMap<Character, TrieNode> children;
        private boolean terminates;
        
        // The character stored in this node as data.
        private char character;
        
        // Constructs an empty trie node and initializes the list of its children to an empty hash map.
        // Used only to construct the root node of the trie.
        public TrieNode() {
            children = new HashMap<Character, TrieNode>();
            terminates = false;
        }
        
        // Constructs a trie node and store this character as the node's value.
        // Initializes the list of child nodes of this node to an empty hash map.
        public TrieNode(char character) {
            this();
            this.character = character;
        }
        
        // Add this word to the trie, and recursively create the child nodes.
        public void addWord(String word) {
            if (word == null || word.isEmpty()) {
                return;
            }
            
            char firstChar = word.charAt(0);
            
            TrieNode child = getChild(firstChar);
            if (child == null) {
                child = new TrieNode(firstChar);
                children.put(firstChar, child);
            }
            
            if (word.length() > 1) {
                child.addWord(word.substring(1));
            } else {
                child.setTerminates(true);
            }
        }
        
        // Find a child node of this node that has the char argument as its data.
        // Return null if no such child node is present in the trie.
        public TrieNode getChild(char c) {
            return children.get(c);
        }
        
        // Returns whether this node represents the end of a complete word.
        public boolean terminates() {
            return terminates;
        }
        
        // Set whether this node is the end of a complete word.
        public void setTerminates(boolean t) {
            terminates = t;
        }
    }
}
