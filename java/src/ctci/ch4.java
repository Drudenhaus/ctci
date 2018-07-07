package ctci;

import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;

import MyLibrary.GraphNode;
import MyLibrary.BinaryTreeNode;

public class ch4
{
    // #1
    public static boolean RouteBetweenNodes(GraphNode startNode, GraphNode destinationNode)
    {
        /*
         * Time complexity: O(n) with respect to the number of nodes in the graph
         * Space complexity: O(n) for the queue
         */
        ConcurrentLinkedQueue<GraphNode> graphNodeQueue = new ConcurrentLinkedQueue<GraphNode>();
        graphNodeQueue.add(startNode);

        while (graphNodeQueue.size() > 0)
        {
            GraphNode currentNode = graphNodeQueue.remove();
            
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

            for (GraphNode currentChild : currentNode.children)
            {
                graphNodeQueue.add(currentChild);
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

    // #4 TODO
    public static boolean CheckBalance(BinaryTreeNode inputNode)
    {
        /*
         * Time complexity: O(n)
         * Space complexity: 
         */
        return false;
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
}
