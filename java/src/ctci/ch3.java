package ctci;

import java.util.Stack;

public class ch3
{
    // #5
    public static void SortStack(Stack<Integer> inputStack)
    {
        Stack<Integer> tmpStack = new Stack<Integer>();

        while (!inputStack.isEmpty())
        {
            Integer tmp = inputStack.pop();
            int elementsMoved = 0;

            if (tmpStack.isEmpty())
            {
                tmpStack.push(tmp);
            }
            else
            {
                while (!tmpStack.isEmpty() && tmp >= tmpStack.peek())
                {
                    inputStack.push(tmpStack.pop());
                    elementsMoved++;
                }
                tmpStack.push(tmp);
                for (int i = 0; i < elementsMoved; i++)
                {
                    tmpStack.push(inputStack.pop());
                }
            }
        }

        // Reverse the sorted stack to obtain the final ordering
        while (!tmpStack.isEmpty())
        {
            inputStack.push(tmpStack.pop());
        }
    }
}
