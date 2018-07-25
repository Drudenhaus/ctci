package ctci;

import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;

import MyLibrary.Graph;
import MyLibrary.GraphVertex;
import MyLibrary.BinaryTreeNode;

public class ch4
{
    // #1
    public static boolean RouteBetweenNodes(GraphVertex startNode, GraphVertex destinationNode)
    {
        /*
         * Time complexity: O(n) with respect to the number of nodes in the graph
         * Space complexity: O(n) for the queue
         */
        ConcurrentLinkedQueue<GraphVertex> graphVertexQueue = new ConcurrentLinkedQueue<GraphVertex>();
        graphVertexQueue.add(startNode);

        while (graphVertexQueue.size() > 0)
        {
            GraphVertex currentNode = graphVertexQueue.remove();
            
            if (currentNode.visited)
            {
                continue;
            }

            currentNode.visited = true;

            // Or pick your choice of equivalence testing
            if (currentNode.name.equals(destinationNode.name))
            {
                return true;
            }

            for (GraphVertex currentChild : currentNode.successors)
            {
                graphVertexQueue.add(currentChild);
            }
        }
        return false;
    }

    // #2
    public static BinaryTreeNode MinimalTree(int[] intArray)
    {
        /*
         * Time complexity: O(n) with respect to the length of the array
         * Space complexity: O(n) for the tree and stack space for recursive calls
         * Returns the root tree node
         */
        return getMinimalTree(intArray, 0, intArray.length - 1);
    }

    public static BinaryTreeNode getMinimalTree(int[] intArray, int start, int end)
    {
        // Base case
        if (start > end)
        {
            return null;
        }
        int mid = (start + end) / 2;
        BinaryTreeNode rootNode = new BinaryTreeNode(intArray[mid]);
        rootNode.left = getMinimalTree(intArray, start, mid - 1);
        rootNode.right = getMinimalTree(intArray, mid + 1, end);
        return rootNode;
    }

    // #3
    public static LinkedList<LinkedList<BinaryTreeNode>> ListOfDepths(BinaryTreeNode inputNode)
    {
        /*
         * Time complexity: O(n) with respect to the number of nodes in the tree
         * Space complexity: O(n)
         */
        if (inputNode == null)
        {
            return null;
        }

        LinkedList<LinkedList<BinaryTreeNode>> listOfDepths = new LinkedList<LinkedList<BinaryTreeNode>>();
        LinkedList<BinaryTreeNode> currentLevel = new LinkedList<BinaryTreeNode>();
        currentLevel.add(inputNode);
        listOfDepths.add(currentLevel);
        LinkedList<BinaryTreeNode> lastLevel = currentLevel;
        while (true)
        {
            currentLevel = new LinkedList<BinaryTreeNode>();
            for (BinaryTreeNode currentNode : lastLevel)
            {
                if (currentNode.left != null)
                {
                    currentLevel.add(currentNode.left);
                }
                if (currentNode.right != null)
                {
                    currentLevel.add(currentNode.right);
                }
            }

            if (currentLevel.size() == 0)
            {
                break;
            }

            listOfDepths.add(currentLevel);
            lastLevel = currentLevel;
        }

        return listOfDepths;
    }

    // #4
    public static boolean CheckBalance(BinaryTreeNode inputNode)
    {
        /*
         * Time complexity: O(n) with respect to the number of nodes
         * Space complexity: O(n) stack space with respect to the height of the tree (e.g. root->right->right->return->left->return->return)
         */
        return getHeight(inputNode) > 0;
    }

    public static int getHeight(BinaryTreeNode inputNode)
    {
        if (inputNode == null)
        {
            return 0;
        }

        int rightHeight = getHeight(inputNode.right);
        int leftHeight = getHeight(inputNode.left);

        if ((rightHeight == -1) || (leftHeight == -1))
        {
            return -1;
        }

        if (Math.abs(rightHeight - leftHeight) > 1)
        {
            return -1;
        }
        return Math.max(rightHeight,  leftHeight) + 1;
    }

    // #5 
    public static boolean ValidateBST(BinaryTreeNode inputNode)
    {
        /*
         * Time complexity: O(n) with respect to the number of nodes in the tree
         * Space complexity: O(log n) stack space for recursive calls
         */
        if (inputNode == null)
        {
            return false;
        }

        return ValidateBST(inputNode, null, null);
    }

    public static boolean ValidateBST(BinaryTreeNode inputNode, Integer lowerBound, Integer upperBound)
    {
        if (inputNode == null)
        {
            return true;
        }

        // Adding bounds checking works best with individual node checking rather than my prior approach of testing the left and right nodes
        if ((lowerBound != null && inputNode.data <= lowerBound) || (upperBound != null && inputNode.data > upperBound))
        {
            return false;
        }

        if (ValidateBST(inputNode.left, lowerBound, inputNode.data) && ValidateBST(inputNode.right, inputNode.data, upperBound))
        {
            return true;
        }
        return false;
    }

    // #6
    public static BinaryTreeNode Successor(BinaryTreeNode inputNode)
    {
        /*
         * Time complexity: O(log n) with respect to the size of the tree
         * Space complexity: O(1)
         */
        if (inputNode == null)
        {
            return null;
        }

        // If right subtree exists return the left most node in the subtree
        if (inputNode.right != null)
        {
            return GetLeft(inputNode.right);
        }
        // Return the correct parent node (or null if the last node)
        else
        {
            BinaryTreeNode parentNode = inputNode.parent;
            // Return the first parent node whose left child we traversed
            // or null if we go all the way up the tree (indicative of trying to find the parent of the last node)
            while (parentNode != null && parentNode.left != inputNode)
            {
                inputNode = parentNode;
                parentNode = parentNode.parent;
            }
            return parentNode;
        }
    }

    public static BinaryTreeNode GetLeft(BinaryTreeNode inputNode)
    {
        if (inputNode == null)
        {
            return null;
        }

        while (inputNode.left != null)
        {
            inputNode = inputNode.left;
        }
        return inputNode;
    }

    // #7
    public static LinkedList<GraphVertex> BuildOrder(LinkedList<GraphVertex> projects, LinkedList<LinkedList<GraphVertex>> dependencies)
    {
        /*
         * Time complexity: O(n + e) with respect to the number of vertices (projects) and edges (dependencies)
         * Space complexity: O(n) with respect to the number of vertices (projects) to store the graph and queue
         */
        if (projects == null || projects.size() == 0)
        {
            return null;
        }
        if (dependencies == null || projects.size() == 0)
        {
            return projects;
        }

        LinkedList<GraphVertex> projectOrder = new LinkedList<GraphVertex>();

        // Construct directed graph
        Graph projectGraph = new Graph();
        for (GraphVertex project : projects)
        {
            projectGraph.addVertex(project);
        }

        for (LinkedList<GraphVertex> vertexPair : dependencies)
        {
            vertexPair.getFirst().addSuccessor(vertexPair.getLast());
        }

        // KHAAAAAAN!
        // Begin topological sort
        ConcurrentLinkedQueue<GraphVertex> graphVertexQueue = new ConcurrentLinkedQueue<GraphVertex>();
        for (GraphVertex currentVertex : projects)
        {
            if (currentVertex.inDegree == 0)
            {
                graphVertexQueue.add(currentVertex);
            }
        }

        // No starting point due to cycles (circular dependencies)
        if (graphVertexQueue.size() == 0)
        {
            return null;
        }

        while (graphVertexQueue.size() != 0)
        {
            GraphVertex currentVertex = graphVertexQueue.poll();
            projectOrder.add(currentVertex);
            for (GraphVertex successor : currentVertex.successors)
            {
                successor.inDegree--;
                if (successor.inDegree == 0)
                {
                    graphVertexQueue.add(successor);
                }
            }
        }

        // There exists at least one cycle (circular dependency)
        if (projectOrder.size() != projects.size())
        {
            return null;
        }

        return projectOrder;
    }

    // #8
    public static BinaryTreeNode FirstCommonAncestor(BinaryTreeNode nodeA, BinaryTreeNode nodeB)
    {
        /*
         * Time complexity: O(n) with respect to the height of the tree
         * Space complexity: O(1)
         */
        if (nodeA == null || nodeB == null)
        {
            return null;
        }

        // Make nodeA and nodeB the same height
        int nodeADepth = getDepthUsingParentReference(nodeA);
        int nodeBDepth = getDepthUsingParentReference(nodeB);
        int heightDifference = Math.abs(nodeADepth - nodeBDepth);
        if (nodeADepth > nodeBDepth)
        {
            nodeA = traverseUpwardsUsingParentReference(nodeA, heightDifference);
        }
        else if (nodeBDepth > nodeADepth)
        {
            nodeB = traverseUpwardsUsingParentReference(nodeB, heightDifference);
        }

        // nodeA and nodeB are now the same height
        while (nodeA.parent != null)
        {
            nodeA = nodeA.parent;
            nodeB = nodeB.parent;
            if (nodeA == nodeB)
            {
                return nodeA;
            }
        }
        return null;

    }

    private static int getDepthUsingParentReference(BinaryTreeNode node)
    {
        int depth = 0;
        while (node.parent != null)
        {
            depth++;
            node = node.parent;
        }
        return depth;
    }

    private static BinaryTreeNode traverseUpwardsUsingParentReference(BinaryTreeNode node, int count)
    {
        if (count == 0 || node == null)
        {
            return null;
        }
        for (int i = 0; i < count; i++)
        {
            node = node.parent;
        }
        return node;
    }

    public static BinaryTreeNode RecursiveFirstCommonAncestor(BinaryTreeNode rootNode, BinaryTreeNode nodeA, BinaryTreeNode nodeB)
    {
        /*
         * Time complexity: O(n) with respect to the height of the tree
         * Space complexity: O(n) with respect to the height of the tree for stack space
         */
        if (rootNode == null || nodeA == null || nodeB == null || !IsInSubTree(rootNode, nodeA) || !IsInSubTree(rootNode, nodeB))
        {
            return null;
        }

        return GetFirstCommonAncestor(rootNode, nodeA, nodeB);
    }

    private static BinaryTreeNode GetFirstCommonAncestor(BinaryTreeNode rootNode, BinaryTreeNode nodeA, BinaryTreeNode nodeB)
    {
        if (rootNode == nodeA || rootNode == nodeB || rootNode == null)
        {
            return rootNode;
        }

        boolean nodeAInLeft = IsInSubTree(rootNode.left, nodeA);
        boolean nodeBInLeft = IsInSubTree(rootNode.left, nodeB);
        // If not in the same subtree then this is a common ancestor
        if (nodeAInLeft != nodeBInLeft)
        {
            return rootNode;
        }

        // Nodes must be in the same subtree so recurse into whichever that is
        if (nodeAInLeft)
        {
            return GetFirstCommonAncestor(rootNode.left, nodeA, nodeB);
        }
        else
        {
            return GetFirstCommonAncestor(rootNode.right, nodeA, nodeB);
        }
    }

    private static boolean IsInSubTree(BinaryTreeNode subTreeRootNode, BinaryTreeNode node)
    {
        if (subTreeRootNode == null)
        {
            return false;
        }
        else if (subTreeRootNode == node)
        {
            return true;
        }

        return IsInSubTree(subTreeRootNode.left, node) || IsInSubTree(subTreeRootNode.right, node);
    }

    // #10
    public static boolean CheckSubtree(BinaryTreeNode mainTreeNode, BinaryTreeNode subtreeNode)
    {
        /*
         * Time complexity: O(n + s*r)
         * Space complexity: O(logs + l) stack space and queue
         * n = size of tree being searched/parent tree
         * s = size of subtree
         * r = instances of subtreeNode in mainTreeNode
         * l = number of nodes in the largest level of the searched/main tree
         * Assumption: Being a subtree means the subtree contains the node objects of the searched/parent tree.
         *             As such, this tests for reference equality rather than value equality.
         */
        LinkedList<BinaryTreeNode> nodeQueue = new LinkedList<BinaryTreeNode>();
        nodeQueue.add(mainTreeNode);

        while (nodeQueue.size() > 0)
        {
            BinaryTreeNode currentNode = nodeQueue.remove();
            if (currentNode == null)
            {
                continue;
            }

            // Or pick your choice of equivalence testing
            if (currentNode == subtreeNode)
            {
                if (RecursiveCheckSubtree(currentNode, subtreeNode))
                {
                    return true;
                }
            }

            nodeQueue.add(currentNode.left);
            nodeQueue.add(currentNode.right);
        }
        return false;
    }

    private static boolean RecursiveCheckSubtree(BinaryTreeNode mainTreeNode, BinaryTreeNode subtreeNode)
    {
        if (subtreeNode == null)
        {
            return true;
        }
        else if (mainTreeNode != subtreeNode)
        {
            return false;
        }

        return RecursiveCheckSubtree(mainTreeNode.left, subtreeNode.left) && RecursiveCheckSubtree(mainTreeNode.right, subtreeNode.right);
    }
}
