package Programs.binarysearch;
//Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
//
//Return the kth positive integer that is missing from this array.
public class KthMissingPositiveNumber_1539 {
    public static void main(String[] args) {
        int [] arr = {2,3,4,7,11};
        int k = 5;
        System.out.println("The " + k + " th missing Number in the array is " + findKthPositive(arr,k));
    }
    public static int findKthPositive(int[] arr, int k) {
        int missingNumber = 0;
        int missingNumLen = 0;
        int i = 0;

        while (i < arr.length){
            if (missingNumber + 1 == arr[i]){
                i++;
                missingNumber++;
                continue;
            }
            missingNumber++;
            missingNumLen++;
            if (missingNumLen == k){
                return missingNumber;
            }
        }
        return missingNumber + (k - missingNumLen);
    }
}
