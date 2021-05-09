package GraphWork;

public class Vertex2
{
    public char label;
    public boolean wasVisited;
    public int[] adjacencyMatrix;

    public Vertex2(char _name, int _maxSizeGraph)
    {
        this.label = _name;
        this.wasVisited = false;
        adjacencyMatrix = new int[_maxSizeGraph];
        for (int i = 0; i < _maxSizeGraph; i++)
        {
            adjacencyMatrix[i] = -1;
        }
    }

    public char getLabel()
    {
        return label;
    }

    public boolean isWasVisited()
    {
        return wasVisited;
    }

    public void setLabel(char label)
    {
        this.label = label;
    }

    public void setWasVisited(boolean wasVisited)
    {
        this.wasVisited = wasVisited;
    }

    public int[] getAdjacencyMatrix()
    {
        return adjacencyMatrix;
    }

    public void setAdjacencyMatrix(int position, int value)
    {
        if (position < adjacencyMatrix.length)
        {
            this.adjacencyMatrix[position] = value;
        }
    }
}
