package Programs.striverz.BinarySearch;

public class MinimumNumberOfDaysToMake_M_Bouquets_1482 {
    public static void main(String[] args) {
        int [] bloomDay = {7, 7, 7, 7, 12, 7, 7};
        int m = 2;
        int k = 3;
        System.out.println(minDays(bloomDay,m,k));
    }
    public static int minDays(int[] bloomDay, int m, int k) {

        long val = (long) m * k;
        int n = bloomDay.length;
        if (val > n) return -1;

        int maxi = Integer.MIN_VALUE;
        int mini = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            mini = Math.min(mini, bloomDay[i]);
            maxi = Math.max(maxi, bloomDay[i]);
        }

        int low = mini;
        int high = maxi;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (possibleToMakeBoquets(bloomDay,mid,m,k)){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return low;
    }
    static boolean possibleToMakeBoquets (int [] arr,int day,int m,int k){
        int cnt = 0;
        int noOfB = 0;

        for (int x : arr) {
            if (x <= day) {
                cnt++;
            } else {
                noOfB += (cnt / k);
                cnt = 0;
            }
        }
        noOfB += (cnt / k);

        return noOfB >= m;
    }
}
