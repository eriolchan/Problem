package StacksAndQueues;

import java.util.Stack;

/**
 * Question 3.5
 * Write a program to sort a stack such that the smallest items are on the top.
 * You can use additional temporary stack, but you may not copy the element into
 * any other data structure (such as array). The stack support the following operations:
 * push, pop, peek, and isEmpty.
 */
public class Question_3_5 {

    // O(n^2)
    public static Stack<Integer> sort(Stack<Integer> stack) {
        if (stack == null) {
            return null;
        }
        
        Stack<Integer> result = new Stack<Integer>();
        while (!stack.isEmpty()) {
            Integer temp = stack.pop();
            while (!result.isEmpty() && temp > result.peek()) {
                stack.push(result.pop());
            }
            
            result.push(temp);
        }
        
        return result;
    }
}
