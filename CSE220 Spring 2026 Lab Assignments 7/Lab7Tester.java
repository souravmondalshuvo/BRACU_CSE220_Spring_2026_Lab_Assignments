public class Lab7Tester {
    
    public static void main(String[] args) {
        int n = 7;

        int[][] undirectedWeightedMatrix = new int[n][n];
        EdgeNode[] undirectedWeightedList = new EdgeNode[n];

        int[][] undirectedUnweightedMatrix = new int[n][n];
        EdgeNode[] undirectedUnweightedList = new EdgeNode[n];

        int[][] directedWeightedMatrix = new int[n][n];
        EdgeNode[] directedWeightedList = new EdgeNode[n];

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

            addUndirectedMatrixEdge(undirectedWeightedMatrix, u, v, w);
            addUndirectedListEdge(undirectedWeightedList, u, v, w);

            addUndirectedMatrixEdge(undirectedUnweightedMatrix, u, v, 1);
            addUndirectedListEdge(undirectedUnweightedList, u, v, 1);
        }

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

            addDirectedMatrixEdge(directedWeightedMatrix, from, to, w);
            addDirectedListEdge(directedWeightedList, from, to, w);
        }

        System.out.println("Task 0a: Adjacency Matrix");
        printMatrix(undirectedWeightedMatrix);

        System.out.println("\nTask 0b: Adjacency List");
        printList(undirectedWeightedList);

        System.out.println("\nTask 1a:");
        printAnswer("Task 1a", Task1a(undirectedUnweightedMatrix), "degree");

        System.out.println("\nTask 1b:");
        printAnswer("Task 1b", Task1b(undirectedUnweightedList), "degree");

        System.out.println("\nTask 2a:");
        printAnswer("Task 2a", Task2a(undirectedWeightedMatrix), "sum of edge weights");

        System.out.println("\nTask 2b:");
        printAnswer("Task 2b", Task2b(undirectedWeightedList), "sum of edge weights");

        System.out.println("\nTask 3a:");
        printAnswer("Task 3a Maximum Outgoing Degree", Task3a_MaxOutgoingDegree(directedWeightedMatrix), "outgoing degree");
        printAnswer("Task 3a Maximum Outgoing Weight Sum", Task3a_MaxOutgoingWeightSum(directedWeightedMatrix), "outgoing weight sum");

        System.out.println("\nTask 3b:");
        printAnswer("Task 3b Maximum Outgoing Degree", Task3b_MaxOutgoingDegree(directedWeightedList), "outgoing degree");
        printAnswer("Task 3b Maximum Outgoing Weight Sum", Task3b_MaxOutgoingWeightSum(directedWeightedList), "outgoing weight sum");

        System.out.println("\nTask 4a: Directed Matrix Converted to Undirected Matrix");
        int[][] convertedMatrix = Task4a(directedWeightedMatrix);
        printMatrix(convertedMatrix);

        System.out.println("\nTask 4b: Directed List Converted to Undirected List");
        EdgeNode[] convertedList = Task4b(directedWeightedList);
        printList(convertedList); 
    }
}
