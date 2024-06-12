package Programs.striverz.BinarySearch;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimiseMaximumDistanceBetweenGasStation {
    public static void main(String[] args) {
        int [] arr = {1,13,17,23};
        int k = 5;
        System.out.println(minimiseMaxiDist(arr,k));
        System.out.println(minimiseMaxiDistGasStation(arr,k)); // Optimal
    }

    //OPTIMAL

    public static class Pairs {
        double first;
        int second;

        public Pairs(double first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    public static double minimiseMaxiDistGasStation(int [] arr,int k) {
        int n = arr.length;
        int[] howMany = new int[n - 1];

//        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
//            @Override
//            public int compare(Pair a, Pair b) {
//                return Double.compare(b.first, a.first); // Sorting in descending order
//            }
//        });
        PriorityQueue<Pairs> pq = new PriorityQueue<>((a,b) -> Double.compare(b.first, a.first));

        for (int i = 0; i < n - 1; i++) {
            pq.add(new Pairs(arr[i + 1] - arr[i], i));
        }

        for (int gasStation = 1; gasStation <= k ; gasStation++) {

            Pairs top = pq.poll();
            int secInx = top.second;

            howMany[secInx]++;

            double initialSecDiff = arr[secInx + 1] - arr[secInx];
            double newSecLen = initialSecDiff / (double) (howMany[secInx] + 1);
            pq.add(new Pairs(newSecLen,secInx));
        }
        return pq.peek().first;
    }



        // Brute -- TLE COMES DIFF CASES -- NOT RECOOMEND THIS
    public static double minimiseMaxiDist(int [] arr,int k) {
        int n = arr.length;
        int [] howMany = new int[n - 1];

        for (int gasStation = 1; gasStation <= k ; gasStation++) {
            double maxSectionLength = -1;
            int maxIdx = -1;

            for (int i = 0; i < n - 1; i++) {
                double diff = arr[i + 1] - arr[i];
                double secLength = diff / (double) (howMany[i] + 1);
                if (secLength > maxSectionLength) {
                    maxSectionLength = secLength;
                    maxIdx = i;
                }
            }
            howMany[maxIdx]++;

        }

        double maxAns = -1;
        for (int i = 0; i < n - 1; i++) {
            double diff = arr[i + 1] - arr[i];
            double secLength = diff / (double) (howMany[i] + 1);
            maxAns = Math.max(maxAns,secLength);
        }
        return maxAns;
    }


}
