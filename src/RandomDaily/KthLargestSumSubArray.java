package RandomDaily;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
Problem statement
Given an array of integers, find the Kth largest sum sub array.
For example, given the array [1, -2, 3, -4, 5] and K = 2, the 2nd largest sum sub array would be [3, -4, 5], which has a sum of 4.
Please note that a sub array is the sequence of consecutive elements of the array.
 */
public class KthLargestSumSubArray {

    public static int getKthLargest(ArrayList<Integer> arr, int k) {

        // Write your code here
        int n = arr.size();
        List<Integer> sums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr.get(j);
                sums.add(sum);
            }
        }

        return sums.stream().sorted(Comparator.reverseOrder()).skip(k - 1).findFirst().get();
    }

    //main
}