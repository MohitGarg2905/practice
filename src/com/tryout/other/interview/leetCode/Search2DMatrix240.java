package com.tryout.other.interview.leetCode;

/**
 * @author: Mohit Garg (mohit.garg2905@gmail.com)
 * @createdAt: 2019-Jul-06 9:34 PM
 */
public class Search2DMatrix240 {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        return searchSubMatrix(matrix, 0, m-1, 0, n-1, target);
    }

    public static boolean searchSubMatrix(int[][] matrix, int startX, int endX, int startY, int endY, int target){

        int m = endX-startX;
        int n = endY - startY;
        if(m==0 && n==0){
            return matrix[m][n]==target;
        }
        if(matrix[m/2][n/2]==target)
            return true;
        else if(matrix[m/2][n/2]>target){
            return (searchSubMatrix(matrix, startX, m/2-1, startY, n/2-1, target) ||
                    searchSubMatrix(matrix, m/2, endX, startY, n/2-1, target) ||
                    searchSubMatrix(matrix, startX, m/2-1, n/2, endY, target));
        }else {
            return (searchSubMatrix(matrix, m/2, endX, startY, endY, target) ||
                    searchSubMatrix(matrix, startX, endX, n/2, endY, target));
        }

    }

    public static void main(String[] args){
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int target = 5;
        searchMatrix(matrix, target);
    }
}
