package com.renyi;

/**
 * @Author: dsy
 * @Date: 2023-12-19 11:52
 * @Description: TODO
 * @Version:1.0
 */
public class Leetcode_1901 {
    public static void main(String[] args) {

    }
    public static int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int x = 0,y=0;
        for(int i=0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(mat[x][y] < mat[i][j]){
                    x = i;
                    y = j;
                }
            }
        }
        return new int[]{x,y};
    }
}
