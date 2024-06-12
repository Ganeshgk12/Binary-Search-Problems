package Programs.binarysearch;

import java.util.Arrays;

public class FrequencyOfTheMostFrequentElement_1838 {
    public static void main(String[] args) {
        int [] arr = {9};
        System.out.println(maxFrequency(arr,2));
    }
    public static int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int maxFrequency = 0;
        for (int i = 0; i < nums.length; i++) {
            int currMaxFreq = (search(nums,nums[i] + k) - i) + 1;
            maxFrequency = maxFrequency < currMaxFreq ? currMaxFreq : maxFrequency;
        }
        return maxFrequency;
    }
    public static int search(int [] arr,int num){

        int start = 0;
        int end = arr.length - 1;

        while (start <= end){
            int mid = start + (end - start) / 2;

            if (arr[mid] <= num){
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return end;
    }
}
