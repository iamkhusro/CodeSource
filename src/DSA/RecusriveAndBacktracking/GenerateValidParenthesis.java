package DSA.RecusriveAndBacktracking;

import java.util.ArrayList;
import java.util.List;

class GenerateValidParenthesis {

    // Function which generates all possible
    // n pairs of balanced parentheses.
    static void genParenthesisUtil(int n, int open, int close,
                                   String s, List<String> ans) {

        // If the count of both open and close parentheses
        // reaches n, it means we have generated a valid parentheses.
        if (open == n && close == n) {
            ans.add(s);
            return;
        }

        // At any index i in the generation of the string s,
        // we can put an open parentheses only if its count
        // until that time is less than n.
        if (open < n) {
            genParenthesisUtil(n, open + 1, close, s + "{", ans);
        }

        // At any index i in the generation of the string s,
        // we can put a closed parentheses only if its count until
        // that time is less than the count of open parentheses.
        if (close < open) {
            genParenthesisUtil(n, open, close + 1, s + "}", ans);
        }
    }

    static List<String> AllParenthesis(int n) {

        // List for storing the answer
        List<String> ans = new ArrayList<>();
        if (n > 0) {
            genParenthesisUtil(n, 0, 0, "", ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 5;
        List<String> ans = AllParenthesis(n);

        for (String str : ans) {
            System.out.println(str);
        }
    }
}
