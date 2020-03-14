package com.tryout.other.interview.leetCode;

import com.tryout.other.interview.helpers.TreeNode;

/**
 * @author: Mohit Garg (mohit.garg2905@gmail.com)
 * @createdAt: 2019-Jul-09 11:32 PM
 */
public class MaxDepthBinaryTree104 {

    public static int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        return traverse(root, 0, 0);
    }

    public static int traverse(TreeNode root, int currDepth, int maxDepth){
        currDepth++;
        if(root.left==null && root.right==null){
            if(currDepth>=maxDepth)
                maxDepth=currDepth;
        }else {
            if (root.left != null)
                maxDepth = traverse(root.left, currDepth, maxDepth);
            if (root.right != null)
                maxDepth = traverse(root.right, currDepth, maxDepth);
        }
        return maxDepth;
    }

    /**
     * Single line solution
     * https://leetcode.com/problems/maximum-depth-of-binary-tree/discuss/330996/Java-solution
     *
     * @param root
     * @return
     */
    public int maxDepthSingle(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(maxDepthSingle(root.left), maxDepthSingle(root.right));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(8);
        root.left.left.left = new TreeNode(6);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(maxDepth(root));
    }
}
