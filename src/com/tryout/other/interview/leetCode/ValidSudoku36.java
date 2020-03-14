package com.tryout.other.interview.leetCode;

/**
 * @author: Mohit Garg (mohit.garg2905@gmail.com)
 * @createdAt: 2019-Jul-09 9:55 PM
 */
public class ValidSudoku36 {

    public static boolean isValidSudoku(char[][] board) {
        boolean[] rowArray;
        boolean[][] colArray = new boolean[9][10];
        boolean[][] boxArray = null;

        int value;
        for(int i =0; i<9; i++){
            rowArray = new boolean[10];
            if(i%3==0)
                boxArray = new boolean[3][10];
            for(int j=0; j<9; j++){
                if(board[i][j]!='.'){
                    value = board[i][j]-'0';
                    if(value>9 || value<1)
                        return false;
                    if(rowArray[value] || colArray[j][value] || boxArray[j/3][value])
                        return false;
                    rowArray[value] = true;
                    colArray[j][value] = true;
                    boxArray[j/3][value] = true;
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        char[][] input = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(isValidSudoku(input));
    }
}
