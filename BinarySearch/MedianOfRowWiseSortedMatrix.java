package Programs.striverz.BinarySearch;

public class MedianOfRowWiseSortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {8, 9, 11, 12, 13},
                {21, 23, 25, 27, 29}
        };
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = median(matrix, m, n);
        System.out.println("The median element is: " + ans);
    }

    private static int median(int[][] matrix, int R, int C) {
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int i = 0; i < R; i++) {
            low = Math.min(low, matrix[i][0]);
            high = Math.max(high, matrix[i][C - 1]);
        }
        int req = (R * C) / 2;

        while (low <= high){
            int mid = low + (high - low) / 2;

            int smallEqual = countSmallEqual(matrix, R, C, mid);
            if (smallEqual <= req){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return low;

    }
    private static int countSmallEqual(int[][] matrix, int R, int C,int X){
        int cnt = 0;
        for (int i = 0; i < R; i++) {
            cnt += upperBound(matrix[i],C,X);
        }
        return cnt;
    }

    private static int upperBound(int[] arr, int n, int x) {
        int low = 0;
        int high = n - 1;

        while (low <= high){
            int mid = low + (high - low) / 2;

            if (arr[mid] > x){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return low;
    }
}
