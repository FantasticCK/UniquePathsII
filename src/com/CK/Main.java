package com.CK;

public class Main {

    public static void main(String[] args) {
        // write your code here
    }
}

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;
        int r = obstacleGrid.length, c = obstacleGrid[0].length;
        int[][] dp = new int[2][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i % 2][j] = 0;
                    continue;
                }

                if (i == 0 && j == 0) {
                    dp[0][0] = 1;
                    continue;
                }

                if (i == 0) {
                    dp[i % 2][j] = dp[i % 2][j - 1];
                    continue;
                }

                if (j == 0) {
                    dp[i % 2][j] = dp[(i - 1) % 2][j];
                    continue;
                }

                dp[i % 2][j] = dp[(i - 1) % 2][j] + dp[i % 2][j - 1];
            }
        }

        return dp[(r - 1) % 2][c - 1];
    }
}