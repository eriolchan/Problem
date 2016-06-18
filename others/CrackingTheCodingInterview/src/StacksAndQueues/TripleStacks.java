package StacksAndQueues;

public class TripleStacks {
    
    private int stackSize;
    private int[] buffer;
    private int[] stackPointer;
    
    public TripleStacks(int stackSize) {
        this.stackSize = stackSize;
        buffer = new int[3 * stackSize];
        stackPointer = new int[] { -1, -1, -1 };
    }
    
    public void push(int stackIndex, int data) {
        validateArgument(stackIndex);
        
        int index = stackPointer[stackIndex - 1];
        if (index == stackSize - 1) {
            throw new IllegalStateException(Constants.FULL);
        }
        
        buffer[(stackIndex - 1) * stackSize + index + 1] = data;
        ++stackPointer[stackIndex - 1];
    }
    
    public int pop(int stackIndex) {
        int result = peek(stackIndex);
        --stackPointer[stackIndex - 1];
        
        return result;
    }
    
    public int peek(int stackIndex) {
        validateArgument(stackIndex);
        
        int index = stackPointer[stackIndex - 1];
        if (index == -1) {
            throw new IllegalStateException(Constants.EMPTY);
        }
        
        return buffer[(stackIndex - 1) * stackSize + index];
    }
    
    public boolean isEmpty(int stackIndex) {
        validateArgument(stackIndex);
        
        return stackPointer[stackIndex - 1] == -1;
    }
    
    private static void validateArgument(int stackIndex) {
        if (stackIndex < 1 || stackIndex > 3) {
            throw new IllegalArgumentException(Constants.INVALIDINDEX);
        }
    }
}

class TripleStacks2 {
    
    private int stackSize;
    private int freeIndex;
    private StackNode[] buffer;
    private int[] stackPointer;
    
    public TripleStacks2(int stackSize) {
        this.stackSize = stackSize;
        freeIndex = 0;
        buffer = new StackNode[3 * stackSize];
        stackPointer = new int[] { -1, -1, -1 };
    }
    
    public void push(int stackIndex, int data) {
        validateArgument(stackIndex);
        
        if (freeIndex == 3 * stackSize) {
            throw new IllegalStateException(Constants.FULL);
        }
        
        int index = stackPointer[stackIndex - 1];
        StackNode node = new StackNode(index, data);
        stackPointer[stackIndex - 1] = freeIndex;
        buffer[freeIndex++] = node;
    }
    
    public int pop(int stackIndex) {
        int result = peek(stackIndex);
        
        int index = stackPointer[stackIndex - 1];
        stackPointer[stackIndex - 1] = buffer[index].previous;
        
        for (int i = 0; i < stackPointer.length; ++i) {
            if (stackPointer[i] == freeIndex - 1) {
                stackPointer[i] = index;
                buffer[index] = buffer[freeIndex - 1];
                break;
            }
        }
        
        --freeIndex;
        
        return result;
    }
    
    public int peek(int stackIndex) {
        validateArgument(stackIndex);
        
        int index = stackPointer[stackIndex - 1];
        if (index == -1) {
            throw new IllegalStateException(Constants.EMPTY);
        }
        
        return buffer[index].data;
    }
    
    public boolean isEmpty(int stackIndex) {
        validateArgument(stackIndex);
        
        return stackPointer[stackIndex - 1] == -1;
    }
    
    private static void validateArgument(int stackIndex) {
        if (stackIndex < 1 || stackIndex > 3) {
            throw new IllegalArgumentException(Constants.INVALIDINDEX);
        }
    }
}

class StackNode {
    int previous;
    int data;
    
    public StackNode(int previous, int data) {
        this.previous = previous;
        this.data = data;
    }
}
