package ArraysAndStrings;

/**
 * Question 1.3
 * Write a method to replace all spaces in a string with '%20'.
 * You may assume that the string has sufficient space at the end to hold
 * the additional characters, and that you are given the true length of the string.
 */
public class Question_1_3 {

    // O(n)
    public static void replaceSpace(char[] s, int length) {
        if (s == null) {
            return;
        }
        
        int count = 0;
        for (int i = 0; i < length; ++i) {
            if (s[i] == ' ') {
                ++count;
            }
        }
        
        int newLen = length + 2 * count;
        s[newLen] = '\0';
        for (int i = length - 1, j = newLen - 1; i >= 0 && j > i; --i) {
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
