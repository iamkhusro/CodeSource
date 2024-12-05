package DSA.Arrays;

import java.util.Arrays;

public class MatrixSpiral {

    public static int[] spiralTraverse(int m, int n, int[][] mat) {
        int resIndex = -1;
        int[] res = new int[m * n];

        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                res[++resIndex] = mat[top][i];
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                res[++resIndex] = mat[i][right];
            }
            right--;

            if(top <= bottom) {
                for (int i = right; i >= left; i--) {
                    res[++resIndex] = mat[bottom][i];
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    res[++resIndex] = mat[i][left];
                }
                left++;
            }

        }


        return res;
    }

    public static void main(String[] args) {
        int[][] mat = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };

        int [] arr = spiralTraverse(mat.length, mat[0].length,
                mat);

        Arrays.stream(arr).forEach(n -> System.out.print(n + " "));
    }
}
