package DSA.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class RightViewOfBT {

    public static void rightView(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode rightMost = null;

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                rightMost = current;

                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
            // Print the rightmost node of the current level
            System.out.print(rightMost.data + " ");
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println("Right View:");
        rightView(root);
    }
}
