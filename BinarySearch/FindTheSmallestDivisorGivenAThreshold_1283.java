package Programs.striverz.BinarySearch;

public class FindTheSmallestDivisorGivenAThreshold_1283 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 9};
        int threshold = 6;
        System.out.println(smallestDivisor(nums, threshold));
    }



    public static int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;

        if (n > threshold) return -1;

        int maxi = Integer.MIN_VALUE;

        for (int x : nums) {
            if (x > maxi) maxi = x;
        }

        int start = 1;
        int end = maxi;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (sumOfDivisors(nums,mid) <= threshold) {
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return start;
    }
    private static int sumOfDivisors(int [] arr,int div) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {

            sum += Math.ceil((double) arr[i] / (double) div);
        }
        return sum;
    }
}