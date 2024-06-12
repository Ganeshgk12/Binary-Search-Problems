package Programs.binarysearch;

import java.util.Arrays;

public class SearchInRotatedSortedArrayII_81 {
    public static void main(String[] args) {
        int [] arr = {1,0,1,1,1};
        int target = 0;
        System.out.println(search(arr,target));
        System.out.println(search2(arr,target));
    }
// optimal
    public static boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target){
                return true;
            }
            if (nums[start] == nums[mid]) {
                start++;
                continue;
            }

            if (nums[start] <= nums[mid]) {
                if (nums[start] <= target && target <= nums[mid]) {
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            } else {
                if (nums[mid] <= target && target <= nums[end]) {
                    start = mid + 1;
                }
                else {
                    end = mid - 1;
                }
            }
        }
        return false;
    }
    // brute
    public static boolean search2(int[] nums, int target) {
        int pivot = findPivot(nums);
        if (pivot == -1) {
            Arrays.sort(nums);
            return binarySearch(nums, target, 0, nums.length-1);
        }

        if (nums[pivot] == target) {
            return true;
        }

        if (target >= nums[0]) {
            return binarySearch(nums, target, 0, pivot-1);
        }

        return binarySearch(nums, target, pivot+1, nums.length-1);
    }

    public static int findPivot(int[] nums){
        int start = 0, end = nums.length -1 ;
        // 4 cases here
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // 4 cases over here
            if (mid < end && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            if (mid > start && nums[mid] < nums[mid - 1]) {
                return mid-1;
            }
            if (nums[mid] <= nums[start]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static boolean binarySearch(int[] nums , int target, int start, int end){
        while (start <= end) {
            int mid = start + (end-start) / 2;
            if (target < nums[mid]) {
                end = mid -1 ;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

}
