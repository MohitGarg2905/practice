package com.tryout.other.interview.leetCode;

import java.util.TreeMap;

/**
 * @author: Mohit Garg (mohit.garg2905@gmail.com)
 * @createdAt: 2019-Jul-16 2:25 PM
 */
public class MaxSlidingWindow239 {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0 || k==0 || nums.length<k)
            return new int[]{};

        TreeMap<Integer, Integer> map = new TreeMap();

        int[] results = new int[nums.length-k+1];
        int currentSize=0;

        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i])+1);
            }else{
                map.put(nums[i], 1);
            }
            currentSize += 1;

            if(currentSize>k){
                if(map.get(nums[i-k])==1){
                    map.remove(nums[i-k]);
                }else{
                    map.put(nums[i-k], map.get(nums[i-k])-1);
                }
                currentSize -= 1;
            }

            if(currentSize==k){
                results[i+1-k] = map.lastKey();
            }
        }
        return results;
    }

    public static void main(String[] args){
        int[] input = {1,3,-1,-3,5,3,6,7};
        int[] output = maxSlidingWindow(input, 3);

        System.out.println(output);
    }
}
