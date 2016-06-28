package ArraysAndStrings;

import java.util.ArrayList;
import java.util.HashMap;

public class Examples {

    public static ArrayList<String> merge(String[] words, String[] more) {
        ArrayList<String> sentence = new ArrayList<String>();
        for (String w : words) {
            sentence.add(w);
        }
        
        for (String w : more) {
            sentence.add(w);
        }
        
        return sentence;
    }
    
    public static String joinWords(String[] words) {
        StringBuffer sentence = new StringBuffer();
        for (String w : words) {
            sentence.append(w);
        }
        
        return sentence.toString();
    }
}