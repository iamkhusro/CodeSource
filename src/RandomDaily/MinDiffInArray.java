package RandomDaily;

import java.util.Arrays;

/*
Problem statement
Given an array of integers, print the minimum of the absolute difference of all possible pairs of elements.
Example :
N = 5
ARR = [ 3, -6, 7, -7, 0 ]
Out of all pairs, (-7,-6) have a difference of ‘1’, and no other pair has less difference. So ‘ANS’ is ‘1’.
*/
public class MinDiffInArray {

    static int minDiff(int n, int[] arr) {
        // Write your code here.
        int len = arr.length;
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;

        for (int i = 1; i < len; i++) {
            int diff = Math.abs(arr[i] - arr[i - 1]);
            if (diff < minDiff)
                minDiff = diff;
        }

        return minDiff;

    }

    //main
}