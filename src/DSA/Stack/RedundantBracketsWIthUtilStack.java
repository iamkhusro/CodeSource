package DSA.Stack;

import java.util.Stack;

public class RedundantBracketsWIthUtilStack
{
    public static boolean findRedundantBrackets(String s)
    {
        // Write your code here.
        Stack<Character> stack = new Stack<>();
        for (int i=0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != ')') {
                if (ch == '(' && s.charAt(i + 2) == ')') {
                    return true;
                }
                if (stack.empty() && ch != '(') {
                    continue;
                }
                stack.push(ch);
            }
            else if (ch == ')') {
                if (stack.peek() == '(') {
                    return true;
                }

                while (stack.peek() != '(') {
                    stack.pop();
                }
                stack.pop();
            }
        }

        return !stack.empty();


    }

    public static void main(String[] args) {
        System.out.println(findRedundantBrackets("(a)"));
        System.out.println(findRedundantBrackets("(a*b)*((c+b)*(d+b))"));
        System.out.println(findRedundantBrackets("(a-b*c)"));
        System.out.println(findRedundantBrackets("(c+(a+b)*(c/d)-(a+c))"));
    }
}