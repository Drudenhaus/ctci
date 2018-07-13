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

    @Test
    void testReturnKthToLast()
    {
        LinkedListNode head = new LinkedListNode(1); // first/fifth to last
        LinkedListNode nodeTwo = new LinkedListNode(2); // fourth to last
        LinkedListNode nodeThree = new LinkedListNode(3); // third to last
        LinkedListNode nodeFour = new LinkedListNode(4); // second to last
        LinkedListNode nodeFive = new LinkedListNode(5); // next (first) to last
        LinkedListNode tail = new LinkedListNode(6); // last

        head.setNext(nodeTwo);
        nodeTwo.setNext(nodeThree);
        nodeThree.setNext(nodeFour);
        nodeFour.setNext(nodeFive);
        nodeFive.setNext(tail);

        assertEquals(nodeThree, ch2.ReturnKthToLast(head, 3));
    }

    @Test
    void testReturnKthToLastSlightlyBetter()
    {
        LinkedListNode head = new LinkedListNode(1); // first/fifth to last
        LinkedListNode nodeTwo = new LinkedListNode(2); // fourth to last
        LinkedListNode nodeThree = new LinkedListNode(3); // third to last
        LinkedListNode nodeFour = new LinkedListNode(4); // second to last
        LinkedListNode nodeFive = new LinkedListNode(5); // next (first) to last
        LinkedListNode tail = new LinkedListNode(6); // last

        head.setNext(nodeTwo);
        nodeTwo.setNext(nodeThree);
        nodeThree.setNext(nodeFour);
        nodeFour.setNext(nodeFive);
        nodeFive.setNext(tail);

        assertEquals(nodeThree, ch2.ReturnKthToLastSlightlyBetter(head, 3));
    }

    @Test
    void testDeleteMiddleNode()
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

    @Test
    void testPartition()
    {
        LinkedListNode head = new LinkedListNode(3);
        LinkedListNode nodeTwo = new LinkedListNode(5);
        LinkedListNode nodeThree = new LinkedListNode(8);
        LinkedListNode nodeFour = new LinkedListNode(5);
        LinkedListNode nodeFive = new LinkedListNode(10);
        LinkedListNode nodeSix = new LinkedListNode(2);
        LinkedListNode tail = new LinkedListNode(1);
        head.setNext(nodeTwo);
        nodeTwo.setNext(nodeThree);
        nodeThree.setNext(nodeFour);
        nodeFour.setNext(nodeFive);
        nodeFive.setNext(nodeSix);
        nodeSix.setNext(tail);
        ch2.Partition(head, 5);
        assertEquals("3->1->2->5->10->8->5", head.printForward());
    }

    @Test
    void testPartitionLTAll()
    {
        LinkedListNode head = new LinkedListNode(3);
        LinkedListNode nodeTwo = new LinkedListNode(5);
        LinkedListNode nodeThree = new LinkedListNode(8);
        LinkedListNode nodeFour = new LinkedListNode(5);
        LinkedListNode nodeFive = new LinkedListNode(10);
        LinkedListNode nodeSix = new LinkedListNode(2);
        LinkedListNode tail = new LinkedListNode(1);
        head.setNext(nodeTwo);
        nodeTwo.setNext(nodeThree);
        nodeThree.setNext(nodeFour);
        nodeFour.setNext(nodeFive);
        nodeFive.setNext(nodeSix);
        nodeSix.setNext(tail);
        ch2.Partition(head, 0);
        assertEquals("3->5->8->5->10->2->1", head.printForward());
    }

    @Test
    void testPartitionGTAll()
    {
        LinkedListNode head = new LinkedListNode(3);
        LinkedListNode nodeTwo = new LinkedListNode(5);
        LinkedListNode nodeThree = new LinkedListNode(8);
        LinkedListNode nodeFour = new LinkedListNode(5);
        LinkedListNode nodeFive = new LinkedListNode(10);
        LinkedListNode nodeSix = new LinkedListNode(2);
        LinkedListNode tail = new LinkedListNode(1);
        head.setNext(nodeTwo);
        nodeTwo.setNext(nodeThree);
        nodeThree.setNext(nodeFour);
        nodeFour.setNext(nodeFive);
        nodeFive.setNext(nodeSix);
        nodeSix.setNext(tail);
        ch2.Partition(head, 11);
        assertEquals("3->5->8->5->10->2->1", head.printForward());
    }
}
