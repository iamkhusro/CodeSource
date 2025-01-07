package RandomDaily;

import java.util.Set;
import java.util.TreeSet;

/*
Problem statement
You are given two binary search trees. Your task is to check whether the two BSTs contains the same set of elements or not.

The structure of the two given BSTs can be different.

Note: All elements in a given BST are unique.
*/

/*NB: Only inorder traversal didn't give solution as the elements were in random order. The tree contains duplicate elements as well.
Reason why had to sort and filter the elements, using TreeSet, for comparison
*/


public class CheckBSTs {

    static class TreeNode<T> {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        public TreeNode(T data) {
            this.data = data;
        }
    }

    public static Boolean checkBSTs(TreeNode<Integer> root1, TreeNode<Integer> root2) {
        // Write Your Code here.
        Set<Integer> s1 = new TreeSet<>();
        Set<Integer> s2 = new TreeSet<>();
        inOrder(root1, s1);
        inOrder(root2, s2);
        // System.out.println(s1);
        // System.out.println(s2);
        return s1.equals(s2);

    }

    private static void inOrder(TreeNode<Integer> root, Set<Integer> s) {
        if (root != null) {
            inOrder(root.left, s);
            s.add(root.data);
            inOrder(root.right, s);
        }
    }

    //main

}