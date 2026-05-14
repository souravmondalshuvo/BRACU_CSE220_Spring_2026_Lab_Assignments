public class Task3 {
    
    // ========================== Task 3a ==========================

    public static int[] Task3a_MaxOutgoingDegree(int[][] matrix) {

        int maxVertex = -1;
        int maxOutDegree = -1;

        for(int i = 0; i < matrix.length; i++) {
            int outDegree = 0;

            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] != 0) {
                    outDegree++;
                }
            }

            if(outDegree > maxOutDegree) {
                maxOutDegree = outDegree;
                maxVertex = i;
            }
        }

        return new int[] {maxVertex, maxOutDegree};
    }

    public static int[] Task3a_MaxOutgoingWeightSum(int[][] matrix) {

        int maxVertex = -1;
        int maxWeightSum = -1;

        for(int i = 0; i < matrix.length; i++) {
            int weightSum = 0;

            for(int j = 0; j < matrix[i].length; j++) {
                weightSum += matrix[i][j];
            }

            if(weightSum > maxWeightSum) {
                maxWeightSum = weightSum;
                maxVertex = i;
            }
        }

        return new int[] {maxVertex, maxWeightSum};
    }
}
