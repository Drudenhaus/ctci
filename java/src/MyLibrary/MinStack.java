package MyLibrary;

// # 3.2
public class MinStack
{
    private StackNode top;

    public MinStack(){}

    // I guess Integer.MAX_VALUE is a standard way of indicating no value since I cannot return null for a primitive return type?
    public int peekMin()
    {
        if (this.top == null)
        {
            return Integer.MAX_VALUE;
        }
        return this.top.min;
    }

    public int peek()
    {
        if (this.top == null)
        {
            return Integer.MAX_VALUE;
        }
        return this.top.data;
    }

    public int pop()
    {
        int retValue = this.top.data;
        this.top = this.top.next;
        return retValue;
    }

    public void push(int data)
    {
        StackNode newTop = new StackNode(data, this.top);
        this.top = newTop;
    }

    private class StackNode
    {
        private int data;
        private StackNode next;
        private int min;

        public StackNode(int data, StackNode next)
        {
            this.data = data;
            this.next = next;
            if (next == null || data <= next.data)
            {
                this.min = data;
            }
            else
            {
                this.min = next.min;
            }
        }
    }
}
