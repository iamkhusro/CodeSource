package DSA.String;

import java.math.BigInteger;

public class NthGP {
    public static int nthTermOfGP(int N, int A, int R) {
        // Write you code here
        BigInteger r1 = BigInteger.valueOf(R);
        BigInteger a1 = BigInteger.valueOf(A);
        BigInteger res = a1.multiply(r1.pow(N - 1)).mod(BigInteger.valueOf(1000000007));
        return res.intValue();

    }

    public static void main(String[] args) {
        System.out.println(nthTermOfGP(5, 4, 2));
    }
}
