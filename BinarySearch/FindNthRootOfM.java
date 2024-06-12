package Programs.striverz.BinarySearch;

public class FindNthRootOfM {
    public static void main(String[] args) {
        int n = 2;
        int m = 9;
        System.out.println(NthRoot(n,m));
    }
    public static int NthRoot(int n, int m){

        if (m == 0) {
            return 0;
        }
        int low = 1;
        int high = m;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            long midToPowerN = power(mid, n);

            if (midToPowerN == m){
                return mid;
            }else if (midToPowerN < m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    private static long power(int x, int n) {
        long result = 1;
        for (int i = 0; i < n; i++) {
            result *= x;
            if (result > Integer.MAX_VALUE) {
                return Long.MAX_VALUE; // To prevent overflow
            }
        }
        return result;
    }
}
