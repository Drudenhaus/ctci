package MyLibrary;

public class MyQueue
{
    MyStack enqueueStack;
    MyStack dequeueStack;

    public MyQueue()
    {
        this.enqueueStack = new MyStack();
        this.dequeueStack = new MyStack();
    }

    public int dequeue()
    {
        if (this.dequeueStack == null)
        {
            this.dequeueStack = new MyStack();
            while (this.enqueueStack.peek() != Integer.MAX_VALUE)
            {
                this.dequeueStack.push(this.enqueueStack.pop());
            }
        }

        if (this.dequeueStack.peek() == Integer.MAX_VALUE)
        {
            return Integer.MAX_VALUE;
        }
        else
        {
            this.enqueueStack = null;
        }
        int retVal = dequeueStack.pop();
        return retVal;
    }

    public void enqueue(int value)
    {
        if (this.enqueueStack == null)
        {
            this.enqueueStack = new MyStack();
            while (this.dequeueStack.peek() != Integer.MAX_VALUE)
            {
                this.enqueueStack.push(this.dequeueStack.pop());
            }
        }

        enqueueStack.push(value);
        dequeueStack = null;
    }

    private class MyStack
    {
        private StackNode top;

        public MyStack(){}

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

            public StackNode(int data, StackNode next)
            {
                this.data = data;
                this.next = next;
            }
        }
    }
}
