package Programs.binarysearch;

import java.util.Arrays;

public class SpeciArrayWithXElementsGreaterThanorEqualX_1608 {
    public static void main(String[] args) {
        int [] nums = {0,4,2,2,4};
        System.out.println(specialArray(nums));
    }
    //---------------------------Optimal Approach ------------------------------------

    public static int specialArray(int [] nums){
        int x = nums.length; // maximum x
        int [] counts = new int[x + 1]; // we need to store x value count from 0 to length so x + 1 length

        for (int num : nums) {
            if (num >= x){  // if its true the ele is gretaer all other ele so maximum x incresed by one
                counts[x]++;
            }
            else {
                counts[num]++;  // if num == 2 that is greater than two x (0,1) so 2 index increased by one
            }
        }
        int res = 0;
        for (int i = counts.length - 1;  i >= 0; i--) {
            res += counts[i];
            if (res == i) return i;
        }
        return -1;
    }
    // --------------------------BRUTE APPROACH--------------------------------------
    public static int specialArray2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length; i++) {
            if (search(nums,i)){
                return i;
            }
        }
        return -1;
    }
    public static boolean search(int [] arr,int target){
        int start = 0;
        int end = arr.length-1;
        int count = 0;
        while (start <= end){
            if (arr[start] >= target){
                count++;
            }
            start++;
        }
        if (count == target){
            return true;
        }
        return false;
    }

}
