package ctci;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Stack;

import MyLibrary.MinStack;
import MyLibrary.MyQueue;
import MyLibrary.SetOfStacks;

class ch3Test
{
    // #3.2
    @Test
    void testMinStack()
    {
        MinStack ourStack = new MinStack();
        ourStack.push(4);
        ourStack.push(5);
        ourStack.push(3);
        ourStack.push(6);

        assertEquals(6, ourStack.peek());
        assertEquals(3, ourStack.peekMin());
        assertEquals(6, ourStack.pop());

        assertEquals(3, ourStack.peek());
        assertEquals(3, ourStack.peekMin());
        assertEquals(3, ourStack.pop());

        assertEquals(5, ourStack.peek());
        assertEquals(4, ourStack.peekMin());
        assertEquals(5, ourStack.pop());

        assertEquals(4, ourStack.peek());
        assertEquals(4, ourStack.peekMin());
        assertEquals(4, ourStack.pop());

        assertEquals(Integer.MAX_VALUE, ourStack.peek());
        assertEquals(Integer.MAX_VALUE, ourStack.peekMin());
    }

    // #3.3
    @Test
    void testSetOfStacks()
    {
        SetOfStacks ourStacks = new SetOfStacks(2);
        ourStacks.push(1);
        ourStacks.push(2);
        ourStacks.push(3);
        ourStacks.push(4);
        ourStacks.push(5);

        assertEquals(5, ourStacks.size());
        assertEquals(2, ourStacks.popAt(2));
        assertEquals(5, ourStacks.pop());
        assertEquals(4, ourStacks.pop());
        assertEquals(3, ourStacks.pop());
        assertEquals(1, ourStacks.pop());
        assertEquals(0, ourStacks.size());
        assertEquals(Integer.MAX_VALUE, ourStacks.pop());
    }

    // #3.4
    @Test
    void testMyQueue()
    {
        MyQueue ourQueue = new MyQueue();
        assertEquals(Integer.MAX_VALUE, ourQueue.dequeue());

        ourQueue.enqueue(1);
        ourQueue.enqueue(2);
        ourQueue.enqueue(3);

        assertEquals(1, ourQueue.dequeue());
        assertEquals(2, ourQueue.dequeue());
        assertEquals(3, ourQueue.dequeue());
        assertEquals(Integer.MAX_VALUE, ourQueue.dequeue());

        ourQueue.enqueue(4);
        assertEquals(4, ourQueue.dequeue());
        assertEquals(Integer.MAX_VALUE, ourQueue.dequeue());
    }

    // #3.5
    @Test
    void testSortStack()
    {
        Stack<Integer> ourStack = new Stack<Integer>();
        ourStack.push(9);
        ourStack.push(2);
        ourStack.push(3);
        ourStack.push(1);
        ourStack.push(4);
        ourStack.push(5);

        ch3.SortStack(ourStack);
        Integer[] expected = {1, 2, 3, 4, 5, 9};
        assertTrue(Arrays.deepEquals(expected, ourStack.toArray()));
    }
}
