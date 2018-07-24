package MyLibrary;

import java.util.LinkedList;
import java.util.Stack;

public class SetOfStacks
{
    private LinkedList<Stack<Integer>> listOfStacks;
    private int numItems = 0;
    private int maxSize;

    public SetOfStacks(int newMaxSize)
    {
        this.listOfStacks = new LinkedList<Stack<Integer>>();
        this.maxSize = newMaxSize;
    }

    public void push(int newValue)
    {
        if (this.numStacks() == 0)
        {
            this.listOfStacks.add(new Stack<Integer>());
        }

        Stack<Integer> firstStack = this.listOfStacks.getFirst();
        // Add new stack when top stack is at capacity
        if (firstStack.size() == maxSize)
        {
            this.listOfStacks.addFirst(new Stack<Integer>());
            firstStack = this.listOfStacks.getFirst();
        }
        firstStack.push(newValue);
        this.numItems++;
    }

    public int pop()
    {
        if (this.size() == 0)
        {
            return Integer.MAX_VALUE;
        }

        int retVal = this.listOfStacks.getFirst().pop();
        this.numItems--;
        if (this.listOfStacks.getFirst().size() == 0)
        {
            this.listOfStacks.pop();
        }

        return retVal;
    }

    // Assumes that we do not need to re-shuffle the items to re-fill the empty spot
    public int popAt(int stackNum)
    {
        if (stackNum < 0 || stackNum > (this.numStacks() - 1) || this.numStacks() == 0)
        {
            return Integer.MAX_VALUE;
        }
        Stack<Integer> pickedStack = this.listOfStacks.get(stackNum);
        int retVal = pickedStack.pop();
        this.numItems--;
        if (pickedStack.size() == 0)
        {
            this.listOfStacks.remove(stackNum);
        }

        return retVal;
    }

    public int size()
    {
        return this.numItems;
    }

    private int numStacks()
    {
        return this.listOfStacks.size();
    }
}
