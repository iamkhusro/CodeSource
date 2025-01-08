package DSA.Sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {5,7,15,9,1,3,2,11,13};
        int size = arr.length;
        System.out.println("Before sorting: " + Arrays.toString(arr));

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

            System.out.println(Arrays.toString(arr));
        }

        System.out.println("After sorting: " + Arrays.toString(arr));
    }
}
