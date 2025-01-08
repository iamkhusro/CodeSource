package DSA.Sorting;

import java.util.Arrays;


public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {5,7,15,9,1,3,2,11,13};
        int size = arr.length;
        System.out.println("Before sorting: " + Arrays.toString(arr));

        for (int i = 0; i < size; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;

            //to check intermediate data
            System.out.println(Arrays.toString(arr));
        }

        System.out.println("After sorting: " + Arrays.toString(arr));
    }
}