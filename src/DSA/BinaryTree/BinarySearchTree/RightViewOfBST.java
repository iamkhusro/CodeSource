package DSA.BinaryTree.BinarySearchTree;

public class RightViewOfBST {

    static class TreeNode {
        int data;
        TreeNode left, right;

        // Constructor
        TreeNode(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Variable to keep track of the maximum level visited
    static int maxLevel = 0;

    // Recursive function to print the right view
    public static void printRightView(TreeNode root) {
        // Helper method to handle the recursive logic
        rightViewUtil(root, 1); // Start from level 1
    }

    // Utility function for right view
    private static void rightViewUtil(TreeNode node, int currentLevel) {
        if (node == null) {
            return; // Base case: if the node is null, stop recursion
        }

        // If this is the first node of the current level, print it
        if (currentLevel > maxLevel) {
            System.out.print(node.data + " ");
            maxLevel = currentLevel; // Update the maximum level visited
        }

        // Recur for the right and left subtrees
        rightViewUtil(node.right, currentLevel + 1); // Explore right subtree first
        rightViewUtil(node.left, currentLevel + 1);  // Explore left subtree next
    }

    // Main method to test the right view
    public static void main(String[] args) {
        // Constructing the binary search tree
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(25);

        System.out.println("Right View of the Binary Search Tree:");
        printRightView(root);
    }
}
