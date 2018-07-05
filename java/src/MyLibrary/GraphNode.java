package MyLibrary;

import java.util.LinkedList;

public class GraphNode
{
    public String name;
    public boolean visited = false;
    public LinkedList<GraphNode> children;
    
    public GraphNode(String name)
    {
        this.name = name;
        this.children = new LinkedList<GraphNode>();
    }

    public void addChild(GraphNode childNode)
    {
        this.children.add(childNode);
    }
}
