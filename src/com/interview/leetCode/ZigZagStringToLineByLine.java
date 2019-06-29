package com.interview.leetCode;

/**
 * https://leetcode.com/problems/zigzag-conversion/
 *
 * @author: mohit
 * @email: mohit.garg2905@gmail.com
 * @date: 23/6/19
 * @time: 2:45 PM
 */
public class ZigZagStringToLineByLine {

//    PAYPALISHIRING, n rows
//
//    forevery ith row print 2(i-1)th character and (2(n-i))th character alternatevily

    public static String convert(String s, int numRows){
        StringBuilder output = new StringBuilder();
        if(numRows==1 || numRows>=s.length())
            return s;

        int j=0;
        boolean first;
        int step;
        for(int i=numRows; i>0; i--){
            output.append(s.charAt(j));
            first = true;
            step = 2*(i-1);
            int k = j + step;
            while(k<s.length()){
                if(step>0) {
                    output.append(s.charAt(k));
                }
                if (first) {
                    step = 2 * (numRows - i);
                    first = false;
                } else {
                    step = 2 * (i - 1);
                    first = true;
                }
                k += step;
            }
            j++;
        }

        return output.toString();
    }

    public static void main(String[] args){
        String s = "PAYPALISHIRING";
        String expectedOutput = "PINALSIGYAHRPI";
        String output = convert(s, 4);
        if(expectedOutput.equals(output)){
            System.out.println("Correct");
        }else{
            System.out.println("Incorrect");
        }

        s= "PAYPALISHIRING";
        expectedOutput = "PAHNAPLSIIGYIR";
        output = convert(s, 3);
        if(expectedOutput.equals(output)){
            System.out.println("Correct");
        }else{
            System.out.println("Incorrect");
        }

        s= "A";
        expectedOutput = "A";
        output = convert(s, 1);
        if(expectedOutput.equals(output)){
            System.out.println("Correct");
        }else{
            System.out.println("Incorrect");
        }

        s= "AB";
        expectedOutput = "AB";
        output = convert(s, 5);
        if(expectedOutput.equals(output)){
            System.out.println("Correct");
        }else{
            System.out.println("Incorrect");
        }
    }



}
