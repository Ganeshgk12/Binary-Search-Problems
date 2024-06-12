package Programs.binarysearch;

import javax.swing.*;

public class CapacityToShipWithinDPackages_1011 {
    public static void main(String[] args) {
        int [] weights = {3,2,2,4,1,4};
        int days = 3;
        //BRUTE
        System.out.println(shipWinthinDays(weights,days));
        System.out.println(optimalApproach(weights,days));
    }

    // BRUTE ---------------------------------------------------
    public static int shipWinthinDays(int [] weights, int days){
        int cap = findMax(weights);
        int sum = findSum(weights);

        for (int i = cap; i <= sum; i++) {
            int day = findRequiredDays(weights,i);
            if (day <= days) return i;
        }
        return -1;

    }

    // OPTIMAL ---------------------------------------------------

    public static int optimalApproach(int [] wt,int days){

        int low = findMax(wt);
        int high = findSum(wt);

        while (low <= high){
            int mid = low + (high - low) / 2;
            int reqDays = findRequiredDays(wt,mid);
            if (reqDays <= days){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static int findRequiredDays(int [] wt , int capacity){
        int day = 1;
        int load = 0;

        for (int i = 0; i < wt.length; i++) {
            if (load + wt[i] > capacity){
                day += 1;
                load = wt[i];
            }else {
                load += wt[i];
            }
        }
        return day;
    }
    private static int findMax(int [] x){
        int max = 0;

        for (int a : x) {
            if (a > max) max = a;
        }
        return max;
    }
    private static int findSum(int [] y){
        int sum = 0;
        for (int k : y) {
            sum += k;
        }
        return sum;
    }
}
