package DSA.Arrays;

/*
Given an integer array nums, find the sub array with the largest sum, and return its sum.
 */
class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int currentSum = 0;
        int maxSum = nums[0];

        for (int num : nums) {
            currentSum = Math.max(num, currentSum + num);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    //main
}