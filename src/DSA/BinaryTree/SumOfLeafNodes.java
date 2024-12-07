package DSA.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class SumOfLeafNodes {
    public static int sumOfLeaves(TreeNode root) {
        // Write your code here.
        List<Integer> leafNodes = new ArrayList<>();

        getLeafNodes(leafNodes, root);
        return leafNodes.stream().reduce(0, (c,e) -> c + e);
    }

    public static void getLeafNodes(List<Integer> leafNodes, TreeNode root) {
        if (root == null)
            return;

        if (root.left == null && root.right == null)
            leafNodes.add(root.data);

        getLeafNodes(leafNodes, root.left);
        getLeafNodes(leafNodes, root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(6);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(2);

        System.out.println(sumOfLeaves(root));
    }
}