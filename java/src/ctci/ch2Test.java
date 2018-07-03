package ctci;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.LinkedList;

import CtCILibrary.LinkedListNode;

class ch2Test
{
    @Test
    void testDeleteDuplicatesWithHashSet()
    {
        LinkedList<Integer> myList = new LinkedList<Integer>();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(4);
        myList.add(5);
        ch2.DeleteDuplicatesWithHashSet(myList);
        assertEquals(5, myList.size());
        assertEquals("[1, 2, 3, 4, 5]", myList.toString());
    }
}
