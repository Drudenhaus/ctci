package ctci;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ch8Test
{
    // #1
    @Test
    void testTripleStepTen()
    {
        assertEquals(4, ch8.TripleStep(3));
    }

    // #4
    @Test
    void testPowerSet()
    {
        ArrayList<Integer> inputSet = new ArrayList<Integer>(Arrays.asList(1,2,3));
        LinkedList<ArrayList<Integer>> expectantSets = new LinkedList<ArrayList<Integer>>();
        expectantSets.add(new ArrayList<Integer>());
        expectantSets.add(new ArrayList<Integer>(Arrays.asList(3)));
        expectantSets.add(new ArrayList<Integer>(Arrays.asList(2)));
        expectantSets.add(new ArrayList<Integer>(Arrays.asList(2, 3)));
        expectantSets.add(new ArrayList<Integer>(Arrays.asList(1)));
        expectantSets.add(new ArrayList<Integer>(Arrays.asList(1, 3)));
        expectantSets.add(new ArrayList<Integer>(Arrays.asList(1, 2)));
        expectantSets.add(new ArrayList<Integer>(Arrays.asList(1, 2, 3)));
        assertEquals(expectantSets, ch8.PowerSet(inputSet, 0));
    }

    // #8
    @Test
    void testPermutationWithoutDups()
    {
        LinkedList<String> results = ch8.PermutationsWithoutDups("abc");
        LinkedList<String> expected = new LinkedList<String>();
        expected.add("abc");
        expected.add("acb");
        expected.add("bac");
        expected.add("bca");
        expected.add("cab");
        expected.add("cba");
        assertEquals(expected, results);
    }
}
