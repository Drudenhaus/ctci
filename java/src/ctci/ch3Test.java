package ctci;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import MyLibrary.MinStack;

class ch3Test
{
    // # 3.2
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
}
