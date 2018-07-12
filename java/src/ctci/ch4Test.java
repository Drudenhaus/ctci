package ctci;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import MyLibrary.GraphVertex;
import MyLibrary.BinaryTreeNode;

class ch4Test
{

    @Test
    void testRouteBetweenNodesSingleNode()
    {
        GraphVertex rootNode = new GraphVertex("root");
        GraphVertex nodeTwo = new GraphVertex("nodeTwo");
        GraphVertex nodeThree = new GraphVertex("nodeThree");
        GraphVertex nodeFour = new GraphVertex("nodeFour");
        GraphVertex nodeFive = new GraphVertex("nodeFive");
        GraphVertex nodeSix = new GraphVertex("nodeSix");
        GraphVertex nodeSeven = new GraphVertex("nodeSeven");

        rootNode.addSuccessor(nodeTwo);
        rootNode.addSuccessor(nodeThree);

        nodeTwo.addSuccessor(nodeFour);
        nodeTwo.addSuccessor(nodeFive);

        nodeThree.addSuccessor(nodeSix);
        nodeThree.addSuccessor(nodeSeven);

        assertTrue(ch4.RouteBetweenNodes(rootNode, nodeSeven));
    }

    @Test
    void testRouteBetweenNodesTrueWithLoop()
    {
        GraphVertex rootNode = new GraphVertex("root");
        GraphVertex nodeTwo = new GraphVertex("nodeTwo");
        GraphVertex nodeThree = new GraphVertex("nodeThree");
        GraphVertex nodeFour = new GraphVertex("nodeFour");
        GraphVertex nodeFive = new GraphVertex("nodeFive");
        GraphVertex nodeSix = new GraphVertex("nodeSix");
        GraphVertex nodeSeven = new GraphVertex("nodeSeven");

        rootNode.addSuccessor(nodeTwo);
        rootNode.addSuccessor(nodeThree);

        nodeTwo.addSuccessor(nodeFour);
        nodeTwo.addSuccessor(nodeFive);

        nodeThree.addSuccessor(rootNode);
        nodeThree.addSuccessor(nodeSix);
        nodeThree.addSuccessor(nodeSeven);

        assertTrue(ch4.RouteBetweenNodes(rootNode, nodeSeven));
    }

    @Test
    void testRouteBetweenNodesTrue()
    {
        GraphVertex rootNode = new GraphVertex("root");
        assertTrue(ch4.RouteBetweenNodes(rootNode, rootNode));
    }

    @Test
    void testRouteBetweenNodesFalse()
    {
        GraphVertex rootNode = new GraphVertex("root");
        GraphVertex nodeTwo = new GraphVertex("nodeTwo");
        GraphVertex nodeThree = new GraphVertex("nodeThree");
        GraphVertex nodeFour = new GraphVertex("nodeFour");
        GraphVertex nodeFive = new GraphVertex("nodeFive");
        GraphVertex nodeSix = new GraphVertex("nodeSix");
        GraphVertex nodeSeven = new GraphVertex("nodeSeven");

        rootNode.addSuccessor(nodeTwo);
        rootNode.addSuccessor(nodeThree);

        nodeTwo.addSuccessor(nodeFour);
        nodeTwo.addSuccessor(nodeFive);

        nodeThree.addSuccessor(nodeSix);
        nodeThree.addSuccessor(nodeSeven);
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

    @Test
    void testListOfDepths()
    {
        int[] intArray = {1, 2, 3, 4, 5, 6, 7};
        BinaryTreeNode rootNode = ch4.MinimalTree(intArray);
        LinkedList<LinkedList<BinaryTreeNode>> listOfDepths = ch4.ListOfDepths(rootNode);
        assertEquals(3, listOfDepths.size());

        // TODO there is surely a more elegant way to test this if I want to spend actual brain power on testing
        LinkedList<BinaryTreeNode> currentList = listOfDepths.getFirst();
        assertEquals(4, currentList.getFirst().data);

        currentList = listOfDepths.get(1);
        assertEquals(2, currentList.getFirst().data);
        assertEquals(6, currentList.get(1).data);

        currentList = listOfDepths.get(2);
        assertEquals(1, currentList.getFirst().data);
        assertEquals(3, currentList.get(1).data);
        assertEquals(5, currentList.get(2).data);
        assertEquals(7, currentList.get(3).data);
    }

    @Test
    void testCheckBalancedTrue()
    {
        int[] intArray = {1, 2, 3, 4, 5, 6, 7};
        BinaryTreeNode rootNode = ch4.MinimalTree(intArray);
        assertTrue(ch4.CheckBalance(rootNode));
    }

    @Test
    void testCheckBalancedFalse()
    {
        int[] intArray = {1, 2, 3, 4, 5, 6, 7};
        BinaryTreeNode rootNode = ch4.MinimalTree(intArray);
        rootNode.left.left.left = new BinaryTreeNode(9);
        rootNode.left.left.left.right = new BinaryTreeNode(9);
        // Tree is now has a maximum height difference of 2
        assertFalse(ch4.CheckBalance(rootNode));
    }

    @Test
    void testCheckBSTTrue()
    {
        int[] intArray = {1, 2, 3, 4, 5, 6, 7};
        BinaryTreeNode rootNode = ch4.MinimalTree(intArray);
        assertTrue(ch4.ValidateBST(rootNode));
    }

    @Test
    void testCheckBSTInCompleteLevelTrue()
    {
        int[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        BinaryTreeNode rootNode = ch4.MinimalTree(intArray);
        assertTrue(ch4.ValidateBST(rootNode));
    }

    @Test
    void testValidateBSTFalse()
    {
        int[] intArray = {1, 2, 3, 4, 5, 7, 6};
        BinaryTreeNode rootNode = ch4.MinimalTree(intArray);
        assertFalse(ch4.ValidateBST(rootNode));
    }

    @Test
    void testValidateBSTUIncompleteLevelFalse()
    {
        int[] intArray = {1, 2, 3, 4, 5, 7, 6, -1, 5};
        BinaryTreeNode rootNode = ch4.MinimalTree(intArray);
        assertFalse(ch4.ValidateBST(rootNode));
    }

    @Test
    void testValidateBSTURightChildOfLeftGreaterThanRootFalse()
    {
        /*
         * Looks like this:
                4
            2       6
           1 3     5 7
              10 <- bad node placement
         */
        int[] intArray = {1, 2, 3, 4, 5, 6, 7};
        BinaryTreeNode rootNode = ch4.MinimalTree(intArray);
        rootNode.left.right.right = new BinaryTreeNode(10);
        assertFalse(ch4.ValidateBST(rootNode));
    }

    @Test
    void testSuccessorNullReturnsNull()
    {
        assertEquals(null, ch4.Successor(null));
    }

    @Test
    void testSuccessorAllNodes()
    {
        /*
         * Looks like this:
              4
            2   6
           1 3 5 7
         */
        BinaryTreeNode rootNode = new BinaryTreeNode(4);
        BinaryTreeNode oneNode = new BinaryTreeNode(1);
        BinaryTreeNode twoNode = new BinaryTreeNode(2);
        BinaryTreeNode threeNode = new BinaryTreeNode(3);
        BinaryTreeNode fiveNode = new BinaryTreeNode(5);
        BinaryTreeNode sixNode = new BinaryTreeNode(6);
        BinaryTreeNode sevenNode = new BinaryTreeNode(7);

        rootNode.setLeftChild(twoNode);
        rootNode.setRightChild(sixNode);
        twoNode.setLeftChild(oneNode);
        twoNode.setRightChild(threeNode);
        sixNode.setLeftChild(fiveNode);
        sixNode.setRightChild(sevenNode);

        assertEquals(5, ch4.Successor(rootNode).data);
        assertEquals(2, ch4.Successor(oneNode).data);
        assertEquals(3, ch4.Successor(twoNode).data);
        assertEquals(4, ch4.Successor(threeNode).data);
        assertEquals(5, ch4.Successor(rootNode).data);
        assertEquals(6, ch4.Successor(fiveNode).data);
        assertEquals(7, ch4.Successor(sixNode).data);
        assertEquals(null, ch4.Successor(sevenNode));
    }

    @Test
    void testBuildOrder()
    {
        // a, b, c, d, e,f 
        // (a, d), (f, b), (b, d), (f, a), (d, c)
        // f, e, a, b, d, c
        GraphVertex aVertex = new GraphVertex("a");
        GraphVertex bVertex = new GraphVertex("b");
        GraphVertex cVertex = new GraphVertex("c");
        GraphVertex dVertex = new GraphVertex("d");
        GraphVertex eVertex = new GraphVertex("e");
        GraphVertex fVertex = new GraphVertex("f");
        LinkedList<GraphVertex> projectList = new LinkedList<GraphVertex>();
        projectList.add(aVertex);
        projectList.add(bVertex);
        projectList.add(cVertex);
        projectList.add(dVertex);
        projectList.add(eVertex);
        projectList.add(fVertex);

        LinkedList<LinkedList<GraphVertex>> dependencyList = new LinkedList<LinkedList<GraphVertex>>();

        LinkedList<GraphVertex> adDep = new LinkedList<GraphVertex>();
        adDep.add(aVertex);
        adDep.add(dVertex);
        dependencyList.add(adDep);

        LinkedList<GraphVertex> fbDep = new LinkedList<GraphVertex>();
        fbDep.add(fVertex);
        fbDep.add(bVertex);
        dependencyList.add(fbDep);

        LinkedList<GraphVertex> bdDep = new LinkedList<GraphVertex>();
        bdDep.add(bVertex);
        bdDep.add(dVertex);
        dependencyList.add(bdDep);

        LinkedList<GraphVertex> faDep = new LinkedList<GraphVertex>();
        faDep.add(fVertex);
        faDep.add(aVertex);
        dependencyList.add(faDep);

        LinkedList<GraphVertex> dcDep = new LinkedList<GraphVertex>();
        dcDep.add(dVertex);
        dcDep.add(cVertex);
        dependencyList.add(dcDep);

        LinkedList<GraphVertex> buildOrder = ch4.BuildOrder(projectList, dependencyList);
        StringBuilder orderStringBuilder = new StringBuilder();
        for (GraphVertex vertex : buildOrder)
        {
            orderStringBuilder.append(vertex.name);
        }
        // The TreeSet maintains an order so this can be tested reliably
        assertEquals("efabdc", orderStringBuilder.toString());
    }

    // TODO test case with cycle but there exists a starting vertex
    // TODO test case with cycle and no starting vertex
    // TODO test case with null projectList
    // TODO test case with null dependencyList
}
