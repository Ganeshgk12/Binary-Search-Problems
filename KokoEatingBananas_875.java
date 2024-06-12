package Programs.binarysearch;

public class KokoEatingBananas_875 {
    public static void main(String[] args) {
        int [] pilesOfBananaa = {2,3,6,7,8};
        int time = 5;
        System.out.println(minEatingSpeed(pilesOfBananaa,time));

    }
    public static int minEatingSpeed(int[] piles, int h) {

        int start = 1;
        int end = findMax(piles);

        while (start <= end){
            int mid = start + (end - start) / 2;

            int hours = findHours(piles,mid);
            if (hours <= h){
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return start;
    }

    private static int findHours(int [] piles , int banana){
        int hours = 0;
        for (int y : piles) {
            hours += Math.ceil((double) y / (double) banana);
        }
        return hours;
    }
    private static int findMax(int [] piles){
        int max = 0;
        for (int x : piles) {
            if (x > max) max = x;
        }
        return max;
    }
}
