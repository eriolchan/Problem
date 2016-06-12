package ArraysAndStrings;

import java.util.Arrays;

public class Helper {

    /**
     * Get the actual length of C-style string.
     * Assume there is always '\0' in the string.
     */
    public static int getStringLength(char[] s) {
        int i = 0;
        while (s[i] != '\0') {
            ++i;
        }
        
        return i;
    }
    
    /**
     * Get the valid string from char arrays.
     */
    public static char[] getValidString(char[] s) {
        return Arrays.copyOf(s, getStringLength(s));
    }

    /**
     * Create char array with specified capacity and end with '\0'.
     */
    public static char[] createCharArray(int capacity, String content) {
        char[] result = new char[capacity];
        int len = content.length();
        for (int i = 0; i < len; ++i) {
            result[i] = content.charAt(i);
        }
        
        result[len] = '\0';
        
        return result;
    }
}
