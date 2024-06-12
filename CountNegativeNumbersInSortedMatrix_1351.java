package Programs.binarysearch;

public class CountNegativeNumbersInSortedMatrix_1351 {
    public static void main(String[] args) {
        int [][] mat = {{4,3,2,-1},
                        {3,2,1,-1},
                        {1,1,-1,-2},
                        {-1,-1,-2,-3}
                        };
        System.out.println(search(mat));
    }
    public static int search(int [][] grid){
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        int row = 0;
        int col = cols - 1;

        while (row < rows && col >= 0) {
            if (grid[row][col] < 0) {
                count += rows - row;
                col--;
            }
            else{
                row++;
            }
        }

        return count;
    }
}
