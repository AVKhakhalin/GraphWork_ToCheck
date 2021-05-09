package GraphWork;

public class MainApp
{
    public static final int NUMBER_VERTIXES = 6;
    public static long curTime;
    public static int counter;

    public static void main(String[] args)
    {
        System.out.println("\nДомашнее задание №7 студента университета GeekBrains Хахалина Андрея Владимировича\n");

        //region Решение задания 7.1
        System.out.println("\nРешение задания 7.1\n");
        /* Задание 7.1
        Приведите пример графа. */
        System.out.println("Примеры графа: " +
                "\n7.1.1. Молекула ДНК." +
                "\n7.1.2. Сетка водородных связей в водной среде." +
                "\n7.1.3. Организационная структура предприятия." +
                "\n7.1.4. Содержание книги или справочника." +
                "\n7.1.5. Биологическая нейронная сеть.");
        System.out.println("Визуальный пример графа:\n" +
                "                                2---5\n" +
                "                               / \\\n" +
                "                              1---3---6\n" +
                "                               \\ /\n" +
                "                                4");
        //endregion---------------------------------------------

        //region Решение задания 7.2
        System.out.println("\nРешение задания 7.2\n");
        /* Задание 7.2
        Реализуйте базовые методы графа. */

        System.out.println("\nРеализация графа Graph:");
        Graph graph = new Graph();
        graph.addVertex('A'); //Вершина 0
        graph.addVertex('B'); //Вершина 1
        graph.addVertex('C'); //Вершина 2
        graph.addVertex('D'); //Вершина 3
        graph.addVertex('E'); //Вершина 4
        graph.addVertex('H'); //Вершина 5
        graph.addEdge(0, 1); //AB
        graph.addEdge(1, 2); //BC
        graph.addEdge(0, 3); //AD
        graph.addEdge(3, 4); //DE
        graph.addEdge(0, 5); //AH
        System.out.println("Вершины графа:");
        for (counter = 0; counter < NUMBER_VERTIXES; counter++)
        {
            graph.displayVertex(counter);
        }
        System.out.println("Ребра графа:");
        graph.fullDisplayVertex(0, 1);
        graph.fullDisplayVertex(1, 2);
        graph.fullDisplayVertex(0, 3);
        graph.fullDisplayVertex(3, 4);
        graph.fullDisplayVertex(0, 5);

        System.out.println("\nРеализация графа Graph1:");
        Graph1 graph1 = new Graph1(NUMBER_VERTIXES);
        graph1.addVertex('A'); //Вершина 0
        graph1.addVertex('B'); //Вершина 1
        graph1.addVertex('C'); //Вершина 2
        graph1.addVertex('D'); //Вершина 3
        graph1.addVertex('E'); //Вершина 4
        graph1.addVertex('H'); //Вершина 5
        graph1.addEdge(0, 1); //AB
        graph1.addEdge(1, 2); //BC
        graph1.addEdge(0, 3); //AD
        graph1.addEdge(3, 4); //DE
        graph1.addEdge(0, 5); //AH
        System.out.println("Вершины графа:");
        for (counter = 0; counter < NUMBER_VERTIXES; counter++)
        {
            graph1.displayVertex(counter);
        }
        System.out.println("Ребра графа:");
        graph1.fullDisplayVertex(0, 1);
        graph1.fullDisplayVertex(1, 2);
        graph1.fullDisplayVertex(0, 3);
        graph1.fullDisplayVertex(3, 4);
        graph1.fullDisplayVertex(0, 5);

        System.out.println("\nРеализация графа Graph2:");
        Graph2 graph2 = new Graph2(NUMBER_VERTIXES);
        graph2.addVertex('A'); //Вершина 0
        graph2.addVertex('B'); //Вершина 1
        graph2.addVertex('C'); //Вершина 2
        graph2.addVertex('D'); //Вершина 3
        graph2.addVertex('E'); //Вершина 4
        graph2.addVertex('H'); //Вершина 5
        graph2.addEdge(0, 1); //AB
        graph2.addEdge(1, 2); //BC
        graph2.addEdge(0, 3); //AD
        graph2.addEdge(3, 4); //DE
        graph2.addEdge(0, 5); //AH
        System.out.println("Вершины графа:");
        for (counter = 0; counter < NUMBER_VERTIXES; counter++)
        {
            graph2.displayVertex(counter);
        }
        System.out.println("Ребра графа:");
        graph2.fullDisplayVertex(0, 1);
        graph2.fullDisplayVertex(1, 2);
        graph2.fullDisplayVertex(0, 3);
        graph2.fullDisplayVertex(3, 4);
        graph2.fullDisplayVertex(0, 5);
        System.out.println();
        //endregion---------------------------------------------

        //region Решение задания 7.3
        System.out.println("\nРешение задания 7.3\n");
        /* Задание 7.3
        В программный код из задания 7.2 добавьте реализацию метода обхода в глубину.
        Выполните оценку времени с помощью System.nanoTime(). */

        System.out.println("Реализация метода обхода в глубину с помощью рекурсии, полученная на лекции:");
        curTime = System.nanoTime();
        graph1.goDeep(0, true); // Не оптимизированный метод обхода графа в глубину (матрица смежности не оптимизирована)
        System.out.println("Время: " + (System.nanoTime() - curTime) + " нс.");
        System.out.println("\nРеализация оптимизированного метода обхода в глубину с помощью рекурсии (оптимизирована матрица смежности):");
        curTime = System.nanoTime();
        graph2.goDeep2(0, true); // Оптимизированный метод обхода графа в глубину (оптимизирована матрица смежности)
        System.out.println("Время: " + (System.nanoTime() - curTime) + " нс.\n");
        //endregion---------------------------------------------

        //region Решение задания 7.4
        System.out.println("\nРешение задания 7.4\n");
        /* Задание 7.4
        В базовом графе из задания 7.2 реализуйте метод обхода в ширину.
        Выполните оценку времени с помощью System.nanoTime(). */

        System.out.println("Исправленный метод обхода в ширину, полученный на лекции:");
        curTime = System.nanoTime();
        graph.bfs2(0);
        System.out.println("Время: " + (System.nanoTime() - curTime) + " нс.");
        System.out.println("\nРеализация неоптимизированного метода обхода в ширину:");
        curTime = System.nanoTime();
        graph1.goWide(0);
        System.out.println("Время: " + (System.nanoTime() - curTime) + " нс.");
        System.out.println("\nРеализация оптимизированного метода обхода в ширину (оптимизирована матрица смежности)");
        curTime = System.nanoTime();
        graph2.goWide(0);
        System.out.println("Время: " + (System.nanoTime() - curTime) + " нс.");
        //endregion---------------------------------------------
    }
}
