package Programs.binarysearch;

public class ReachANumber_754 {
    public static void main(String[] args) {
        int target = 11;
        System.out.println(reachANumber(target));
        System.out.println(findMinimumMoves(target));
    }
    public static int findMinimumMoves(int target){
        int steps = 0;
        int moves = 0;

        while (moves < target){
            moves += steps;
            steps++;
        }
        while ((moves - target) % 2 == 1){
            moves += steps;
            steps++;
        }
        return steps - 1;
    }

    // --- Optimal Approach -----------

    public static int reachANumber(int target){
        if (target < 0){
            target *= -1;
        }
        if (target == 0) return 0;

        int start = 1;
        int end = target;
        long lastReached = 0;
        int noMoves = 0;

        while (start <= end){
            int mid = start + (end - start) / 2;

            long sum = ((long) mid * (mid + 1)) / 2; // n * n + 1 / 2;

            if (sum >= target){
                lastReached = sum;
                noMoves = mid;
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }

        int diff = (int)(lastReached - target);
        //if difference is odd
        if (diff % 2 != 0){
            //if n+1 is odd
            if ((noMoves + 1) % 2 != 0){
                noMoves += 1;
            }else {
                //if n+1 is even, then n+2 is odd
                noMoves += 2;
            }
        }
        return noMoves;

    }
}
