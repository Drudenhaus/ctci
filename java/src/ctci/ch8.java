package ctci;

import java.util.ArrayList;
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

    //# 4
    public static LinkedList<ArrayList<Integer>> PowerSet(ArrayList<Integer> inputSet, int position)
    {
        /*
         * Set is a misnomer here. I'm using lists to represent the idea of a set in non-comp sci terms.
         * 
         * Time complexity: O(n * 2^n) with respect to the number of elements in the "set"
         *                  n * -> size of a set can be up to the size of the input set
         *                  2^n -> each element of the input set can be selected or not select
         * Space complexity: O(n * 2^n)
         */
        LinkedList<ArrayList<Integer>> allSets = new LinkedList<ArrayList<Integer>>();
        if (inputSet.size() == position)
        {
            // Base case -- start with empty set then build up from there
            allSets.add(new ArrayList<Integer>());           
        }
        else
        {
            // By adding the recursive call first, we'll go through the elements until none remain, add
            // the empty set, and build up in reverse order of the set
            allSets = PowerSet(inputSet, position + 1);
            int currentItem = inputSet.get(position);
            LinkedList<ArrayList<Integer>> smallerSubSets = new LinkedList<ArrayList<Integer>>();
            for (ArrayList<Integer> currentset : allSets)
            {
                ArrayList<Integer> builtSet = new ArrayList<Integer>();
                builtSet.add(currentItem);
                builtSet.addAll(currentset);
                smallerSubSets.add(builtSet);
            }
            allSets.addAll(smallerSubSets);
        }
        
        return allSets;
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
