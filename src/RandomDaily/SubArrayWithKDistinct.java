package RandomDaily;

import java.util.HashMap;
import java.util.Map;

/*
Problem statement
You are given an array ‘ARR’ having ‘N’ integers. You are also given an integer ‘K’.
The task is to count the number of sub arrays that have ‘K’ distinct values.

Sub array: A consecutive sequence of one or more values taken from an array.

For Example :
‘N’ = 4, ‘K’ = 2
‘ARR’ = [1, 1, 2, 3]

There are ‘3’ sub arrays with ‘2’ distinct elements, which are as follows: [1, 2], [2, 3], [1, 1, 2].
Thus, you should return ‘3’ as the answer.
 */

public class SubArrayWithKDistinct {
    public static int kDistinctSubArrays(int[] arr, int n, int k) {
        // Write your code here.
        int count = 0;

        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i; j < n; j++) {
                map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);

                if (map.size() == k) {
                    count++;
                }
                else if (map.size() > k) {
                    break;
                }            }

        }
        return count;

    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,3};
        System.out.println(kDistinctSubArrays(arr, arr.length, 2));
    }

}