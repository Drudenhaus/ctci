package ctci;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import MyLibrary.GraphNode;

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
}
