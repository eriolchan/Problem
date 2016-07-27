package StacksAndQueues;

/**
 * Question 3.1
 * Describe how you could use a single array to implement three stacks.
 */
public class Question_3_1 {

    private int numberOfStacks = 3;
    private int stackCapacity;
    private int[] values;
    private int[] sizes;
    
    public Question_3_1(int capacity) {
        stackCapacity = capacity;
        values = new int[numberOfStacks * capacity];
        sizes = new int[numberOfStacks];
    }
    
    public void push(int stackNum, int value) throws FullStackException {
        if (isFull(stackNum)) {
            throw new FullStackException();
        }
        
        int stackIndex = stackNum - 1;
        ++sizes[stackIndex];
        values[indexOfTop(stackIndex)] = value;
    }
    
    public int pop(int stackNum) throws EmptyStackException {
        if (isEmpty(stackNum)) {
            throw new EmptyStackException();
        }
        
        int stackIndex = stackNum - 1;
        int value = values[indexOfTop(stackIndex)];
        --sizes[stackIndex];
        
        return value;
    }
    
    public int peek(int stackNum) throws EmptyStackException {
        if (isEmpty(stackNum)) {
            throw new EmptyStackException();
        }
        
        int stackIndex = stackNum - 1;
        return values[indexOfTop(stackIndex)];
    }
    
    public boolean isEmpty(int stackNum) {
        int stackIndex = stackNum - 1;
        validateArgument(stackIndex);
        
        return sizes[stackIndex] == 0;
    }
    
    public boolean isFull(int stackNum) {
        int stackIndex = stackNum - 1;
        validateArgument(stackIndex);
        
        return sizes[stackIndex] == stackCapacity;
    }
    
    private int indexOfTop(int stackIndex) {
        int offset = stackIndex * stackCapacity;
        int size = sizes[stackIndex];
        
        return offset + size - 1;
    }
    
    private static void validateArgument(int stackIndex) {
        if (stackIndex < 0 || stackIndex > 2) {
            throw new IllegalArgumentException("Stack index is not valid");
        }
    }
}

class TripleStacks2 {
    
    private int numberOfStacks = 3;
    private StackInfo[] infos;
    private int[] values;
    
    public TripleStacks2(int capacity) {
        infos = new StackInfo[numberOfStacks];
        for (int i = 0; i < numberOfStacks; ++i) {
            infos[i] = new StackInfo(i * capacity, capacity);
        }
        
        values = new int[numberOfStacks * capacity];
    }
    
    public void push(int stackNum, int value) throws FullStackException {
        if (allStacksAreFull()) {
            throw new FullStackException();
        }
        
        if (isFull(stackNum)) {
            int stackIndex = stackNum - 1;
            expand(stackIndex);
        }
        
        StackInfo info = infos[stackNum - 1];
        ++info.size;
        values[info.lastElementIndex()] = value;
    }
    
    public int pop(int stackNum) throws EmptyStackException {
        if (isEmpty(stackNum)) {
            throw new EmptyStackException();
        }
        
        StackInfo info = infos[stackNum - 1];
        int value = values[info.lastElementIndex()];
        --info.size;
        
        return value;
    }
    
    public int peek(int stackNum) throws EmptyStackException {
        if (isEmpty(stackNum)) {
            throw new EmptyStackException();
        }
        
        StackInfo info = infos[stackNum - 1];
        return values[info.lastElementIndex()];
    }
    
    public boolean isEmpty(int stackNum) {
        int stackIndex = stackNum - 1;
        validateArgument(stackIndex);
        
        StackInfo info = infos[stackIndex];
        return info.isEmpty();
    }
    
    public boolean isFull(int stackNum) {
        int stackIndex = stackNum - 1;
        validateArgument(stackIndex);
        
        StackInfo info = infos[stackIndex];
        return info.isFull();
    }
    
    private void expand(int stackIndex) {
        shift((stackIndex + 1) % infos.length);
        ++infos[stackIndex].capacity;
    }
    
    private void shift(int stackIndex) {
        StackInfo info = infos[stackIndex];
        
        if (info.size >= info.capacity) {
            shift((stackIndex + 1) % infos.length);
            ++info.capacity;
        }
        
        int index = info.lastElementIndex();
        while (info.isWithinStackCapacity(index)) {
            values[nextIndex(index)] = values[index];
            index = previousIndex(index);
        }
        
        info.start = nextIndex(info.start);
        --info.capacity;
    }
    
    private int nextIndex(int index) {
        return adjustIndex(index + 1);
    }
     
    private int previousIndex(int index) {
        return adjustIndex(index - 1);
    }
    
    // mod will return negative value in Java.
    private int adjustIndex(int index) {
        int max = values.length;
        
        return ((index % max) + max) % max;
    }
    
    private boolean allStacksAreFull() {
        int size = 0;
        for (StackInfo info : infos) {
            size += info.size;
        }
        
        return size == values.length;
    }
    
    private static void validateArgument(int stackIndex) {
        if (stackIndex < 0 || stackIndex > 2) {
            throw new IllegalArgumentException("Stack index is not valid");
        }
    }
    
    private class StackInfo {
        private int size;
        private int capacity;
        private int start;
        
        public StackInfo(int start, int capacity) {
            this.start = start;
            this.capacity = capacity;
            this.size = 0;
        }
        
        public boolean isWithinStackCapacity(int index) {
            if (index < 0 || index >= values.length) {
                return false;
            }
            
            int contiguousIndex = index < start ? index + values.length : index;
            int end = start + capacity;
            
            return start <= contiguousIndex && contiguousIndex < end;
        }
        
        public boolean isFull() {
            return size == capacity;
        }
        
        public boolean isEmpty() {
            return size == 0;
        }
        
        public int lastElementIndex() {
            return adjustIndex(start + size - 1);
        }
    }
}

class TripleStacks3 {
    
    private int numberOfStacks = 3;
    private int stackCapacity;
    private int freeIndex;
    private StackNode[] values;
    private int[] stackPointer;
    
    public TripleStacks3(int capacity) {
        this.stackCapacity = capacity;
        freeIndex = 0;
        values = new StackNode[numberOfStacks * capacity];
        stackPointer = new int[] { -1, -1, -1 };
    }
    
    public void push(int stackNum, int value) throws FullStackException {
        if (isFull(stackNum)) {
            throw new FullStackException();
        }
        
        int stackIndex = stackNum - 1;
        int index = stackPointer[stackIndex];
        
        StackNode node = new StackNode(index, value);
        stackPointer[stackIndex] = freeIndex;
        values[freeIndex++] = node;
    }
    
    public int pop(int stackNum) throws EmptyStackException {
        if (isEmpty(stackNum)) {
            throw new EmptyStackException();
        }
        
        int stackIndex = stackNum - 1;
        int index = stackPointer[stackIndex];
        
        int value = values[index].value;
        stackPointer[stackIndex] = values[index].previous;
        
        if (index != freeIndex - 1) {
            for (int i = 0; i < stackPointer.length; ++i) {
                if (stackPointer[i] == freeIndex - 1) {
                    stackPointer[i] = index;
                    values[index] = values[freeIndex - 1];
                    break;
                }
            }
        }
        
        --freeIndex;
        
        return value;
    }
    
    public int peek(int stackNum) throws EmptyStackException {
        if (isEmpty(stackNum)) {
            throw new EmptyStackException();
        }
        
        int stackIndex = stackNum - 1;
        int index = stackPointer[stackIndex];
        
        return values[index].value;
    }
    
    public boolean isEmpty(int stackNum) {
        int stackIndex = stackNum - 1;
        validateArgument(stackIndex);
        
        return stackPointer[stackIndex] == -1;
    }
    
    public boolean isFull(int stackNum) {
        int stackIndex = stackNum - 1;
        validateArgument(stackIndex);
        
        return freeIndex == numberOfStacks * stackCapacity;
    }
    
    private static void validateArgument(int stackIndex) {
        if (stackIndex < 0 || stackIndex > 2) {
            throw new IllegalArgumentException("Stack index is not valid");
        }
    }
    
    private class StackNode {
        int previous;
        int value;
        
        public StackNode(int previous, int value) {
            this.previous = previous;
            this.value = value;
        }
    }
}
