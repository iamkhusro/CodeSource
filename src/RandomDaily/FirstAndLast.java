package RandomDaily;

import java.util.ArrayList;

public class FirstAndLast {

    //can be optimized

    public static int[] firstAndLastPosition(ArrayList<Integer> arr, int n, int k) {
        // Write your code here.
        int[] res = new int[]{-1,-1};
        int index = arr.indexOf(k);
        if (index != -1) {
            int lastIndex = arr.lastIndexOf(k);
            res = new int[]{index, lastIndex};
        }

        // if (index > -1) {
        //     res = new int[]{index, (index + Collections.frequency(arr, k) - 1)};
        // }
        // else {

        // }
        return res;
    }

    //main

};