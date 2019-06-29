package com.interview.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 *
 * @author: mohit
 * @email: mohit.garg2905@gmail.com
 * @date: 29/6/19
 * @time: 8:33 PM
 */
public class SubStringWithConcatOfAllWords {

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if(words.length==0)
            return res;
        Map<String, Integer> wordsFreMap = new HashMap<>();
        for(int i=0; i<words.length; i++){
            wordsFreMap.put(words[i], wordsFreMap.getOrDefault(words[i], 0)+1);
        }
        int wordsLen = words[0].length();
        int matchedWordsCount;
        Map<String, Integer> matchedWords;
        int stringLen = s.length();
        int wordsCharLenght = wordsLen*words.length;
        String word;
        for(int i=0; i<(stringLen-wordsCharLenght+1); i++){
            word = s.substring(i, i+wordsLen);
            if(wordsFreMap.containsKey(word)){
                matchedWords = new HashMap<>(wordsFreMap);
                matchedWordsCount = matchedWords.keySet().size();
                if(wordsFreMap.containsKey(word)){
                    if(matchedWords.get(word)==1)
                        matchedWordsCount--;
                    matchedWords.put(word, matchedWords.get(word)-1);
                }else
                    break;
                for(int k=i+wordsLen; k<i+wordsCharLenght; k+=wordsLen){
                    word = s.substring(k, k+wordsLen);
                    if(wordsFreMap.containsKey(word)){
                        if(matchedWords.get(word)<1)
                            break;
                        if(matchedWords.get(word)==1)
                            matchedWordsCount--;
                        matchedWords.put(word, matchedWords.get(word)-1);
                    }else
                        break;
                }
                if(matchedWordsCount==0)
                    res.add(i);

            }
        }
        return  res;
    }

    public static void main(String[] args){
        String s = "aaaaaaaabaa";
        String[] words = {"aa","aa", "aa"};
        List<Integer> res = findSubstring(s, words);
        for(Integer i : res){
            System.out.println(i);
        }
        String s2 = "thefoobarthefoobarfoofg";
        String[] words2 = {"foo","bar"};
        List<Integer> res2 = findSubstring(s2, words2);
        for(Integer i : res2){
            System.out.println(i);
        }
    }
}
