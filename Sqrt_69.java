package Programs.binarysearch;

public class Sqrt_69 {
    public static void main(String[] args) {
        int x = 17;
        System.out.println(findsqrt(x));

    }
    public static int findsqrt(int x){
        int start = 1;
        int end = x;

        while (start <= end){
            long mid = start + (end - start) / 2;

            if (mid * mid == x){
                return (int) mid;
            }
            if (mid * mid > x){
                end = (int) (mid - 1);
            }else {
                start = (int) (mid + 1);
            }
        }
        return end;
    }
}
