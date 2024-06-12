package Programs.binarysearch;

import java.util.Arrays;

public class FairCandySwap_888 {
    public static void main(String[] args) {
        int [] alice = {};
        int [] bob = {1,2};
        int aliceSum = 2;
        int bobSum = 4;

        int start = 0;
        int end = 0;
        while(start< alice.length && end < bob.length){
            int currAliceSum = aliceSum - alice[start] + bob[end];
            int currBobSum = bobSum - bob[end] + alice[start];
            if (currAliceSum == currBobSum){
                System.out.println(Arrays.toString(new int[]{alice[start],bob[end]}));
                return;
            }else if (currAliceSum > currBobSum){
                start++;
            }else{
                end++;
            }
        }
    }
}
