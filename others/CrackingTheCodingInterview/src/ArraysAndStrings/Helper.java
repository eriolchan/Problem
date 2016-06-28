package ArraysAndStrings;

public class Helper {

    /**
     * Create char array with specified capacity.
     */
    public static char[] createCharArray(int capacity, String content) {
        char[] result = new char[capacity];
        int len = content.length();
        for (int i = 0; i < len; ++i) {
            result[i] = content.charAt(i);
        }
        
        return result;
    }
}
