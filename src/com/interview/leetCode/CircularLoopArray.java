package com.interview.leetCode;

/**
 * https://leetcode.com/problems/circular-array-loop/
 *
 * @author: mohit
 * @email: mohit.garg2905@gmail.com
 * @date: 23/6/19
 * @time: 6:34 PM
 */
public class CircularLoopArray {

    public static boolean circularArrayLoop(int[] nums) {

        boolean[] isBadNodes = new boolean[nums.length]; //Fixing to 5000 since it's mentioned that n<5000
        boolean isCirlce;
        for(int i=0; i<nums.length; i++){
            isCirlce = isCirclePresent(nums, i, isBadNodes);
            if(isCirlce){
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param nums
     * @param initialIndex
     * @param isBadNodes
     * @return 0 if not circle
     */
    private static boolean isCirclePresent(int[] nums, int initialIndex, boolean[] isBadNodes){
        if(isBadNodes[initialIndex])
            return false;
        boolean[] visitedNodes = new boolean[nums.length];
        int j = initialIndex;
        int length = 0;
        while(true){
            j = (j + nums[j]) % nums.length;
            if(j<0)
                j += nums.length;
            if(visitedNodes[j]){
                if(length>1 && Math.abs(nums[j])!=nums.length)
                    return true;
                return false;
            }else if(isBadNodes[j] || (nums[initialIndex] * nums[j])<0){ //both are in different direction
                //Mark all traversed nodes as bad nodes
                while(initialIndex!=j){
                    isBadNodes[initialIndex] = true;
                    initialIndex = (initialIndex + nums[initialIndex])%nums.length;
                    if(initialIndex<0)
                        initialIndex += nums.length;
                }
                return false;
            }
            visitedNodes[j] = true;
            length++;
        }
    }

    public static  void run(int[] nums){
        System.out.println(nums);
        if(circularArrayLoop(nums))
            System.out.println("Has circle");
        else
            System.out.println("Donot have circle");
    }

    public static void main(String[] args){
//        int[] nums = {1, 1, 1, 2, 2,-1,1,2,2};
//        run(nums);
////        int[] nums2 = {-1,2};
////        run(nums2);
//        int[] nums3 = {-2,1,-1,-2,-2};
//        run(nums3);
//        int[] nums4 = {2,2,2,2,2,4,7};
//        run(nums4);

        System.out.println("cdcd".substring(1));

    }
}
