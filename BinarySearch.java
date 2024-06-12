package Programs.binarysearch;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {

        // Ceiling of Number
        int [] arr = {2,3,5,9,14,16,18};
        System.out.println(ceilingOfNumber(arr,4));
//    -----------------------------------------------------

        // Floor of Number
        int [] nums = {2,3,4,5,6,8,10,13,15};
        System.out.println(floorOfNumber(nums,7));
//  ---------------------------------------------------------

//  744. Find Smallest Letter Greater Than Target

        char [] letters = {'c','f','g'};
        char target = 'a';
        System.out.println(nextGreatestLetter(letters,target));
//  ---------------------------------------------------------

//  34. Find First and Last Position of Element in Sorted Array

        int [] num = {5,7,7,8,8,10};
        int tar = 7;
        System.out.println(Arrays.toString(searchRange(num,tar)));

//  ---------------------------------------------------------

        // Find pos of Element in Infinity Array ------------> Wrong output comes

       // int [] infinityArray = {2,4,6,7,8,9,12,13,14,15,16,18,21,23,24,26,27,28,29,31,33,34,35,36,333};
       // System.out.println(findPosOfElementinInfinityArr(infinityArray,31));


    }

    public static int ceilingOfNumber(int [] arr,int target){
        int start = 0;
        int end = arr.length;

        while (start <= end){
            if(target > arr[arr.length -1]){
                return -1;
            }
            int mid = start + (end - start) / 2;

            if (arr[mid] >= target){
                end = mid - 1;
            }else if (arr[mid] <= target){
                start = mid + 1;
            }else {
                return mid;
            }
        }
        return start;
    }

    public static int floorOfNumber(int [] nums,int target){

        if(target < nums[0]){
            return -1;
        }
        int start = 0;
        int end = nums.length-1;
        while (start <= end){
            int mid = start + (end - start) / 2;

            if (nums[mid] > target){
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            }else {
                return mid;
            }
        }
        return end;
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length-1;

        while(start <= end){
            int mid = start + (end -start) / 2;

            if(letters[mid] > target){
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return letters[start % letters.length];
    }

    public static int[] searchRange(int[] nums, int target) {
        int start = search(nums,target,true);
        int end = search(nums,target,false);

        if(start == -1){
            return new int [] {-1,-1};
        }

        return new int [] {start,end};

    }
    public static int search(int [] nums,int target,boolean searchFirstIndex){
        int start = 0;
        int end = nums.length-1;
        int index = -1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(target < nums[mid]){
                end = mid -1;
            }else if (target > nums[mid]){
                start = mid + 1;
            }else{
                index = mid;
                if(searchFirstIndex){
                    end = mid - 1;
                }else{
                    start = mid + 1;

                }
            }
        }
        return index;
    }

    public static int findPosOfElementinInfinityArr(int [] arr,int target){
        int start = 0;
        int end = 1;
        while (target > arr[end]) {
            int temp = end + 1;
            end = end + (end - start + 1) * 2;
            start = temp;
        }
        return binarySearch(arr,target,start,end);
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
