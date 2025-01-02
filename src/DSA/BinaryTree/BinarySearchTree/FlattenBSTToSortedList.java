package DSA.BinaryTree.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

/*
Problem statement
You have been given a Binary Search Tree (BST).
Your task is to flatten the given BST to a sorted list.
More formally, you have to make a right-skewed BST from the given BST,
i.e., the left child of all the nodes must be NULL, and the value at the right child must be greater than the current node.

A binary search tree (BST), also called an ordered or sorted binary tree,
is a rooted binary tree whose internal nodes each store a value greater than all the values in the node's left subtree and less than those in its right subtree.

Follow Up :
Can you solve this in O(N) time and O(H)  space complexity?
*/

public class FlattenBSTToSortedList
{
    static class TreeNode<T>
    {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static TreeNode<Integer> flatten(TreeNode<Integer> root)
    {
        // Write your code here
        List<Integer> sortedNodesData = new ArrayList<>();
        inOrderTraverse(root, sortedNodesData);
        // System.out.println(sortedNodes)

        TreeNode<Integer> newRoot = null;
        TreeNode<Integer> temp = null;
        for (int num : sortedNodesData) {
            if (newRoot == null) {
                TreeNode<Integer> node = new TreeNode<>(num);
                newRoot = node;
                temp = newRoot;
            }
            else {
                temp.right = new TreeNode<>(num);
                temp = temp.right;
            }
        }
        return newRoot;
    }

    public static void inOrderTraverse(TreeNode<Integer> root, List<Integer> sortedNodesData) {
        if (root != null) {
            inOrderTraverse(root.left, sortedNodesData);
            sortedNodesData.add(root.data);
            inOrderTraverse(root.right, sortedNodesData);
        }
    }

    //main
}