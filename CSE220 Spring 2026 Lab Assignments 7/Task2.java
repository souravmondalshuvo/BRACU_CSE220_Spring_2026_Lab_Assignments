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

    // ========================== Task 2a ==========================
    
    public static int[] Task2b (EdgeNode[] list) {

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
