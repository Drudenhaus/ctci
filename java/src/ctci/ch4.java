package ctci;

import java.util.concurrent.ConcurrentLinkedQueue;

import MyLibrary.GraphNode;

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
}
