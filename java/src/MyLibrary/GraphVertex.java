package MyLibrary;

import java.util.TreeSet;

public class GraphVertex implements Comparable<GraphVertex>
{
    public String name;
    public boolean visited;
    public int inDegree;
    public TreeSet<GraphVertex> successors;

    public GraphVertex(String name)
    {
        this.name = name;
        this.visited = false;
        this.inDegree = 0;
        this.successors = new TreeSet<GraphVertex>();
    }

    public void addSuccessor(GraphVertex successor)
    {
        if (! this.successors.contains(successor))
        {
            this.successors.add(successor);
            successor.inDegree++;
        }
    }

    public void removeSuccessor(GraphVertex successor)
    {
        if (this.successors.contains(successor))
        {
            this.successors.remove(successor);
            successor.inDegree--;
        }
    }

    @Override
    public int compareTo(GraphVertex otherVertex)
    {
        return this.name.compareTo(otherVertex.name);
    }
}
