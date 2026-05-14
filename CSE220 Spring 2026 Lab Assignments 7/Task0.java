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

    // ========================== Task 0b ==========================    

    public static void addDirectedListEdge(EdgeNode[] list, int from, int to, int weight) {

        list[from] = new EdgeNode(to, weight, list[from]);
    }

    public static void addUndirectedListEdge(EdgeNode[] list, int u, int v, int weight) {

        addDirectedListEdge(list, u, v, weight);
        addDirectedListEdge(list, v, u, weight);
    }

    public static void printList(EdgeNode[] list) {

        for(int i = 0; i < list.length; i++) {
            System.out.print((i + 1) + " -> ");

            EdgeNode current = list[i];

            while(current != null) {
                System.out.println("(" + (current.to + 1) + ", w=" + current.weight + ") ");
                current = current.next;
            }

            System.out.println();
        }
    }
}
