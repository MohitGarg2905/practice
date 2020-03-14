package com.tryout.other.interview.leetCode;

/**
 * @author: Mohit Garg (mohit.garg2905@gmail.com)
 * @createdAt: 2019-Jul-08 9:37 PM
 */
public class NumberOf1Bits191 {

    public static int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
            System.out.println("Integer : "+n + " binary: "+Integer.toBinaryString(n) +" & "+ Integer.toBinaryString(n-1));
        }
        return sum;
    }

    public static void main(String[] args){
        int i = hammingWeight(500);
    }
}
