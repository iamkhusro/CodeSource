package RandomDaily;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {

    public static Queue<Integer> reverseQueue(Queue<Integer> q) {

        // Write your code here.
        Stack<Integer> stack = new Stack<>();
        while (!q.isEmpty()) {
            stack.push(q.poll());
        }

        Queue<Integer> res = new LinkedList<>();
        while (!stack.isEmpty()) {
            res.offer(stack.pop());
        }

        return res;
    }

    //main
}