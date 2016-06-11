package ArraysAndStrings;

/**Question 1.2
 * Write code to reverse a C-Style String.
 * C-String means that ¡°abcd¡± is represented as five characters,
 * including the null character.
 */
public class Question_1_2 {
	
	/**
	 * Complexity: O(n)
	 */
	public static void reverse(char[] s) {
		if (s == null || s.length == 0) {
			return;
		}
		
		for (int i = 0, j = s.length - 1; i < j; ++i, --j) {
			char temp = s[i];
			s[i] = s[j];
			s[j] = temp;
		}
	}
}
