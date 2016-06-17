package ArraysAndStrings;

/**
 * Question 1.3
 * Design an algorithm and write code to remove the duplicate characters in a string
 * without using any additional buffer.
 * NOTE: One or two additional variables are fine. An extra copy of the array is not.
 */
public class Question_1_3 {

    // O(n)
    public static void removeDuplicateByMap(char[] s) {
        if (s == null) {
            return;
        }
        
        int len = s.length;
        if (len < 2) {
            return;
        }
        
        int tail = 0;
        boolean[] visited = new boolean[256];
        for (int i = 0; i < len; ++i) {
            int index = s[i];
            if (!visited[index]) {
                visited[index] = true;
                s[tail++] = s[i];
            }
        }
        
        if (tail < len) {
            s[tail] = 0;
        }
    }
    
    // O(n^2)
    public static void removeDuplicateInPlace(char[] s) {
        if (s == null) {
            return;
        }
        
        int len = s.length;
        if (len < 2) {
            return;
        }
        
        int tail = 1;
        for (int i = 1; i < len; ++i) {
            int j;
            for (j = 0; j < tail; ++j) {
                if (s[i] == s[j]) {
                    break;
                }
            }
            
            if (j == tail) {
                s[tail++] = s[i];
            }
        }
        
        if (tail < len) {
            s[tail] = 0;
        }
    }
}
