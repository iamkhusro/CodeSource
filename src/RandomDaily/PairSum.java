package RandomDaily;


//You are given an integer array 'ARR' of size 'N' and an integer 'S'.
// Your task is to return the list of all pairs of elements such that each sum of elements of each pair equals 'S'.
//Note:
//Each pair should be sorted i.e., the first value should be less than or equals to the second value.
//Return the list of pairs sorted in non-decreasing order of their first value.
//In case if two pairs have the same first value, the pair with a smaller second value should come first.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PairSum {

    public static List<int[]> pairSum(int[] arr, int s) {
        // Write your code here.
        Arrays.sort(arr);
        List<int[]> res = new ArrayList<>();

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == s) {
                    int[] a = {arr[i], arr[j]};
                    res.add(a);
                }

            }
        }

        return res;
    }

    //main


}
