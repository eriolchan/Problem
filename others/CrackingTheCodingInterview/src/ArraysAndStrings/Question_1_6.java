package ArraysAndStrings;

/**
 * Question 1.6
 * Implement a method to perform basic string compression
 * using the counts of repeated characters. If compressed string
 * would not become smaller than the original string, it should return
 * the original string.
 */
public class Question_1_6 {
    
    // O(n)
    public static String compress(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        
        StringBuilder builder = new StringBuilder();
        int count = 0;
        int len = s.length();
        
        for (int i = 0; i < len; ++i) {
            ++count;
            
            if (i == len - 1 || s.charAt(i) != s.charAt(i + 1)) {
                builder.append(s.charAt(i));
                if (count > 1) {
                    builder.append(count);
                }
                
                count = 0;
            }
        }
        
        return builder.toString();
    }
}
