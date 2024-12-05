package DSA.Stack;

public class RedundantBrackets
{
    private static char[] stack;
    private static int top = -1;

    public static boolean findRedundantBrackets(String s)
    {
        // Write your code here.
        stack = new char[s.length()];
        for (int i=0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != ')') {
                if (ch == '(' && s.charAt(i + 2) == ')') {
                    return true;
                }
                if (top == -1 && ch != '(') {
                    continue;
                }
                push(ch);
            }
            else if (ch == ')') {
                if (peek() == '(') {
                    return true;
                }

                while (peek() != '(') {
                    pop();
                }
                pop();
            }
        }

        if (top < 0)
            return false;

        return true;


    }

    private static void push(char ch) {
        stack[++top] = ch;
    }

    private static char pop() {
        return stack[top--];
    }

    private static char peek() {
        return stack[top];
    }

    public static void main(String[] args) {
        System.out.println(findRedundantBrackets("(a)"));
    }
}
