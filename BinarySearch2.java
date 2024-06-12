package Programs.binarysearch;

public class BinarySearch2 {
    public static void main(String [] args){
        // 852.Find peak index in mountain Array

        int[] mountain = {1,4,6,7,8,9,10,11,5};
        System.out.println(findPeakIndex(mountain));
//--------------------------------------------------------------------------------------
        // 162 Find Peak Element ----> same code of Find peak index in mountain array
        int [] arr = {1,4,6,8,9,3,2,0};
        System.out.println(findPeakIndex(arr));
//--------------------------------------------------------------------------------------

        // 1095. Find In Mountain Array

        int [] array = {1,3,6,7,8,5,4,2,0};
        int target = 4;
        System.out.println(findTarget(array,target));

        // 33.Search in Rotteted Sorted Array

        int [] rottatedArr = {10,12,2,4,5,7,8,9};
        System.out.println(search(rottatedArr,8));
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

    public static int findTarget(int [] arr,int target){
        int peakIndex = findPeakIndex(arr);
        int firstTry = orderAgnosticBinaryS(arr,target,0,peakIndex -1);

        if (firstTry != -1){
            return firstTry;
        }
        return orderAgnosticBinaryS(arr,target,peakIndex+1,arr.length-1);

    }

    public static int orderAgnosticBinaryS(int [] arr,int target,int start,int end){
        boolean isAscendind = arr[start] < arr[end];
        while (start <= end){
            int mid = start + (end - start) / 2;
            if (arr[mid] == target){
                return mid;
            }
            if (isAscendind){
                if (arr[mid] > target){
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (arr[mid] > target){
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    public static int search(int [] arr,int target){

        int pivot = findPivot(arr);
        if (arr[pivot] == target){
            return pivot;
        }
        if (target >= arr[0]){
            return binarySearch(arr,target,0,pivot-1);
        }
        return binarySearch(arr,target,pivot+1,arr.length-1);
    }
    public static int findPivot(int [] arr){
        int start = 0;
        int end = arr.length-1;

        while (start <= end){

            int mid = start + (end - start) / 2;

            if (mid < end && arr[mid] > arr[mid+1]){
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid-1]) {
                return mid-1;
            }
            if (arr[start] >= arr[mid]){
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return -1;
    }
    public static int binarySearch(int [] arr,int target,int start,int end){

        while (start <= end){
            int mid = start + (end - start) / 2;

            if(arr[mid] > target){
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
