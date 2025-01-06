package RandomDaily;

/*
Problem statement
You are given two integers, ‘N’ and ‘M’. You are supposed to perform the following operation to convert ‘N’ to ‘M’.

In one operation, you can:
1. Choose any bit in ‘N’.
2. Flip the chosen bit, i.e., if the bit is ‘0’, make it ‘1’ and vice versa.

You are supposed to find the minimum number of operations needed to convert ‘N’ to ‘M’.
*/

public class MinBitFlips {
    public static int minOperations(int N, int M) {
        // Step 1: XOR N and M to find differing bits
        int xor = N ^ M;

        // Step 2: Count the number of 1's in the XOR result
        int count = 0;
        while (xor != 0) {
            count += xor & 1; // Check the least significant bit
            xor >>= 1;        // Right shift to check the next bit
        }

        return count;
    }

    public static void main(String[] args) {
        int N = 10; // Example input
        int M = 20;

        int result = minOperations(N, M);
        System.out.println("Minimum number of operations: " + result);
    }
}
