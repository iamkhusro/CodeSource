package RandomDaily;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/*
Problem statement
You're given a sorted array 'a' of 'n' integers and an integer 'x'.
Find the floor and ceiling of 'x' in 'a[0..n-1]'.

Note:
Floor of 'x' is the largest element in the array which is smaller than or equal to 'x'.
Ceiling of 'x' is the smallest element in the array greater than or equal to 'x'.
*/

public class CeilTheFloor {
    public static int[] getFloorAndCeil(int[] a, int n, int x) {
        // Write your code here.
        List<Integer> list = Arrays.stream(a).boxed().collect(Collectors.toList());
        int ceil = list.stream()
                .filter(num -> num >= x).findFirst().orElse(-1);
        Collections.reverse(list);
        int floor = list.stream()
                .filter(num -> num <= x).findFirst().orElse(-1);

        return new int[]{floor, ceil};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getFloorAndCeil(new int[]{3, 4, 7, 8, 8, 10}, 6, 5)));
    }

}