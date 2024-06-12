package Programs.striverz.BinarySearch;

import java.util.Arrays;

public class AggressiveCows {
    public static void main(String[] args) {
        int [] stalls = {0, 3, 4, 7, 10, 9};
        int cows = 4;
        System.out.println(aggrssiveCowsSpoting(stalls,cows));
    }

    // Optimal

    public static int aggrssiveCowsSpoting(int [] stalls,int cows) {
        int n = stalls.length;
        Arrays.sort(stalls);
        int start = 1;
        int end = stalls[n - 1] - stalls[0];

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (canWePlace(stalls,mid,cows)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end;
    }

    // Brute Force
    public static int agressiveCows (int [] stalls,int cows) {
        int n = stalls.length;

        Arrays.sort(stalls);

        int limit = stalls[n - 1] - stalls[0];

        for (int i = 1; i <= limit; i++) {
            if (!canWePlace(stalls,i,cows)) {
                return (i - 1);
            }
        }
        return limit;
    }

    private static boolean canWePlace (int [] stalls,int dist,int cows) {

        int countCows = 1;
        int lastCowSpotted = stalls[0];

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastCowSpotted >= dist) {
                countCows++;
                lastCowSpotted = stalls[i];
            }
        }
        return countCows >= cows;
    }
}
