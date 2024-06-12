package Programs.binarysearch;

import java.util.Arrays;

public class Ssearch2DMatrixVariety2 {
    public static void main(String[] args) {
        int [][] mat = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        System.out.println(Arrays.toString(search(mat,14)));
    }

    public static int[] search(int [][] mat,int target){
        int rows = mat.length;
        int cols = mat[0].length;

        int midCol = cols / 2;

        if (rows == 1){
            return bs(mat,0,0,cols - 1,target);
        }

        int rStart = 0;
        int rEnd = rows - 1;

        while (rStart < (rEnd - 1)){
            int mid = rStart + (rEnd - rStart) / 2;

            if (mat[mid][midCol] == target){
                return new int []{mid,midCol};
            }
            if (mat[mid][midCol] > target){
                rEnd = mid;
            }else {
                rStart = mid;
            }
        }

        if (mat[rStart][midCol] == target){
            return new int[] {rStart,midCol};
        }
        if (mat[rStart + 1][midCol] == target){
            return new int[] {rStart + 1,midCol};
        }

        if (target <= mat[rStart][midCol - 1]){
            return bs(mat,rStart,0,midCol - 1,target);
        }
        if (target >= mat[rStart][midCol + 1] && target <= mat[rStart][cols - 1]){
            return bs(mat,rStart,midCol + 1,cols - 1,target);
        }
        if (target <= mat[rStart + 1][midCol - 1]){
            return bs(mat,rStart + 1,0,midCol - 1,target);
        }
        else {
            return bs(mat,rStart + 1,midCol + 1,cols - 1,target);
        }

    }

    public static int[] bs(int [][] mat,int row,int cStart,int cEnd,int target){
        while (cStart <= cEnd){
            int mid = cStart + (cEnd - cStart) / 2;

            if (mat[row][mid] == target){
                return new int[]{row,mid};
            } else if (mat[row][mid] > target) {
                cEnd = mid - 1;
            }else {
                cStart = mid + 1;
            }
        }
        return new int[] {-1,-1};
    }
}
