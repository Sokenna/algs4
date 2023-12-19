package com.renyi;

/**
 * @Author: dsy
 * @Date: 2023-12-18 19:58
 * @Description: TODO
 * @Version:1.0
 */
public class Leetcode_221 {
    public static void main(String[] args) {
        char c = '0';
        System.out.println((int)c);
        char[][] matrix = new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','1','1','0'}};
        int minS = maximalSquare(matrix);
        System.out.println(minS);
        char[][] matrix1 = new char[][]{
                {'0','1'},
                {'1','0'}};
        int minS1 = maximalSquare(matrix1);
        System.out.println(minS1);
    }
    public static int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = matrix[0][0]-48;
        int max = dp[0][0];
        for (int i=1;i<m;i++){
            dp[i][0] = matrix[i][0]-48;
            max = Math.max(max,dp[i][0]);
        }
        for (int i=1;i<n;i++){
            dp[0][i] = matrix[0][i]-48;
            max = Math.max(max,dp[0][i]);
        }

        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                if (matrix[i][j] == 49){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),dp[i][j-1])+1;
                }else {
                    dp[i][j] = 0;
                }
                max = Math.max(max,dp[i][j]);
            }
        }
        return max*max;
    }
}
