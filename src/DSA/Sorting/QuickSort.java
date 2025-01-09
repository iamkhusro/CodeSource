package DSA.Sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5,7,15,9,1,3,2,11,13};
        int high = arr.length - 1;
        System.out.println("Before sorting: " + Arrays.toString(arr));

        quickSort(arr, 0, high);

        System.out.println("After sorting: " + Arrays.toString(arr));

    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }

    }

    private static int partition(int[] arr, int low, int high) {
        //to check intermediate data
        System.out.println(Arrays.toString(arr));

        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }

        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }


}
