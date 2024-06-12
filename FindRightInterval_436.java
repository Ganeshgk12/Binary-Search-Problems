package Programs.binarysearch;

import java.util.Arrays;

public class FindRightInterval_436 {
    public static void main(String[] args) {
        int [][] intervals = {{3,4},{2,3},{1,2}};
        System.out.println(Arrays.toString(findIntervals(intervals)));
    }
    public static int [] findIntervals(int [][] intervals){
        int [] result = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            result[i] = search(intervals,intervals[i][1]);
        }
        return result;
    }
    public static int search(int [][] intervals,int num){
        int min = Integer.MAX_VALUE;
        int idx = -1;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] >= num && intervals[i][0] < min){
                idx = i;
                min = intervals[i][0];
            }
        }
        return idx;
    }
}
