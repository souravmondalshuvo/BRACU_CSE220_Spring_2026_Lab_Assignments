public class Task0 {
    
    // ========================== Task 0a ==========================

    public static void addUndirectedMatrixEdge(int[][] matrix, int u, int v, int weight) {

        matrix[u][v] = weight;
        matrix[v][u] = weight;
    }

    public static void addDirectedMatrixEdge(int[][] matrix, int from, int to, int weight) {

        matrix[from][to] = weight;
    }

    public static void printMatrix(int[][] matrix) {

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }

            System.out.println();
        }
    }
}
