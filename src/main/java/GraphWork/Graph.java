package GraphWork;

import java.util.LinkedList;
import java.util.Queue;

public class Graph
{
    private final int MAX_VERTS = 32;
    private Vertex[] vertexList;
    private int[][] adjMat;
    private int size;

    public Graph() // Конструктор класса
    {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS]; // Матрица смежности
        size = 0;
        for (int i = 0; i < MAX_VERTS; i++)
        {
            for (int j = 0; j < MAX_VERTS; j++)
            {
                adjMat[i][j] = 0;
            }
        }
    }

    public void addVertex(char label) // Метод добавления вершины
    {
        vertexList[size++] = new Vertex(label);
    }

    public void addEdge(int start, int end) // Метод создания связей
    {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    private int getAdjUnvisitedVertex(int ver) // Метод проверки смежных вершин
    {
        for (int i = 0; i < size; i++)
        {
            if (adjMat[ver][i] == 1 && vertexList[i].wasVisited == false)
            {
                return i;
            }
        }

        return -1;
    }

    public void bfs2(int v) // Второй метод обхода в ширину
    {
        int[] queue = new int[size]; // Здесь очередь реализована в виде массива
        int qH = 0; // Индекс головы очереди
        int qT = 0; // Индекс хвоста очереди
        int v2;
        boolean firstLoop = true;
        boolean globalExit = false;
        boolean goNext = false;

        while (true)
        {
            if (firstLoop == true)
            {
                queue[qT++] = v;
                firstLoop = false;
            }
            else
            {
                globalExit = true;
                qH = 0;
                qT = 0;
                for (int i = 0; i < size; i++)
                {
                    if (vertexList[i].wasVisited == false)
                    {
                        queue[qT++] = i;
                        globalExit = false;
                        break;
                    }
                }
                if (globalExit == true)
                {
                    break;
                }
            }
            while (qH < qT) // Сравнение индексов начала и конца очереди
            {
                v = queue[qH++];

                goNext = false;
                for (int i = 0; i < size; i++)
                {
                    v2 = getAdjUnvisitedVertex(v); // Здесь идёт перебор всех вершин, связанных с вершиной v
                    if (v2 != -1 && !vertexList[v2].wasVisited) // Условие v2 != -1 должно быть первым, чтобы не возникло ошибки во втором условии, когда v2 будет равно -1
                    {
                        vertexList[v2].wasVisited = true;
                        fullDisplayVertex(v, v2);
                        queue[qT++] = v2;
                        goNext = true;
                    }
                }

                if ((goNext == false) && (vertexList[v].isWasVisited() == false))
                {
                    displayVertex(v);
                }
                vertexList[v].wasVisited = true;
            }
        }

        for (int i = 0; i < size; i++) // Сброс флагов, чтобы можно было пройти по графу ещё раз
        {
            vertexList[i].wasVisited = false;
        }
    }

    public void displayVertex(int vertex)
    {
        System.out.println("Вершина " + vertexList[vertex].label);
    }

    public void fullDisplayVertex(int vertex1, int vertex2)
    {
        System.out.println("Ребро " + vertexList[vertex1].label + "-" + vertexList[vertex2].label);
    }
}
