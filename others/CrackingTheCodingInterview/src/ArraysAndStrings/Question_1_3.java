package ArraysAndStrings;

/**Question 1.3
 * Design an algorithm and write code to remove the duplicate characters in a string
 * without using any additional buffer.
 * NOTE: One or two additional variables are fine. An extra copy of the array is not.
 */
public class Question_1_3 {
    
    /**
     * Complexity: O(n)
     */
    public static void removeDuplicateByASCII(char[] s) {
        if (s == null) {
            return;
        }
        
        boolean[] visited = new boolean[256];
        for (int i = 0; i < visited.length; ++i) {
            visited[i] = false;
        }
        
        int p = 0;
        int len = Helper.getArrayLength(s);
        for (int i = 0; i < len; ++i) {
            int index = (int)s[i];
            if (!visited[index]) {
                visited[index] = true;
                s[p++] = s[i];
            }
        }
        
        s[p] = '\0';
    }
    
    /**
     * Complexity: O(n^2)
     */
    public static void removeDuplicateInPlace(char[] s) {
        if (s == null) {
            return;
        }
        
        int p = 0;
        int len = Helper.getArrayLength(s);
        for (int i = 0; i < len; ++i) {
            if (s[i] != '\0') {
                s[p++] = s[i];
                for (int j = i + 1; j < len; ++j) {
                    if (s[j] == s[i]) {
                        s[j] = '\0';
                    }
                }
            }
        }
        
        s[p] = '\0';
    }
}
