package com.tryout.other.interview.leetCode;

import com.tryout.other.interview.helpers.MatrixUtils;

/**
 * https://leetcode.com/problems/rotate-image/
 *
 * @author: Mohit Garg (mohit.garg2905@gmail.com)
 * @createdAt: 2019-Jul-08 10:08 PM
 */
public class RotateImage48 {
    /**
     0,0 -> 0,2
     0,1 -> 1,2
     0,2 -> 2,2

     1,0 -> 0,1
     1,1 -> 1,1
     1,2 -> 2,1

     2,0 -> 0,0
     2,1 -> 1,0
     2,2 -> 2,0
     */
    public static void rotate(int[][] matrix) {
        int k, newi, newj, tempi, tempj, temp, curr;
        int n= matrix.length;
        for(int i=0; i<(n+1)/2; i++){
            for(int j=0; j<n/2; j++){
                k=4;
                tempi = i;
                tempj = j;
                curr = matrix[i][j];
                while(k!=0){
                    k--;
                    newj = n - 1 - tempi;
                    newi = tempj;
                    temp = matrix[newi][newj];
                    matrix[newi][newj] = curr;
                    curr = temp;
                    tempi = newi;
                    tempj = newj;
                }
            }
        }
    }

    public static void main(String[] args){
        int[][] input = {{1,2,3},{4,5,6},{7,8,9}};

//        int[][] input = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
//        int[][] input = {{1,2},{3,4}};
        System.out.println("Input");
        MatrixUtils.print2DMatrix(input);
        rotate(input);
        System.out.println("Output");
        MatrixUtils.print2DMatrix(input);
    }


}
