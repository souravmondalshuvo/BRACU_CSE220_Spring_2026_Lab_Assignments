//Assignment Task 02: Matrix Compression
class AssgnTask2{

    //Complete this method so that it gives the Expected Output
    //YOU ONLY HAVE TO SUBMIT THIS METHOD, NO OTHER DRIVER CODE
    public static Integer[][] compressMatrix( Integer[][] matrix ){

        //For this task you'll need to create new 2D array
        
        //TO DO

        int row = matrix.length;
        int column = matrix[0].length;

        int new_row = row / 2;
        int new_column = column / 2;

        Integer[][] compressed_2D_matrix = new Integer[new_row][new_column];

        for(int i = 0; i < new_row; i++) {
            for(int j = 0; j < new_column; j++) {

                int matrix_row = 2 * i;
                int matrix_column = 2 * j;

                int summed_up_matrix = matrix[matrix_row][matrix_column] + matrix[matrix_row][matrix_column + 1] + matrix[matrix_row + 1][matrix_column] + matrix[matrix_row + 1][matrix_column + 1];

                compressed_2D_matrix[i][j] = summed_up_matrix;
            }
        }

        //remove the line below and return the newly created Compressed 2D matrix
        // return null;
        return compressed_2D_matrix;
    }

    //DO NOT CHANGE ANY DRIVER CODE BELOW THIS LINE
    public static void main(String[] args){
        Integer[][] matrix = {
            { 1 , 2 , 3 , 4 },
            { 5 , 6 , 7 , 8 },
            { 1 , 3 , 5 , 2 },
            {-2 , 0 , 6 ,-3 }
        };
        System.out.println("Given Matrix: ");
        Arr.print2D(matrix);
        
        System.out.println("\nExpected Output:");
        System.out.print("| 14 | 22 |\n| 2  | 10 |\n");
        
        System.out.print("\nYour Output:\n");
        Integer[][] returnedArray = compressMatrix( matrix );
        Arr.print2D( returnedArray );
    }
}