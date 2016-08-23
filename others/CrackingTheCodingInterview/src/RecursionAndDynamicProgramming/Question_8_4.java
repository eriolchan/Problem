package RecursionAndDynamicProgramming;

import java.util.ArrayList;

/**
 * Write a method to return all subset of a set.
 */
public class Question_8_4 {

    // O(n 2^n)
    public static ArrayList<ArrayList<Integer>> getSubsetsRecursively(ArrayList<Integer> array) {
        if (array == null) {
            return null;
        }
        
        return getSubsetsCore(array, array.size());
    }
    
    // O(n 2^n)
    public static ArrayList<ArrayList<Integer>> getSubsetsByBits(ArrayList<Integer> array) {
        if (array == null) {
            return null;
        }
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int size = 1 << array.size();
        
        for (int i = 0; i < size; ++i) {
            ArrayList<Integer> subset = convertIntToSet(array, i);
            result.add(subset);
        }
        
        return result;
    }
    
    private static ArrayList<ArrayList<Integer>> getSubsetsCore(ArrayList<Integer> array, int size) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        if (size == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        
        ArrayList<ArrayList<Integer>> subsets = getSubsetsCore(array, size - 1);
        result.addAll(subsets);
        
        int item = array.get(size - 1);
        for (ArrayList<Integer> subset : subsets) {
            ArrayList<Integer> newSubset = new ArrayList<Integer>(subset);
            newSubset.add(item);
            result.add(newSubset);
        }
        
        return result;
    }
    
    private static ArrayList<Integer> convertIntToSet(ArrayList<Integer> array, int number) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        for (int i = 0; number > 0; number >>=1 ) {
            if ((number & 1) > 0) {
                result.add(array.get(i));
            }
            
            ++i;
        }
        
        return result;
    }
}
