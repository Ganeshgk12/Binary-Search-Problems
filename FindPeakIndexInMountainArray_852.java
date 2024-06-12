package Programs.binarysearch;

public class FindPeakIndexInMountainArray_852 {
    public static void main(String[] args) {
        int[] mountain = {1,4,6,7,8,9,10,11,5};
        System.out.println(findPeakIndex(mountain));
    }
    public static int findPeakIndex(int [] arr){
        int start = 0;
        int end = arr.length-1;

        while (start < end){
            int mid = start + (end - start) / 2;

            if (arr[mid] > arr[mid+1]){
                end = mid;
            }else {
                start = mid + 1;
            }
        }
        return start;
    }
}
