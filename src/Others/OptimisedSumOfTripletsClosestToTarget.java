package Others;

import java.util.ArrayList;
import java.util.Collections;

public class OptimisedSumOfTripletsClosestToTarget {

    public static int closest3Sum(ArrayList<Integer> arr, int n, int target)
    {
        // Write your code here.

        int minDiff = Integer.MAX_VALUE;
        int closestSum = 0;

        Collections.sort(arr);
        for (int i = 0; i < n - 2; i++) {
            int l = i + 1;
            int r = n - 1;

            while (l < r) {
                int sum = arr.get(i) + arr.get(l) + arr.get(r);
                int diff = Math.abs(sum - target);
                if (diff < minDiff) {
                    closestSum = sum;
                    minDiff = diff;
                }

                if (sum < target) {
                    ++l;
                }
                else {
                    --r;
                }
            }
        }
        return closestSum;
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(-1);
        nums.add(1);
        nums.add(2);
        nums.add(4);
        System.out.println(closest3Sum(nums, nums.size(), 1));
    }
}
