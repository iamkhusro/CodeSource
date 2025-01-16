package DSA.BinaryTree.BinarySearchTree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);

    }

    public boolean validate(TreeNode node, Integer lower, Integer upper) {
        if (node == null)
            return true;

        int val = node.val;

        if (lower != null && val <= lower)
            return false;
        if (upper != null && val >= upper)
            return false;

        return validate(node.left, lower, val) && validate(node.right, val, upper);
    }

    //main
}
