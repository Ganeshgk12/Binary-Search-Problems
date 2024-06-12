package Programs.binarysearch;

import java.util.Arrays;

public class TwoSumInputArrayIsSorted_167 {
    public static void main(String[] args) {
        int [] arr = {1,5,7,9,10,11};
        int target = 16;
        System.out.println(Arrays.toString(twoSum(arr,target)));
    }

    public static int[] twoSum(int[] numbers, int target) {

        int start = 0;
        int end = numbers.length-1;

        while(start < end){
            int sum = numbers[start] + numbers[end];
            if(sum == target){
                return new int [] {start + 1,end + 1};
            }else if(sum > target){
                end--;
            }else{
                start++;
            }
        }
        return new int [] {-1,-1};
    }
}
