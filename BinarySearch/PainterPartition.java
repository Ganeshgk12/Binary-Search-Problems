package Programs.striverz.BinarySearch;

public class PainterPartition {
    public static void main(String[] args) {
        int[] boards = {10, 20, 30, 40};   // Elements Are Length of the i'th board
        int painters = 2;
        System.out.println(findPartition2(boards, painters));
    }

    // Kunal Approach - Similar to split array by largest sum
    public static int findPartition2(int[] boards, int painters) {
        int n = boards.length;
        int start = 0;
        int end = 0;
        for (int x : boards) {
            start = Math.max(start, x);
            end += x;
        }

        while (start < end) {
            int mid = start + (end - start) / 2;
            int sumOfAreaCovers = 0;
            int paintersNeed = 1;

            for (int x : boards) {
                if ((sumOfAreaCovers + x) > mid) {
                    sumOfAreaCovers = x;
                    paintersNeed++;
                } else {
                    sumOfAreaCovers += x;
                }
            }

            if (paintersNeed <= painters) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
    // TUF -- Approach
    static int findPartition(int [] boards,int painters) {
        int n = boards.length;
        int start = 0;
        int end = 0;
        for (int x : boards) {
            start = Math.max(start, x);
            end += x;
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (countPainters(boards,mid) > painters) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }

    static int countPainters (int [] boards,int area) {
        int painters = 1;
        int areaCovers = 0;

        for (int x : boards) {
            if (areaCovers + x <= area) {
                areaCovers += x;
            } else {
                painters++;
                areaCovers = x;
            }
        }
        return painters;
    }
}
