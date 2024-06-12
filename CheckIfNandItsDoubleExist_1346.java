package Programs.binarysearch;

import java.util.Arrays;

public class CheckIfNandItsDoubleExist_1346 {
    public static void main(String[] args) {
        int [] arr = {10,2,5,3};
        System.out.println(checkIfExist(arr));
    }

    public static boolean checkIfExist(int[] arr) {
        for(int i=0;i<arr.length;i++){
            if(search(arr,arr[i]*2,i))
                return true;
        }
        return false;
    }
    static boolean search(int[] arr,int value,int index){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==value && i!=index)
                return true;
        }
        return false;
    }
    public static boolean checkIfExist2(int[] arr) {
        Arrays.sort(arr);
        boolean ans = false;
        for(int i = 0; i < arr.length; i++){
            ans = search(arr,i,arr[i]*2);
            if(ans){
                return true;
            }
        }
        return false;
    }
    public static boolean search2(int [] arr,int i,int target){
        int start = 0;
        int end = arr.length-1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(arr[mid] == target && mid != i){
                return true;
            }
            else if(arr[mid] > target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return false;
    }

    //  Approach 2----------------------------------------

}
