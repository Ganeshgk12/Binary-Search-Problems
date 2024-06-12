package Programs.binarysearch;

import java.util.Arrays;

public class FindPeakElementII_1091 {
    public static void main(String[] args) {
        int [][] matrix = {{10,20,15},
                           {21,30,14},
                           {7,16,32}};
        System.out.println(Arrays.toString(findPeakGrid(matrix)));


    }

    public static int[] findPeakGrid(int[][] mat){
        int start = 0;
        int end = mat[0].length - 1;

        while (start <= end){            // To Find Middle Col

            int mid = start + (end - start) / 2;
            int maxRow = findMaxElementRowInMidCol(mat,mid);

            // left - mid - 1 col , right - mid + 1
            int left = mid - 1 >= 0 ? mat[maxRow][mid - 1] : -1;
            int right = mid + 1 > mat.length ? mat[maxRow][mid + 1] : -1;

            if (mat[maxRow][mid] > left && mat[maxRow][mid] > right){
                return new int[]{maxRow,mid};
            } else if (mat[maxRow][mid] < left) {  // right col are removed
                end = mid - 1;
            }else {                                // left cols are removed
                start = mid + 1;
            }
        }
        return new int[]{-1,-1};

    }
    private static int findMaxElementRowInMidCol(int [][] mat,int col){
        int max = 0;
        int index = -1;

        for (int i = 0; i < mat.length; i++) {
            if (mat[i][col] > max) {
                max = mat[i][col];
                index = i;
            }
        }
        return index;
    }
}
