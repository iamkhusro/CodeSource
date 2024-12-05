package DSA.Search;

import java.util.ArrayList;

public class SearchSortedRotated {
    public static int search(ArrayList<Integer> arr, int n, int k) {
        // Write your code here.

        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr.get(mid) == k) {
                return mid;
            }

            if (arr.get(low) <= arr.get(mid)) {
                if (arr.get(low) <= k && k <= arr.get(mid)) {
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }
            else {
                if (arr.get(mid) <= k && k <= arr.get(high)) {
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        //code
    }
}
