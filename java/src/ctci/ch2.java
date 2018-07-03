package ctci;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

import CtCILibrary.LinkedListNode;

public class ch2
{
    // #1
    public static <T> void DeleteDuplicatesWithHashSet(LinkedList<T> inputList)
    {
        /*
         * Time complexity: O(n) n = length of the LinkedList
         * Space complexity: O(n) to store the HashSet
         */
        HashSet<T> hashedValues = new HashSet<T>();
        Iterator<T> myIterator = inputList.iterator();
        while (myIterator.hasNext())
        {
            T item = myIterator.next();
            if (hashedValues.contains(item))
            {
                myIterator.remove();
            }
            else
            {
                hashedValues.add(item);
            }
        }
    }

    // #3 TODO
    public static void DeleteMiddleNode(LinkedListNode inputNode)
    {
        
    }
}
