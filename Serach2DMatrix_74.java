package Programs.binarysearch;

public class Serach2DMatrix_74 {
    public static void main(String[] args) {
        int [][] matrix = {{1,3,5,7},
                           {10,11,16,20},
                           {23,30,34,60}};

        int target = 60;
        System.out.println(searchMatrix(matrix,target));
    }

    public static boolean searchMatrix(int[][] matrix, int target){
        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0){
            if (matrix[row][col] < target){
                row++;
            } else if (matrix[row][col] > target) {
                col--;
            }else {
                return true;
            }
        }
        return false;
    }
}
