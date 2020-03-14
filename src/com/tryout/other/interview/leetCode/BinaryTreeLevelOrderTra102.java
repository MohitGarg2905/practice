package com.tryout.other.interview.leetCode;

import com.tryout.other.interview.helpers.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: Mohit Garg (mohit.garg2905@gmail.com)
 * @createdAt: 2019-Jul-09 6:10 PM
 */
public class BinaryTreeLevelOrderTra102 {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        traverse(root, res, 0);
        return res;
    }

    public static void traverse(TreeNode node, List<List<Integer>> res, int level){
        if(node==null)
            return;
        if(res.size()<=level){
            res.add(level, new LinkedList<Integer>());
        }
        List<Integer> r = res.get(level);
        r.add(node.val);
        res.set(level, r);
        traverse(node.left, res, level+1);
        traverse(node.right, res, level+1);

        return;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> res = levelOrder(root);

        for(List<Integer> li:res){
            String s = "";
            for(Integer inte:li){
                s += inte+" ";
            }
            System.out.println(s);
        }

    }

}
