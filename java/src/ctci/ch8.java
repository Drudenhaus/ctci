package ctci;

public class ch8
{
    // #1
    public static int TripleStep(int numSteps)
    {
        /*
         * Time complexity: 3^n with respect to the number of steps
         * Space complexity: O(n) stack space
         * 
         * Could be optimized using memoization
         */
        if (numSteps < 0)
        {
            return 0;
        }
        else if (numSteps == 0)
        {
            return 1;
        }
        return TripleStep(numSteps - 1) + TripleStep(numSteps - 2) + TripleStep(numSteps - 3);
    }
}
