package RandomDaily;

/*
Problem statement
You are given a positive integer ‘N’.
You have to check whether ‘N’ can be represented as a sum of two even numbers or not.

For example:
If the given number is 6, The number 6 can be represented as 2 + 4, and both 2 and 4 are even numbers.
Hence, the answer is “YES”.
*/

public class EvenPartitioning {
    public static boolean checkEvenPartitioning(int n) {

        // Write your code here
        for (int i = 2; i * i < n; i = i + 2) {
            if ((n - i) % 2 == 0)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        if (checkEvenPartitioning(6))
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}