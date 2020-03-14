package com.tryout.other.interview.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Mohit Garg (mohit.garg2905@gmail.com)
 * @createdAt: 2019-Jul-17 12:33 AM
 */
public class LetterCombinationOfPhoneNumber17 {

    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<String>();
        if(digits==null || digits.length()==0)
            return ans;

        char[][] map = new char[8][];
        map[0]="abc".toCharArray();
        map[1]="def".toCharArray();
        map[2]="ghi".toCharArray();
        map[3]="jkl".toCharArray();
        map[4]="mno".toCharArray();
        map[5]="pqrs".toCharArray();
        map[6]="tuv".toCharArray();
        map[7]="wxyz".toCharArray();
        ans.add("");

        for(int i=0; i<digits.length(); i++){
            ans = combine(map[digits.charAt(i)-'2'], ans);
        }
        return ans;
    }

    private static List<String> combine(char[] alphabets, List<String> ans){
        List<String> newList = new ArrayList<>();
        for(String s: ans){
            for(char c:alphabets){
                newList.add(s+c);
            }
        }
        return newList;
    }

    public static void main(String[] args){
        List<String> res = letterCombinations("23");
        System.out.println(res);
    }
}
