package leetcode;

public class Search2DMatrix2 {

    public static void main(String[] args) {

        int[][] matrix = new int[][]{{1,4}, {2,5}};
        System.out.println("elements");
       // searchMatrix(new int[][]{{1,4}, {2,5}}, 2);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = 0;
        int col = matrix[0].length - 1; // Start from the top-right corner

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true; // Target found
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false; // Target not found
    }


}
