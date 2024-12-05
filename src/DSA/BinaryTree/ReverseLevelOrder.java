package DSA.BinaryTree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseLevelOrder {
    private static Stack<Integer> stack = new Stack<>();
    public static ArrayList<Integer> reverseLevelOrder(TreeNode root) {
        // Write your code here.
        levelOrderTraverse(root);

        ArrayList<Integer> res = new ArrayList<>();
        while(!stack.isEmpty()) {
            res.add(stack.pop());
        }

        return res;


    }

    private static void levelOrderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode removedNode = queue.poll();

            stack.push(removedNode.data);

            if (removedNode.left != null) {
                queue.add(removedNode.left);
            }

            if (removedNode.right != null) {
                queue.add(removedNode.right);
            }
        }
    }

    //main
}