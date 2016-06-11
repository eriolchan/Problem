package ArraysAndStrings;

import java.util.ArrayList;
import java.util.HashMap;

public class Examples {
    
    public static HashMap<Integer, Student> buildMap(Student[] students) {
        HashMap<Integer, Student> map = new HashMap<Integer, Student>();
        for (Student s : students) {
            map.put(s.getId(), s);
        }
        
        return map;
    }
    
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
    
    public static String makeSentence(String[] words) {
        StringBuffer sentence = new StringBuffer();
        for (String w : words) {
            sentence.append(w);
        }
        
        return sentence.toString();
    }
}

class Student {
    
    private int id;
    private String name;
    
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
