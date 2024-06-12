package Programs.binarysearch;

import java.util.Spliterator;

public class MaximumValueataGivenIndexinaBoundedArray_1802 {
    public static void main(String[] args) {
        int n = 4;
        int index = 2;
        int maxSum = 6;
        System.out.println(findMaxValue(n,index,maxSum));    //---> Brute
        System.out.println(findMaxValueOptimal(n,index,maxSum)); // --------> Optimal

    }

    // Optimal -----------------------

    public static int findMaxValueOptimal(int n,int index,int maxSum){
        int result = 1; // Index Initial Value // We should maximize this

        maxSum -= n; // inially the array all ele set to 1 so decerse the maxSum - n
        int left = 0;
        int right = 0;
        int maxLeft = index;
        int maxRight = n - index - 1;

        while (maxSum > 0) {
            result++;

            int leftVal = Math.min(left++, maxLeft);
            int rightVal = Math.min(right++, maxRight);
            maxSum -= (1 + leftVal + rightVal);

            if (leftVal == maxLeft && rightVal == maxRight) break;
        }
        if (maxSum > 0){
            result = result + (maxSum / n);
        }
        return (maxSum < 0) ? result - 1 : result;
    }
    // BruteForce------------------
    public static int findMaxValue(int n, int index, int maxSum){
        int result = 1; // Index Initial Value // We should maximize this

        maxSum -= n; // inially the array all ele set to 1 so decerse the maxSum - n
        int left = 0;
        int right = 0;
        int maxLeft = index;
        int maxRight = n - index - 1;

        while (maxSum > 0){
            result++;

            int leftVal = Math.min(left++,maxLeft);
            int rightVal = Math.min(right++,maxRight);

            maxSum -= (1 + leftVal + rightVal);
        }
        return (maxSum < 0) ? result - 1 : result;
    }
}
