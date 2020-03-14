package com.tryout.other.interview.leetCode;

/**
 * @author: Mohit Garg (mohit.garg2905@gmail.com)
 * @createdAt: 2019-Jul-08 10:55 PM
 */
public class ClimbStairs70 {

    public int climbStairsRec(int n) {
        int[] memo = new int[n+1];
        return climbStairs(n, memo);
    }

    public int climbStairs(int n, int[] memo){
        if(n<3)
            return n;
        if(memo[n]>0)
            return memo[n];
        int r = climbStairs(n-1, memo)+climbStairs(n-2, memo);
        memo[n] = r;
        return r;
    }

    public int climbStairsDP(int n) {
        if(n<3)
            return n;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<n+1; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public int climbStairsFibonacci(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}
