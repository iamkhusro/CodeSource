package RandomDaily;
//The Base58 alphabet consists of the following characters: “123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz”
//Each byte value from 0 to 57 maps to the alphabet above.

public class Base58 {
    public static String encodeBase58(int n){
        // Write your code here
        String base = "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz";
        if (n < 58)
            return base.charAt(n) + "";

        String res = "";
        while (n > 0) {
            int rem = n % 58;
            n = n / 58;
            res = base.charAt(rem) + res;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(encodeBase58(10));
        System.out.println(encodeBase58(6978));
    }
}