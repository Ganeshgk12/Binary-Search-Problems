package Programs.binarysearch;

import java.util.Scanner;

public class ValidPerfectSquare_367 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an number to check Valid Perfect Squre");
        long x = sc.nextLong();
        System.out.println(isPerfectSquare(x) ? x + " is perfect Squre " : x + " is not perfect Squre ");
    }
    public static boolean isPerfectSquare(long num) {
        long start = 0;
        long end = num;
        while (start <= end){
            long mid = start + (end - start) / 2;

            if (mid * mid == num){
                return true;
            } else if (mid * mid < num) {
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return false;
    }
}
