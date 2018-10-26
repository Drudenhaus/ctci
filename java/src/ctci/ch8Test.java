package ctci;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ch8Test
{
    @Test
    void testTripleStepTen()
    {
        assertEquals(4, ch8.TripleStep(3));
    }

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
