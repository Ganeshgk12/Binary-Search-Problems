package Programs.binarysearch;

public class FindMinInRotatedSortedArray_153 {
    public static void main(String[] args) {
        int [] nums = {4,5,6,7,8,9,10,1,2,3};
        int pivot = findPivot(nums);
       // System.out.println(pivot);
        System.out.println(nums[pivot + 1]);
    }
    public static int findPivot(int [] nums){
        int start = 0;
        int end = nums.length - 1;

        while (start <= end){
            int mid = start + (end - start) / 2;

            if (mid < end && nums[mid] > nums[mid + 1]){
                return mid;
            }
            if (start < mid && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            }
            if (nums[start] >= nums[mid]) {
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
