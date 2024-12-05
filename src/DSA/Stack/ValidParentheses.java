package DSA.Stack;
import java.util.Stack;

public class ValidParentheses {

    public static boolean isValidParenthesis(String s) {
        // Write your code here.
        Stack<Character> stack = new Stack<>();

        for (int i=0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '{' || ch == '(' || ch == '[') {
                stack.push(ch);
            }
            else if (stack.isEmpty()) {
                return false;
            }
            else if ((ch == '}' && stack.peek() == '{') || (ch == ')' && stack.peek() == '(') || (ch == ']' && stack.peek() == '[')) {
                stack.pop();
            }

            else {
                return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValidParenthesis("[]"));
        System.out.println(isValidParenthesis(")]"));
        System.out.println(isValidParenthesis("[(]"));
    }

}
