package Programs.binarysearch;
//You have n coins and you want to build a staircase with these coins.
// The staircase consists of k rows where the ith row has exactly i coins.
// The last row of the staircase may be incomplete.
//Given the integer n, return the number of complete rows of the staircase you will build.

import java.util.Scanner;

public class ArrangingCoins_441 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of coins you have ");
        long coins = sc.nextLong();
        System.out.println(arrangeCoins(coins) + " staircase build with " + coins + " coins");
    }

    public static int arrangeCoins(long n){
        long start = 0;
        long end = n;
        while (start <= end){
            long mid = start + (end - start) / 2;
            long coinsUsed = mid * (mid + 1) / 2;

            if (coinsUsed == n){
                return (int) mid;
            }
            if (coinsUsed > n){
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return (int) end;

    }

    public static int arrangeCoins2(int n) {
        int rowAtYouAreNow = 1;

        while (n > 0){
            rowAtYouAreNow++;
            n = n - rowAtYouAreNow;
        }
        return rowAtYouAreNow-1;
    }
}
