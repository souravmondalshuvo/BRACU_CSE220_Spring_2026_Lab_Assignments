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
}
