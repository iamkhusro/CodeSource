package Others;

import java.util.ArrayList;

public class SumOfTripletsClosestToTarget
{
    public static int closest3Sum(ArrayList<Integer> arr, int n, int target)
    {
        // Write your code here.

        int minDiff = Integer.MAX_VALUE;
        int closestSum = 0;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = arr.get(i) + arr.get(j) + arr.get(k);
                    int diff = Math.abs(target - sum);

                    if (diff <= minDiff) {
                        minDiff = diff;
                        closestSum = sum;
                    }
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