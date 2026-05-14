public class Task2 {
    
    // ========================== Task 2a ==========================

    public static int[] Task2a (int[][] matrix) {

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
