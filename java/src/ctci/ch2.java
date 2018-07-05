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

    public static <T> void DeleteDuplicatesFixedSpace(LinkedListNode inputNode)
    {
        /*
         * Time complexity: O(n^2)
         * Space complexity: O(1)
         */
        LinkedListNode currentNode = inputNode;
        while (currentNode != null)
        {
            LinkedListNode lookAheadNode = currentNode.next;
            while (lookAheadNode != null)
            {
                if (currentNode.data == lookAheadNode.data)
                {
                    lookAheadNode.next.setPrevious(lookAheadNode.prev);
                }
                lookAheadNode = lookAheadNode.next;
            }
            currentNode = currentNode.next;
        }
    }

    // #2
    public static LinkedListNode ReturnKthToLast(LinkedListNode inputNode, int k)
    {
        /*
         * Time complexity: O(n)
         * Space complexity: O(1)
         */
        if (inputNode == null || (k != 0 && inputNode.next == null))
        {
            return null;
        }

        int numNodes = 0;
        LinkedListNode currentNode = inputNode;
        while (currentNode.next != null)
        {
            numNodes++;
            currentNode = currentNode.next;
        }
        currentNode = inputNode;
        int currentPosition = 0;
        while (currentPosition < numNodes - k)
        {
            currentNode = currentNode.next;
            currentPosition++;
        }
        return currentNode;
    }

    public static LinkedListNode ReturnKthToLastSlightlyBetter(LinkedListNode inputNode, int k)
    {
        /*
         * Time complexity: O(n)
         * Space complexity: O(1)
         * Doesn't require the second traversal that's in ReturnKthToLast
         */
        LinkedListNode lookingForEnd = inputNode;
        LinkedListNode lookingForK = inputNode;
        for (int i = 0; i < k; i++)
        {
            if (lookingForEnd == null)
            {
                return null;
            }
            lookingForEnd = lookingForEnd.next;
        }

        while (lookingForEnd.next != null)
        {
            lookingForEnd = lookingForEnd.next;
            lookingForK = lookingForK.next;
        }

        return lookingForK;
    }

    // #3
    public static void DeleteMiddleNode(LinkedListNode inputNode)
    {
        /*
         * Time complexity: O(1)
         * Space complexity: O(1)
         */
        if (inputNode.next != null || inputNode != null)
        {
            LinkedListNode nextNode = inputNode.next;
            inputNode.data = nextNode.data;
            inputNode.setNext(nextNode.next);
        }
    }
}
