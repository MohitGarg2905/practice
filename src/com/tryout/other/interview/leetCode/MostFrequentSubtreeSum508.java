package com.tryout.other.interview.leetCode;

import com.tryout.other.interview.helpers.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author: Mohit Garg (mohit.garg2905@gmail.com)
 * @createdAt: 2019-Jul-30 2:18 PM
 */
public class MostFrequentSubtreeSum508 {


    static Integer highestFrequency = 0;
    static Map<Integer, Integer> map = new HashMap();
    static List<Integer> res = new LinkedList();
    public static int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap();
        getSum(root);
        int count=0;
        int[] a = new int[res.size()];
        for(Integer i: res){
            a[count] = i;
            count++;
        }
        return a;
    }


    public static int getSum(TreeNode root){
        if(root ==null)
            return 0;
        int leftSum = getSum(root.left);
        int rightSum = getSum(root.right);
        int sum = leftSum+rightSum+root.val;
        int frequency = map.getOrDefault(sum, 0) +1;
        if(highestFrequency<frequency) {
            highestFrequency = frequency;
            res.clear();
            res.add(sum);
        }else if(frequency==highestFrequency){
            res.add(sum);
        }
        map.put(sum, frequency);
        return sum;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-5);
        int[] res = findFrequentTreeSum(root);
    }
}
