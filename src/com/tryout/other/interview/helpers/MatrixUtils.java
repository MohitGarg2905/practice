package com.tryout.other.interview.helpers;

/**
 * @author: Mohit Garg (mohit.garg2905@gmail.com)
 * @createdAt: 2019-Jul-08 10:22 PM
 */
public class MatrixUtils {

    public static void print2DMatrix(int[][] input){
        for(int i=0; i< input.length; i++){
            String s = "";
            for(int j=0; j< input.length; j++){
                s += input[i][j]+",";
            }
            System.out.println(s);
        }
    }
}
