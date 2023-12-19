package com.renyi;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: dsy
 * @Date: 2023-12-18 22:54
 * @Description: TODO
 * @Version:1.0
 */
public class Leetcode_746 {
    public static void main(String[] args) {
        int[] costs = new int[]{1,100,1,1,1,100,1,1,100,1};
        int tt = minCostClimbingStairs(costs);
        System.out.println(tt);
    }
    public static int minCostClimbingStairs(int[] cost) {
        int[]dp = new int[cost.length];
        for(int i=0;i<cost.length;i++){
            dp[i] = dp[i] + Math.min(cost[i-1],cost[i]);
        }
        return dp[cost.length-1];
    }
}
