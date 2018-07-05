package ctci;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import MyLibrary.GraphNode;
import MyLibrary.BinaryTreeNode;

class ch4Test
{

    @Test
    void testRouteBetweenNodesSingleNode()
    {
        GraphNode rootNode = new GraphNode("root");
        GraphNode nodeTwo = new GraphNode("nodeTwo");
        GraphNode nodeThree = new GraphNode("nodeThree");
        GraphNode nodeFour = new GraphNode("nodeFour");
        GraphNode nodeFive = new GraphNode("nodeFive");
        GraphNode nodeSix = new GraphNode("nodeSix");
        GraphNode nodeSeven = new GraphNode("nodeSeven");

        rootNode.addChild(nodeTwo);
        rootNode.addChild(nodeThree);

        nodeTwo.addChild(nodeFour);
        nodeTwo.addChild(nodeFive);

        nodeThree.addChild(nodeSix);
        nodeThree.addChild(nodeSeven);

        assertTrue(ch4.RouteBetweenNodes(rootNode, nodeSeven));
    }

    @Test
    void testRouteBetweenNodesTrueWithLoop()
    {
        GraphNode rootNode = new GraphNode("root");
        GraphNode nodeTwo = new GraphNode("nodeTwo");
        GraphNode nodeThree = new GraphNode("nodeThree");
        GraphNode nodeFour = new GraphNode("nodeFour");
        GraphNode nodeFive = new GraphNode("nodeFive");
        GraphNode nodeSix = new GraphNode("nodeSix");
        GraphNode nodeSeven = new GraphNode("nodeSeven");

        rootNode.addChild(nodeTwo);
        rootNode.addChild(nodeThree);

        nodeTwo.addChild(nodeFour);
        nodeTwo.addChild(nodeFive);

        nodeThree.addChild(rootNode);
        nodeThree.addChild(nodeSix);
        nodeThree.addChild(nodeSeven);

        assertTrue(ch4.RouteBetweenNodes(rootNode, nodeSeven));
    }

    @Test
    void testRouteBetweenNodesTrue()
    {
        GraphNode rootNode = new GraphNode("root");
        assertTrue(ch4.RouteBetweenNodes(rootNode, rootNode));
    }

    @Test
    void testRouteBetweenNodesFalse()
    {
        GraphNode rootNode = new GraphNode("root");
        GraphNode nodeTwo = new GraphNode("nodeTwo");
        GraphNode nodeThree = new GraphNode("nodeThree");
        GraphNode nodeFour = new GraphNode("nodeFour");
        GraphNode nodeFive = new GraphNode("nodeFive");
        GraphNode nodeSix = new GraphNode("nodeSix");
        GraphNode nodeSeven = new GraphNode("nodeSeven");

        rootNode.addChild(nodeTwo);
        rootNode.addChild(nodeThree);

        nodeTwo.addChild(nodeFour);
        nodeTwo.addChild(nodeFive);

        nodeThree.addChild(nodeSix);
        nodeThree.addChild(nodeSeven);
        assertFalse(ch4.RouteBetweenNodes(nodeTwo, rootNode));
    }

    @Test
    void testMinimalTree()
    {
        /*
         * Looks like this:
              4
            2   6
           1 3 5 7
         */
        int[] intArray = {1, 2, 3, 4, 5, 6, 7};
        BinaryTreeNode rootNode = ch4.MinimalTree(intArray);
        assertEquals(4, rootNode.data);
        assertEquals(2, rootNode.left.data);
        assertEquals(1, rootNode.left.left.data);
        assertEquals(3, rootNode.left.right.data);

        assertEquals(6, rootNode.right.data);
        assertEquals(5, rootNode.right.left.data);
        assertEquals(7, rootNode.right.right.data);
    }
}
