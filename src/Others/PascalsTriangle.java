package Others;

import java.util.ArrayList;

public class PascalsTriangle {
    public static ArrayList<ArrayList<Long>> printPascal(int n) {
        // Write your code here.
        ArrayList<ArrayList<Long>> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ArrayList<Long> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                row.add(nCr(i, j));
            }
            res.add(row);
        }

        return res;

    }

    public static long nCr(long n, long r) {
        long res = 1;
        // calculating nCr:
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 50;
        ArrayList<ArrayList<Long>> res = printPascal(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(res.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
