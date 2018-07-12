package MyLibrary;

import java.util.LinkedList;

public class Graph
{
    public LinkedList<GraphVertex> vertices;

    public Graph()
    {
        this.vertices = new LinkedList<GraphVertex>();
    }

    public void addVertex(GraphVertex newNode)
    {
        this.vertices.add(newNode);
    }

    public void addEdge(GraphVertex parent, GraphVertex successor)
    {
        parent.addSuccessor(successor);
    }
}
