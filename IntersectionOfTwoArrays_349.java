package Programs.binarysearch;

import java.lang.reflect.Array;
import java.util.Arrays;

public class IntersectionOfTwoArrays_349 {
    public static void main(String[] args) {
        int [] arr1 = {1,2,2,3};
        int [] arr2 = {2,2,3,3};
        System.out.println(Arrays.toString(intersection(arr1,arr2)));

    }

    public static int[] intersection(int[] nums1, int[] nums2) {

        int [] temp = new int[1001];
        for (int num : nums1) {
            temp[num] = 1;
        }
        int count = 0;
        int [] res = new int[Math.max(nums1.length,nums2.length)];

        for (int num : nums2) {
            if (temp[num] == 1){
                res[count++] = num;
                temp[num] = 2;
            }
        }
        return Arrays.copyOf(res,count);
    }
}
