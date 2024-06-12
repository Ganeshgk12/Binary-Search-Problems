package Programs.binarysearch;

public class SearchInsertPosition_35 {
    public static void main(String[] args) {
        int [] arr = {2,3,5,6,7,9,10,12};
        int target = 1;
        System.out.println(search(arr,target));
    }
    public static int search(int [] arr,int target){
        int start = 0;
        int end = arr.length-1;

        while (start <= end){
            int mid = start + (end - start) / 2;

            if (arr[mid] == target){
                return mid;
            } else if (arr[mid] < target) {
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return start;
    }
}
