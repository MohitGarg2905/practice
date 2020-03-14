package com.tryout.other.interview.leetCode;

/**
 * https://leetcode.com/problems/decode-ways-ii/solution/
 *
 * @author: mohit
 * @email: mohit.garg2905@gmail.com
 * @date: 30/6/19
 * @time: 12:48 PM
 */
public class DecodeWays2 {

    public static int numDecodings(String s) {
        long[] dp = new long[s.length()+1];
        dp[0]=1;
        char[] chars = s.toCharArray();
        if(chars[0]=='0')
            return 0;
        int dpMinus2Multiplier, dpMinus1Multiplier;
        for(int i=0; i<s.length(); i++){
            dpMinus1Multiplier = 1;
            dpMinus2Multiplier = 0;
            if(chars[i]=='*'){
                dpMinus1Multiplier = 9;
                if(i>0) {
                    if (chars[i - 1] == '1')
                        dpMinus2Multiplier = 9;
                    else if (chars[i - 1] == '2')
                        dpMinus2Multiplier = 6;
                    else if(chars[i-1]=='*')
                        dpMinus2Multiplier = 15;
                }
            }else if(chars[i]!='0'){
                if(i>0){
                    if(chars[i-1]=='1')
                        dpMinus2Multiplier = 1;
                    else if(chars[i-1]=='2' && Integer.parseInt(chars[i]+"")<7)
                        dpMinus2Multiplier = 1;
                    else if(chars[i-1]=='*'){
                        if(Integer.parseInt(chars[i]+"")<7)
                            dpMinus2Multiplier = 2;
                        else
                            dpMinus2Multiplier = 1;
                    }

                }
            }else if(i>0 && chars[i]=='0'){
                if(chars[i-1]=='*') {
                    //allowed value for * = 1 or 2, it cannot club with previous values
                    dp[i] = currentDPValue(dp, i - 1, 0, 2);
                }else if(chars[i-1]=='1' || chars[i-1]=='2')
                    dp[i] = currentDPValue(dp, i - 1, 0, 1);
                else
                    return 0;
            }
            dp[i+1] = currentDPValue(dp, i, dpMinus2Multiplier, dpMinus1Multiplier);
            printArray(dp);
        }
        return (int)(dp[s.length()]%1000000007);
    }

    private static long currentDPValue(long[] dp, int i, int dpMinus2Multiplier, int dpMinus1Multiplier){
        if(i==0){
            return (long)dpMinus1Multiplier*dp[0];
        }else{
            return (long)dpMinus1Multiplier*dp[i] + (long)dpMinus2Multiplier*dp[i-1];
        }
    }

    private static void printArray(long[] a){
        StringBuilder s = new StringBuilder();
        for(int i = 0; i<a.length; i++){
            s.append(a[i]).append(',');
        }
        System.out.println(s.toString());
    }

    

    public static void main(String[] s){
//        System.out.println(numDecodings("12**610"));
//        System.out.println(numDecodings("*1*1*0"));
//        System.out.println(numDecodings("0*1*8"));
//        System.out.println(numDecodings("*10*1"));
//        System.out.println(numDecodings("1003"));
//        System.out.println(numDecodings("01*"));
        System.out.println(numDecodings("**********1111111111"));
        System.out.println(numDecodings("**********"));
    }
}
