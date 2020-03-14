package com.tryout.other.interview.leetCode;

/**
 * @author: Mohit Garg (mohit.garg2905@gmail.com)
 * @createdAt: 2019-Jul-18 1:44 PM
 */
public class GraphNodes{
    public static int nodesCount(int n){
        if(n==0)
            return 0;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2; i<=n; i++){
            dp[i] = i*(dp[i-1]);
        }
        return dp[n];
    }

    public static void main(String[] args){
        System.out.println("0->" + nodesCount(0));
        System.out.println("1->" + nodesCount(1));
        System.out.println("2->" + nodesCount(2));
        System.out.println("3->" + nodesCount(3));
        System.out.println("4->" + nodesCount(4));
        System.out.println("5->" + nodesCount(5));
    }
}
