package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class NumberOfIslands {

    public static void main(String[] args) {

    }


    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int island = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1'){
                    dfs(grid, i, j);
                    island++;
                }
            }
        }
        return island;
    }


    public static void dfs(char[][] board, int i, int j){

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != '1'){
            return;
        }

        board[i][j] = '@';
        dfs(board, i-1, j);
        dfs(board, i, j+1);
        dfs(board, i, j-1);
        dfs(board, i+1, j);
    }

}
