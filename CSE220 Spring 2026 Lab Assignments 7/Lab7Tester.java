import java.util.ArrayList;

public class Lab7Tester {
    
    public static void main(String[] args) {
    // Task 0
    int[][] adjMatrix = buildAdjMatrix(N, edgesUndirected, false);
    ArrayList<ArrayList<int[]>> adjList = buildAdjList(N, edgesUndirected, false);
    System.out.println("=== Task 0a: Adjacency Matrix ===");
    printMatrix(adjMatrix);
    System.out.println("\n=== Task 0b: Adjacency List ===");
    printAdjList(adjList);

    // Task 1
    int[] r;
    r = maxDegreeMatrix(adjMatrix);
    System.out.println("\nTask 1a -> Vertex " + r[0] + " has max degree = " + r[1]);
    r = maxDegreeList(adjList);
    System.out.println("Task 1b -> Vertex " + r[0] + " has max degree = " + r[1]);

    // Task 2
    r = maxWeightSumMatrix(adjMatrix);
    System.out.println("\nTask 2a -> Vertex " + r[0] + " has max weight-sum = " + r[1]);
    r = maxWeightSumList(adjList);
    System.out.println("Task 2b -> Vertex " + r[0] + " has max weight-sum = " + r[1]);

    // Task 3
    int[][] adjMatrixDir = buildAdjMatrix(N, edgesDirected, true);
    ArrayList<ArrayList<int[]>> adjListDir = buildAdjList(N, edgesDirected, true);

    r = maxOutDegreeMatrix(adjMatrixDir);
    System.out.println("\nTask 3a -> Max out-degree: vertex " + r[0] + ", degree = " + r[1]);
    r = maxOutWeightSumMatrix(adjMatrixDir);
    System.out.println("Task 3a -> Max out-weight-sum: vertex " + r[0] + ", sum = " + r[1]);
    r = maxOutDegreeList(adjListDir);
    System.out.println("Task 3b -> Max out-degree: vertex " + r[0] + ", degree = " + r[1]);
    r = maxOutWeightSumList(adjListDir);
    System.out.println("Task 3b -> Max out-weight-sum: vertex " + r[0] + ", sum = " + r[1]);

    // Task 4
    int[][] undirMatrix = directedToUndirectedMatrix(adjMatrixDir);
    System.out.println("\n=== Task 4a: Directed -> Undirected (Matrix) ===");
    printMatrix(undirMatrix);
    ArrayList<ArrayList<int[]>> undirList = directedToUndirectedList(adjListDir);
    System.out.println("\n=== Task 4b: Directed -> Undirected (List) ===");
    printAdjList(undirList);
}
}
