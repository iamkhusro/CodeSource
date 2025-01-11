package DSA.Sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {5,7,15,9,1,3,99,45,22,14};
        int size = arr.length;
        System.out.println("Before sorting: " + Arrays.toString(arr));

        mergeSort(arr, 0, size - 1);

        System.out.println("After sorting: " + Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);

            merge(arr, l, mid, r);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] leftArr = Arrays.copyOfRange(arr, left, mid + 1);
        int[] rightArr = Arrays.copyOfRange(arr, mid + 1, right + 1);

        int l = 0;
        int r = 0;

        int k = left;

        while (l < leftArr.length && r < rightArr.length) {
            if (leftArr[l] > rightArr[r]) {
                arr[k] = rightArr[r];
                r++;
            }
            else {
                arr[k] = leftArr[l];
                l++;
            }
            k++;
        }

        while (l < leftArr.length) {
            arr[k] = leftArr[l];
            l++;
            k++;
        }

        while (r < rightArr.length) {
            arr[k] = rightArr[r];
            r++;
            k++;
        }
    }
}
