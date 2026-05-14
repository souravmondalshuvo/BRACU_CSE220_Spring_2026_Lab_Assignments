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

    // ========================== Task 3b ==========================

    public static int[] Task3b_MaxOutgoingDegree(EdgeNode[] list) {

        int maxVertex = -1;
        int maxOutDegree = -1;

        for(int i = 0; i < list.length; i++) {
            int outDegree = 0;

            EdgeNode current = list[i];

            while(current != null) {
                outDegree++;
                current = current.next;
            }

            if(outDegree > maxOutDegree) {
                maxOutDegree = outDegree;
                maxVertex = i;
            }
        }

        return new int[] {maxVertex, maxOutDegree};
    }

    public static int[] Task3b_MaxOutgoingWeightSum(EdgeNode[] list) {


        int maxVertex = -1;
        int maxWeightSum = -1;

        for(int i = 0; i < list.length; i++) {
            int weightSum = 0;
            
            EdgeNode current = list[i];

            while(current != null) {
                weightSum += current.weight;
                current = current.next;
            }

            if(weightSum > maxWeightSum) {
                maxWeightSum = weightSum;
                maxVertex = i;
            }
        }

        return new int[] {maxVertex, maxWeightSum};
    }
}
