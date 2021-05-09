package GraphWork;

public class Graph1
{
    private int maxSizeGraph;
    private Vertex[] vertexes;
    private int[][] adjacencyMatrix;
    private int curSizeGraph;

    public Graph1(int _maxSizeGraph) // Создание нашего графа с вершинами
    {
        maxSizeGraph = _maxSizeGraph;
        vertexes = new Vertex[maxSizeGraph];
        adjacencyMatrix = new int[maxSizeGraph][maxSizeGraph];
        curSizeGraph = 0;
        for (int i = 0; i < curSizeGraph; i++)
        {
            for (int j = 0; j < curSizeGraph; j++)
            {
                adjacencyMatrix[i][j] = 0; // Заполняем матрицу смежности начальными значениями, чтобы она не была пустой
                // На данном этапе у нас нет ещё ни одного ребра между вершинами
            }
        }
    }

    public void addVertex(char label) // Метод для добавления новой вершины
    {
        vertexes[curSizeGraph++] = new Vertex(label);
    }

    public void addEdge(int start, int end) // Метод добавления связей между вершинами
    // Автоматически задать связи между вершинами нельзя, потому что в графе нужно связать какие-то особенные вершины, а какие-то вершины связанными быть не должны
    {
        adjacencyMatrix[start][end] = 1; // Здесь мы добавляем связь от A к B
        adjacencyMatrix[end][start] = 1; // Здесь мы добавляем связь от B к A
    }

    private int getAdjUnvisitedVertex(int ver) // Проверка смежности вершин
    {
        for (int i = 0; i < curSizeGraph; i++)
        {
            if ((adjacencyMatrix[ver][i] == 1) && (vertexes[i].isWasVisited() == false))
            {
                return i;
            }
        }
        return -1;
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
                for (int j = 0; j < curSizeGraph; j++) // Перебор связанных с текущим узлом узлов
                {
                    if ((adjacencyMatrix[queue[i]][j] == 1) && (vertexes[j].isWasVisited() == false))
                    {
                        vertexes[j].setWasVisited(true);
                        fullDisplayVertex(queue[i], j);
                        queue[qT++] = j;
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

    public void goDeep(int f, boolean flagOff) // Метод обхода в глубину. f - стартовая вершина
    {
        vertexes[f].setWasVisited(true);

        for (int i = 0; i < curSizeGraph; i++)
        {
            int v = getAdjUnvisitedVertex(f);
            if ((vertexes[i].isWasVisited() == false) && (v != -1) && (i == v))
            {
                fullDisplayVertex(f, v);
                goDeep(i, false);
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

    public void displayVertex(int vertex) // Отображение вершины
    {
        System.out.println("Вершина " + vertexes[vertex].getLabel());
    }

    public void fullDisplayVertex(int vertex1, int vertex2)
    {
        System.out.println("Ребро " + vertexes[vertex1].getLabel() + "-" + vertexes[vertex2].getLabel());
    }
}
