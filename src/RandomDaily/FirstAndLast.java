package RandomDaily;

import java.util.ArrayList;
import java.util.Arrays;

//find first and last position in sorted array
public class FirstAndLast {

    public static int[] firstAndLastPosition(ArrayList<Integer> arr, int n, int k) {
        // Write your code here.
        int[] res = new int[]{-1,-1};
        int index = arr.indexOf(k);
        if (index != -1) {
            int lastIndex = arr.lastIndexOf(k);
            res = new int[]{index, lastIndex};
        }
        return res;
    }

    public static int[] firstAndLastPosition2(ArrayList<Integer> arr, int n, int k) {
        int[] res = new int[]{-1, -1};
        res[0] = findPosition(arr, k, true);  // Find the first occurrence
        if (res[0] != -1) {
            res[1] = findPosition(arr, k, false);  // Find the last occurrence
        }
        return res;
    }

    private static int findPosition(ArrayList<Integer> arr, int k, boolean findFirst) {
        int start = 0, end = arr.size() - 1;
        int result = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr.get(mid) == k) {
                result = mid; // Record the index
                if (findFirst) {
                    end = mid - 1; // Search on the left side for the first occurrence
                } else {
                    start = mid + 1; // Search on the right side for the last occurrence
                }
            } else if (arr.get(mid) < k) {
                start = mid + 1; // Search right
            } else {
                end = mid - 1; // Search left
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,2,2,5,5,9,10));
        System.out.println(Arrays.toString(firstAndLastPosition(list, list.size(), 2)));
        System.out.println(Arrays.toString(firstAndLastPosition2(list, list.size(), 2)));
    }

};