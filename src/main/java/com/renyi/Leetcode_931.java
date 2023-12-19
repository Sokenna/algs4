package com.renyi;

import java.util.Arrays;

/**
 * @Author: dsy
 * @Date: 2023-12-18 16:41
 * @Description: TODO
 * @Version:1.0
 */
public class Leetcode_931 {
    public static void main(String[] args) {
        int[][] nums = new int[][]{{-19,57},
                                   {-40,-5}};
        int t = minFallingPathSum(nums);
        System.out.println(t);

        int[][] nums1 = new int[][]{{2,1,3},
                                    {6,5,4},
                                    {7,8,9}};
        t = minFallingPathSum(nums1);
        System.out.println(t);
    }

    public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        System.arraycopy(matrix[0],0,dp[0],0,n);
        for(int i = 1;i < n;i++){
            dp[i][0] = matrix[i][0] + Math.min(dp[i-1][0],dp[i-1][1]);
            for(int j=1;j < n-1;j++){
                dp[i][j] = matrix[i][j] + Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),dp[i-1][j+1]);
            }
            dp[i][n-1] = matrix[i][n-1] + Math.min(dp[i-1][n-2],dp[i-1][n-1]);
        }

        return Arrays.stream(dp[n - 1]).min().getAsInt();
    }
}
