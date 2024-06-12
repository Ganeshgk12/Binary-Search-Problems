package Programs.binarysearch;

public class FindMinimumInRotatedSortedArrayII_154 {
    public static void main(String[] args) {
        int [] arr = {6,7,7,7,7,7,8,8,8,2,2,3,3,3};
        System.out.println(findPivot(arr));
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
            }else{
                start = mid + 1;
            }

        }
        return -1;
    }
}
