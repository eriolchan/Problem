package ArraysAndStrings;

/**
 * Question 1.5
 * Write a method to replace all spaces in a string with '%20'.
 */
public class Question_1_5 {

    // O(n)
    public static void replaceSpace(char[] s) {
        if (s == null) {
            return;
        }
        
        int len = 0;
        int count = 0;
        for (len = 0; s[len] != '\0'; ++len) {
            if (s[len] == ' ') {
                ++count;
            }
        }
        
        int newLen = len + 2 * count;
        if (newLen + 1 > s.length) {
            throw new IllegalArgumentException("Insufficient array length");
        }
        
        for (int i = len, j = newLen; i >= 0 && j > i; --i) {
            if (s[i] == ' ') {
                s[j--] = '0';
                s[j--] = '2';
                s[j--] = '%';
            } else {
                s[j--] = s[i];
            }
        }
    }
}
