package leetcode;

import java.util.*;

public class MatrixFindWord {

    public static void main(String[] args) {
        int rows = 5;
        int cols = 5; // Number of columns
        char[][] charArray = new char[rows][cols];

        Random random = new Random();

        // Fill the array with random characters (A-Z)
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                charArray[i][j] = (char) ('A' + random.nextInt(26)); // Random char from A-Z
            }
        }

        // Print the array
        String word = "ZOMN";
        char[] chars = word.toCharArray();
        Map<Integer, Character> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            map.put(i, chars[i]);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char ch = charArray[i][j];
                if (map.containsValue(ch)){

                }
            }
        }



    }

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, String word, int i, int j, int index){

        if (word.length() == index){
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)){
            return false;
        }


        char temp = board[i][j];
        board[i][j] = '0';
        boolean found = dfs(board, word, i-1, j, index+1)
                || dfs(board, word, i, j+1, index+1)
                || dfs(board, word, i, j-1, index+1)
                || dfs(board, word, i+1, j, index+1);

        board[i][j] = temp;

        return found;
    }

}
