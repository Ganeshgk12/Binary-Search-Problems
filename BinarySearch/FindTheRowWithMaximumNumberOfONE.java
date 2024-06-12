package Programs.striverz.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;

public class FindTheRowWithMaximumNumberOfONE {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1},
                {0, 0, 1},
                {0, 0, 0}
        };

        int n = 3, m = 3;
        System.out.println("The row with the maximum number of 1's is: " +
                rowWithMax1s(matrix, n, m));
    }

    //Optimal
    public static int lowerBound(int[] arr, int n, int x) {
        int low = 0, high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr[mid] >= x) {
                ans = mid;
                // look for smaller index on the left
                high = mid - 1;
            } else {
                low = mid + 1; // look on the right
            }
        }
        return ans;
    }

    public static int rowWithMax1s(int[][] matrix, int n, int m) {
        int cnt_max = 0;
        int index = -1;

        // traverse the rows:
        for (int i = 0; i < n; i++) {
            // get the number of 1's:
            int cnt_ones = m - lowerBound(matrix[i], m, 1);
            if (cnt_ones > cnt_max) {
                cnt_max = cnt_ones;
                index = i;
            }
        }
        return index;
    }


    //Brute
    private static int rowWithMax1s(ArrayList<ArrayList<Integer>> matrix, int n, int m) {

        int cnt_max_ones = 0;
        int index = -1;

        for (int i = 0; i < n; i++) {
            int cnt_ones = 0;
            for (int j = 0; j < m; j++) {
                cnt_ones += matrix.get(i).get(j);
            }
            if (cnt_ones > cnt_max_ones) {
                cnt_max_ones = cnt_ones;
                index = i;
            }
        }
        return index;

    }
}
