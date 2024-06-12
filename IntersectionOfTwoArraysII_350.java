package Programs.binarysearch;

import java.util.Arrays;

public class IntersectionOfTwoArraysII_350 {
    public static void main(String[] args) {
        int [] nums1 = {1,2,2,1};
        int [] nums2 = {2,2};
        System.out.println(Arrays.toString(intersect(nums1,nums2)));


    }
    public static int[] intersect(int[] nums1, int[] nums2) {
        int [] temp = new int[1001];
        for (int num : nums1) {
            temp[num] += 1;
        }
        int [] result = new int[Math.max(nums1.length, nums2.length)];
        int j = 0;
        for (int num : nums2) {
            if (temp[num] >= 1){
                result[j++] = num;
                temp[num]--;
            }
        }
        return Arrays.copyOf(result,j);
    }
}
