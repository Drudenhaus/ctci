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

    @Test
    void testDeleteDuplicatesFixedSpace()
    {
        LinkedListNode head = new LinkedListNode(1);
        LinkedListNode nodeTwo = new LinkedListNode(2);
        LinkedListNode nodeThree = new LinkedListNode(3);
        LinkedListNode nodeFour = new LinkedListNode(4);
        LinkedListNode nodeFive = new LinkedListNode(4);
        LinkedListNode tail = new LinkedListNode(5);

        head.last = head;
        head.setNext(nodeTwo);
        nodeTwo.setNext(nodeThree);
        nodeThree.setNext(nodeFour);
        nodeFour.setNext(nodeFive);
        nodeFive.setNext(tail);

        assertEquals("1->2->3->4->4->5", head.printForward());
        ch2.DeleteDuplicatesFixedSpace(head);
        assertEquals("1->2->3->4->5", head.printForward());
    }

    @Test void testDeleteMiddleNode()
    {
        LinkedListNode head = new LinkedListNode(1);
        LinkedListNode nodeTwo = new LinkedListNode(2);
        LinkedListNode nodeThree = new LinkedListNode(3);
        LinkedListNode nodeFour = new LinkedListNode(4);
        LinkedListNode nodeFive = new LinkedListNode(4);
        LinkedListNode tail = new LinkedListNode(5);

        head.last = head;
        head.setNext(nodeTwo);
        nodeTwo.setNext(nodeThree);
        nodeThree.setNext(nodeFour);
        nodeFour.setNext(nodeFive);
        nodeFive.setNext(tail);

        assertEquals("1->2->3->4->4->5", head.printForward());
        ch2.DeleteMiddleNode(nodeThree);
        assertEquals("1->2->4->4->5", head.printForward());
    }
}
