package DSA.Arrays;

import java.util.Arrays;

/*
Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
Example 1:
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
 */
class RotateArray {
    public static void rotate(int[] nums, int k) {

        int size = nums.length;
        if (size > 0) {
            int copy[] = Arrays.copyOfRange(nums, 0, size);
            k = k % size;
            int index = -1;
            for (int i = size - k; i < size; i++) {
                nums[++index] = copy[i];
            }
            for (int i = 0; i < size - k; i++) {
                nums[++index] = copy[i];
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7};
        rotate(arr, 3);
        System.out.println(Arrays.toString(arr));
    }
}