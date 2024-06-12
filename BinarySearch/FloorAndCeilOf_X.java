package Programs.striverz.BinarySearch;

import java.util.Arrays;

public class FloorAndCeilOf_X {
    public static void main(String[] args) {
        int [] arr = {5, 6, 8, 9, 6, 5, 5, 6};
        System.out.println(Arrays.toString(getFloorAndCeil(arr,8,7)));
    }

    static int [] getFloorAndCeil(int[] arr, int n, int x) {
        Arrays.sort(arr);

        int start = 0;
        int end = n - 1;
        int floor = -1;
        int ceil = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] <= x) {
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        if (start < n) {
            ceil = arr[start];
        }
        if (end >= 0) {
            floor = arr[end];
        }
        if (floor == x) {
            ceil = floor;
        }
        return new int[]{floor,ceil};
    }

    static int [] floorAndCeil(int [] arr,int n,int x) {
        Arrays.sort(arr);
        int floor = -1, ceil = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] <= x) {
                floor = arr[i];
            }
            if (arr[i] >= x) {
                ceil = arr[i];
                break;
            }
        }
        return new int[]{floor, ceil};
    }
}
