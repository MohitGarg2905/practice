package com.tryout.other.interview.leetCode;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 *
 * @author: mohit
 * @email: mohit.garg2905@gmail.com
 * @date: 23/6/19
 * @time: 1:14 PM
 */
public class LongestPalindromeSubstring {

    public static String findLongestPalindrome(String s){
        if(s.length()<2)
            return s;
        int[][] dp = new int[s.length()][s.length()];
        int maxLen = 0;
        int pi = 0,pj = 0;

        //Mark all single elements and 2 chars as Palindrome
        for(int i=0; i<s.length(); i++){
            dp[i][i] = 1;
            if(dp[i][i] > maxLen){
                maxLen = dp[i][i];
                pi = i;
                pj = i;
            }
            if(i<s.length()-1 && s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1] = 2;
                maxLen = 2;
                pi = i;
                pj = i+1;
            }
        }

        int j = 0;
        for(int gap=2; gap<s.length(); gap++){
            for(int i=0; i<s.length()-gap; i++){
                j = i+gap;
                if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]>0){
                    dp[i][j] = dp[i+1][j-1]+2;
                    if(dp[i][j] > maxLen){
                        maxLen = dp[i][j];
                        pi = i;
                        pj = j;
                    }
                }
            }
        }

        if(maxLen>0){
            return s.substring(pi, pj+1);
        }
        return null;
    }

    public static void main(String[] args){
        String s = "bddc";
        String o = findLongestPalindrome(s);
        System.out.println("Output is: ");
        System.out.println(o);
    }
}
