package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MaximalSquare {

    public static void main(String[] args) {

    }


    public int maximalSquare(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int maxSize = 0;
        int[][] dp = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1'){
                    if (i == 0 || j == 0){
                        dp[i][j] = 1;
                    }else {
                        dp[i][j] = Math.min(
                                dp[i-1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])
                        )+1;
                    }
                    maxSize = Math.max(maxSize, dp[i][j]);

                }
            }
        }
        return maxSize*maxSize;
    }


}
