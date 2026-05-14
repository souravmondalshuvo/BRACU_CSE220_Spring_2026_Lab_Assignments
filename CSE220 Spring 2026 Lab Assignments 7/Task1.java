public class Task1 {

    // ========================== Task 1a ==========================

    public static int[] Task1a(int[][] matrix) {

        int maxDegree = -1;
        int maxVertex = -1;

        for(int i = 0; i < matrix.length; i++) {
            
            int degree = 0;

            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] != 0) {
                    degree++;
                }
            }

            if(degree > maxDegree) {
                maxDegree = degree;
                maxVertex = i;
            }
        }

        return new int[] {maxVertex, maxDegree};
    }
}
