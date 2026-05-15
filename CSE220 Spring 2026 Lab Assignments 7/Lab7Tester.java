public class Lab7Tester {

    public static void printAnswer(String taskName, int[] answer, String valueName) {
        System.out.println(taskName + ": Vertex = " + (answer[0] + 1) + ", " + valueName + " = " + answer[1]);
    }

    public static void main(String[] args) {
        int n = 7;

        int[][] undirectedWeightedMatrix = new int[n][n];
        EdgeNode[] undirectedWeightedList = new EdgeNode[n];

        int[][] undirectedUnweightedMatrix = new int[n][n];
        EdgeNode[] undirectedUnweightedList = new EdgeNode[n];

        int[][] directedWeightedMatrix = new int[n][n];
        EdgeNode[] directedWeightedList = new EdgeNode[n];

        // ===================== UNDIRECTED GRAPH =====================
        // Format: {from, to, weight}
        // Vertices are written as 0 to 6 internally.
        // When printed, they will be shown as 1 to 7.

        int[][] undirectedEdges = {
            {0, 1, 4},
            {0, 2, 3},
            {0, 3, 2},
            {1, 2, 5},
            {1, 4, 6},
            {2, 3, 7},
            {2, 5, 4},
            {3, 5, 1},
            {3, 6, 8},
            {4, 5, 2},
            {4, 6, 3},
            {5, 6, 6}
        };

        for (int i = 0; i < undirectedEdges.length; i++) {
            int u = undirectedEdges[i][0];
            int v = undirectedEdges[i][1];
            int w = undirectedEdges[i][2];

            // For weighted graph
            Task0.addUndirectedMatrixEdge(undirectedWeightedMatrix, u, v, w);
            Task0.addUndirectedListEdge(undirectedWeightedList, u, v, w);

            // For unweighted graph
            Task0.addUndirectedMatrixEdge(undirectedUnweightedMatrix, u, v, 1);
            Task0.addUndirectedListEdge(undirectedUnweightedList, u, v, 1);
        }

        // ===================== DIRECTED GRAPH =====================
        // Format: {from, to, weight}

        int[][] directedEdges = {
            {0, 1, 4},
            {0, 2, 3},
            {0, 3, 2},
            {1, 2, 5},
            {1, 4, 6},
            {2, 3, 7},
            {2, 5, 4},
            {3, 5, 1},
            {3, 6, 8},
            {4, 5, 2},
            {5, 4, 3},
            {6, 3, 5}
        };

        for (int i = 0; i < directedEdges.length; i++) {
            int from = directedEdges[i][0];
            int to = directedEdges[i][1];
            int w = directedEdges[i][2];

            Task0.addDirectedMatrixEdge(directedWeightedMatrix, from, to, w);
            Task0.addDirectedListEdge(directedWeightedList, from, to, w);
        }

        // ===================== TASK 0 =====================

        System.out.println("Task 0a: Adjacency Matrix");
        Task0.printMatrix(undirectedWeightedMatrix);

        System.out.println("\nTask 0b: Adjacency List");
        Task0.printList(undirectedWeightedList);

        // ===================== TASK 1 =====================

        System.out.println("\nTask 1a:");
        printAnswer("Task 1a", Task1.Task1a(undirectedUnweightedMatrix), "degree");

        System.out.println("\nTask 1b:");
        printAnswer("Task 1b", Task1.Task1b(undirectedUnweightedList), "degree");

        // ===================== TASK 2 =====================

        System.out.println("\nTask 2a:");
        printAnswer("Task 2a", Task2.Task2a(undirectedWeightedMatrix), "sum of edge weights");

        System.out.println("\nTask 2b:");
        printAnswer("Task 2b", Task2.Task2b(undirectedWeightedList), "sum of edge weights");

        // ===================== TASK 3 =====================

        System.out.println("\nTask 3a:");
        printAnswer(
            "Task 3a Maximum Outgoing Degree",
            Task3.Task3a_MaxOutgoingDegree(directedWeightedMatrix),
            "outgoing degree"
        );

        printAnswer(
            "Task 3a Maximum Outgoing Weight Sum",
            Task3.Task3a_MaxOutgoingWeightSum(directedWeightedMatrix),
            "outgoing weight sum"
        );

        System.out.println("\nTask 3b:");
        printAnswer(
            "Task 3b Maximum Outgoing Degree",
            Task3.Task3b_MaxOutgoingDegree(directedWeightedList),
            "outgoing degree"
        );

        printAnswer(
            "Task 3b Maximum Outgoing Weight Sum",
            Task3.Task3b_MaxOutgoingWeightSum(directedWeightedList),
            "outgoing weight sum"
        );

        // ===================== TASK 4 =====================

        System.out.println("\nTask 4a: Directed Matrix Converted to Undirected Matrix");
        int[][] convertedMatrix = Task4.Task4a(directedWeightedMatrix);
        Task0.printMatrix(convertedMatrix);

        System.out.println("\nTask 4b: Directed List Converted to Undirected List");
        EdgeNode[] convertedList = Task4.Task4b(directedWeightedList);
        Task0.printList(convertedList);
    }
}