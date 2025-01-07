package RandomDaily;
import java.util.ArrayList;
import java.util.List;

/*
Problem statement
You are given an array 'arr' of length 'n'. Find the index(0-based) of a peak element in the array.
If there are multiple peak numbers, return the index of any peak number.

Peak element is defined as that element that is greater than both of its neighbors.
If 'arr[i]' is the peak element, 'arr[i - 1]' < 'arr[i]' and 'arr[i + 1]' < 'arr[i]'.
Assume 'arr[-1]' and 'arr[n]' as negative infinity.
*/


public class PeakElement {
    public static int findPeakElement(ArrayList<Integer> arr) {
        // Write your code here.
        int size = arr.size();

        for (int i = 0; i < size; i++) {
            if (i == 0) {
                if (arr.get(i) > arr.get(1) && arr.get(i) > arr.get(size - 1))
                    return i;
            }
            else if (i == size - 1) {
                if (arr.get(i) > arr.get(i - 1) && arr.get(i) > arr.get(0))
                    return i;
            }
            else if (arr.get(i - 1) < arr.get(i) && arr.get(i) > arr.get(i + 1)) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findPeakElement(new ArrayList<>(List.of(1,2,3,4,5))));
    }
}
