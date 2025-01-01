package RandomDaily;

import java.util.ArrayList;
import java.util.Stack;

/*
Problem statement
You are given an empty stack and an integer ‘LIMIT’. The size of the stack cannot exceed the ‘LIMIT’.

You are given ‘Q’ queries of the following three types -:

1. PUSH ‘X’ -: Push integer ‘X’ at top of the stack if its size is less than ‘LIMIT’, else do nothing.

2. POP -: Pops and returns the top element of stack or -1 if the stack is empty.

3. INC ‘K’, ‘Y’-: Increments the bottom ‘K’ elements of the stack by ‘Y’.
If there are fewer than X elements in the stack, just increment all the elements in the stack.

Your task is to return an array/list, that consists of all elements returned by a query of type ‘POP’ in the same order in which these queries are executed.
See the example for more clarity.

Note:
1. It is guaranteed that there is at least one query of type ‘POP’.

Here, queries[i] is an ArrayList of integers representing the ith query,
in which for different type of queries i.e -:
1. PUSH 'X' -: queries[i][0] = 1, and queries[i][1] = 'X';
2. POP -: queries[i][0] = 2;
3. INC 'K', 'Y' -: queries[i][0] = 3, queries[i][1] = 'K' and queries[i][2] = 'Y';

*/

public class QueriesOnStack {
    public static ArrayList<Integer> answerQueries(ArrayList<ArrayList<Integer>> queries, int limit) {
        // Write your code here.
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (ArrayList<Integer> list : queries) {
            int zeroth = list.get(0);

            switch(zeroth) {
                case 1:
                    if (stack.size() < limit) {
                        stack.push(list.get(1));
                    }
                    break;

                case 2:
                    if (stack.isEmpty()) {
                        res.add(-1);
                    }
                    else {
                        res.add(stack.pop());
                    }
                    break;

                case 3:
                    int k = list.get(1);
                    int y = list.get(2);

                    k = Math.min(k, stack.size());

                    for (int i = 0; i < k; i++) {
                        stack.set(i, stack.get(i) + y);
                    }
                    break;

            }
        }
        return res;
    }

    //main
}