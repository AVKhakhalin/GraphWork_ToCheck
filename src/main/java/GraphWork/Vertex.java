package GraphWork;

public class Vertex
{
    public char label;
    public boolean wasVisited;

    public Vertex(char _name)
    {
        this.label = _name;
        this.wasVisited = false;
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
}
