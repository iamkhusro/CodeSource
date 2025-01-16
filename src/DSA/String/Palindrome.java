package DSA.String;

public class Palindrome {
    public static boolean isPalindrome(String s) {
        String filtered = s.chars().mapToObj(n -> (char)n)
                .filter(Character::isLetterOrDigit).map(c -> (""+c).toLowerCase()).reduce((a,b) -> a + b).orElse("");

        StringBuilder sb = new StringBuilder(filtered);

        return sb.reverse().toString().equals(filtered);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
