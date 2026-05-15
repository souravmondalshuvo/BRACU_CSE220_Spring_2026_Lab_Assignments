public class Task4 {
    
    // ========================== Task 4a ==========================

    public static int[][] Task4a(int[][] directedMatrix) {


        int n = directedMatrix.length;
        int[][] undirectedMatrix = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                int totalWeight = directedMatrix[i][j] + directedMatrix[j][i];

                if(totalWeight != 0) {
                    undirectedMatrix[i][j] = totalWeight;
                    undirectedMatrix[j][i] = totalWeight;
                }
            }
        }


        return undirectedMatrix;
    }

    // ========================== Task 4b ==========================

    public static void addDirectedListEdge(EdgeNode[] list, int from, int to, int weight) {

        list[from] = new EdgeNode(to, weight, list[from]);
    }

    public static void addUndirectedListEdge(EdgeNode[] list, int u, int v, int weight) {

        addDirectedListEdge(list, u, v, weight);
        addDirectedListEdge(list, v, u, weight);
    }

    public static EdgeNode[] Task4b(EdgeNode[] directedList) {

        int n = directedList.length;
        int[][] weightMatrix = new int[n][n];

        for(int i = 0; i < n; i++) {
            EdgeNode current = directedList[i];

            while(current != null) {
                weightMatrix[i][current.to] += current.weight;
                current = current.next;
            }
        }

        EdgeNode[] undirectedList = new EdgeNode[n];

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                int totalWeight = weightMatrix[i][j] + weightMatrix[j][i];

                if(totalWeight != 0) {
                    addUndirectedListEdge(undirectedList, i, j, totalWeight);
                }
            }
        }

        return undirectedList;
    }
}
