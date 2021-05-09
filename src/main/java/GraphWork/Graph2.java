package GraphWork;

public class Graph2
{
    public int maxSizeGraph;
    private Vertex2[] vertexes;
    private int curSizeGraph;

    public Graph2(int _maxSizeGraph) // Создание нашего графа с вершинами
    {
        maxSizeGraph = _maxSizeGraph;
        vertexes = new Vertex2[maxSizeGraph];
        curSizeGraph = 0;
    }

    public void addVertex(char label) // Метод для добавления новой вершины
    {
        vertexes[curSizeGraph] = new Vertex2(label, this.maxSizeGraph);
        vertexes[curSizeGraph].setAdjacencyMatrix(curSizeGraph++, 0);
    }

    public void addEdge(int start, int end) // Метод добавления рёбер между вершинами
    {
        if (start != end)
        {
            if (vertexes[start].getAdjacencyMatrix()[start] == start)
            {
                vertexes[start].setAdjacencyMatrix(start, vertexes[start].getAdjacencyMatrix()[start] + 1);
            }
            vertexes[start].setAdjacencyMatrix(vertexes[start].getAdjacencyMatrix()[start], end);
            vertexes[start].setAdjacencyMatrix(start, vertexes[start].getAdjacencyMatrix()[start] + 1);
            if (vertexes[end].getAdjacencyMatrix()[end] == end)
            {
                vertexes[end].setAdjacencyMatrix(end, vertexes[end].getAdjacencyMatrix()[end] + 1);
            }
            vertexes[end].setAdjacencyMatrix(vertexes[end].getAdjacencyMatrix()[end], start);
            vertexes[end].setAdjacencyMatrix(end, vertexes[end].getAdjacencyMatrix()[end] + 1);
        }
    }

    private int getAdjUnvisitedVertex2(int ver) // Проверка смежности вершин
    {
        for (int i = 0; i < vertexes[ver].getAdjacencyMatrix()[ver]; i++)
        {
            if (ver != i)
            {
                if ((vertexes[ver].getAdjacencyMatrix()[i] >= 0) && (vertexes[vertexes[ver].getAdjacencyMatrix()[i]].isWasVisited() == false))
                {
                    return vertexes[ver].getAdjacencyMatrix()[i];
                }
            }
        }
        return -1;
    }

    public void goDeep2(int f, boolean flagOff) // Метод обхода в глубину. f - стартовая вершина
    {
        vertexes[f].setWasVisited(true);

        for (int i = 0; i < curSizeGraph; i++)
        {
            int v = getAdjUnvisitedVertex2(f);
            if ((vertexes[i].isWasVisited() == false) && (v != -1) && (i == v))
            {
                fullDisplayVertex(f, v);
                goDeep2(i, false);
            }
        }

        if (flagOff == true)
        {
            for (int i = 0; i < curSizeGraph; i++) // Подчищение графа, чтобы можно было сделать следующий обход
            {
                vertexes[i].setWasVisited(false);
            }
        }
    }



    public void goWide(int v) // Второй метод обхода в ширину
    {
        int[] queue = new int[curSizeGraph]; // Здесь очередь реализована в виде массива
        int qH = 0; // Индекс головы очереди
        int qT = 0; // Индекс хвоста очереди

        vertexes[v].setWasVisited(true); // Обозначаем, что посетили первое значение
        queue[qT++] = v;

        int tempInt = qT;
        while (tempInt < curSizeGraph) // Сравнение индексов начала и конца очереди
        {
            tempInt = qT;
            for (int i = qH; i < tempInt; i++) // Перебор новых вершин на текущем шаге
            {
                for (int j = 0; j < vertexes[queue[i]].getAdjacencyMatrix()[queue[i]]; j++) // Перебор связанных с текущим узлом узлов
                {
                    if (queue[i] != j)
                    {
                        if ((vertexes[queue[i]].getAdjacencyMatrix()[j] >= 0) && (vertexes[vertexes[queue[i]].getAdjacencyMatrix()[j]].isWasVisited() == false))
                        {
                            vertexes[vertexes[queue[i]].getAdjacencyMatrix()[j]].setWasVisited(true);
                            fullDisplayVertex(queue[i], vertexes[queue[i]].getAdjacencyMatrix()[j]);
                            queue[qT++] = vertexes[queue[i]].getAdjacencyMatrix()[j];
                        }
                    }
                }
            }
            qH = tempInt;
        }

        for (int i = 0; i < curSizeGraph; i++) // Сброс флагов, чтобы можно было пройти по графу ещё раз
        {
            vertexes[i].setWasVisited(false);
        }
    }

    public void displayVertex(int vertex) // Отображение вершины
    {
        System.out.println("Вершина " + vertexes[vertex].getLabel());
    }

    public void fullDisplayVertex(int vertex1, int vertex2)
    {
        System.out.println("Ребро " + vertexes[vertex1].getLabel() + "-" + vertexes[vertex2].getLabel());
    }
}
