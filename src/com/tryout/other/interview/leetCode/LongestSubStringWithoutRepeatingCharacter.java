package com.tryout.other.interview.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: mohit
 * @email: mohit.garg2905@gmail.com
 * @date: 22/6/19
 * @time: 11:30 PM
 */
public class LongestSubStringWithoutRepeatingCharacter {

//    public static int lengthOfLongestSubstringFailed(String s) {
//        int length = 0;
//        Map<Character, Integer> curr = new HashMap();
//        for(int i=0; i<s.length(); i++){
//            if(curr.containsKey(s.charAt(i))){
//                if(curr.keySet().size() > length){
//                    length = curr.keySet().size();
//                }
//                i = curr.get(s.charAt(i));
//                curr = new HashMap();
//            }else {
//                curr.put(s.charAt(i), i);
//            }
//        }
//        return (curr.keySet().size() > length)?curr.keySet().size():length;
//    }

    public static void main(String[] args){
//        System.out.println(lengthOfLongestSubstring("bbbbbb"));
//        System.out.println(lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("dvdcdfdgcidodvdf"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}
