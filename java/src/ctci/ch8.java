package ctci;

import java.util.LinkedList;

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

    // #7
    public static LinkedList<String> PermutationsWithoutDups(String inpuStr)
    {
        /*
         * Time complexity: O(n!) with respect to the length of the input string
         * Space complexity: O(n) stack space, O(n!) linked list elements
         */
        LinkedList<String> results = new LinkedList<String>();
        PermutationsWithoutDups("", inpuStr, results);
        return results;
    }

    private static void PermutationsWithoutDups(String prefix, String suffix, LinkedList<String> results)
    {
        if (suffix.length() == 0)
        {
            results.add(prefix);
        }
        for (int charPos = 0; charPos < suffix.length(); charPos++)
        {
            PermutationsWithoutDups(prefix + suffix.charAt(charPos), 
                    suffix.substring(0,  charPos) + suffix.substring(charPos + 1, suffix.length()), 
                    results);
        }
    }
}
