package ArraysAndStrings;

public class Helper {
    
    /**
     * Get the actual length of C-style string length.
     * Assume there is always '\0' in the string.
     */
    public static int getArrayLength(char[] s) {
        int i = 0;
        while (s[i] != '\0') {
            ++i;
        }
        
        return i;
    }
}
