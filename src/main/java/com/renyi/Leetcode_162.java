package com.renyi;

/**
 * @Author: dsy
 * @Date: 2023-12-18 21:24
 * @Description: TODO
 * @Version:1.0
 */
public class Leetcode_162 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        int peakElement = findPeakElement(nums);
        System.out.println(peakElement);
    }
    public static int findPeakElement(int[] nums) {
        int idx = 0;
        for (int i=1;i<nums.length;i++){
            if (nums[idx] < nums[i]){
                idx = i;
            }
        }
        return idx;
    }
}
