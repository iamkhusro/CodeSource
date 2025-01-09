package DSA.Sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {5,7,15,9,1,3,2,11,13};
        int size = arr.length;
        System.out.println("Before sorting: " + Arrays.toString(arr));

        for (int i = 1; i < size; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;

            //to check intermediate data
            System.out.println(Arrays.toString(arr));
        }

        System.out.println("After sorting: " + Arrays.toString(arr));
    }
}