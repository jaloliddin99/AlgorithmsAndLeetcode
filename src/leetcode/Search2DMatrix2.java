package leetcode;

public class Search2DMatrix2 {

    public static void main(String[] args) {

        int[][] matrix = new int[][]{{1,4}, {2,5}};
        System.out.println("elements");
       // searchMatrix(new int[][]{{1,4}, {2,5}}, 2);
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        //[[-1,3]]
        // value  = 5

        //[[1,4],
        // [2,5]]
        //target = 2

        int row = 0;
        int col = 0;
        int lCol = matrix.length;
        int lRow = matrix[0].length;

        while (row < lRow && col < lCol){
            int d = matrix[col][row];
            int l = matrix[col][0];
            int t = matrix[0][row];
            if (target == d){
                return true;
            }
            if (target > d){
                row++;
                col++;
                continue;
            }
            int tRow = row;
            int tCol = col;
            if (target < d){
                if (target < l && target < t){
                    return false;
                }
                if (target >= l){
                    if (searchHorizontally(matrix, target, tCol, tRow)){
                        return true;
                    } else {
                        col++;
                    }
                } else {
                    row++;
                }

                if (target >= t){
                    if (searchVertically(matrix, target, tCol, tRow)){
                        return true;
                    } else {
                        row++;
                    }
                }else {
                    col++;
                }
            }
        }

        System.out.println("col " + col + " row " +row);
        if (row < lRow){
            for (int i = 0; i < lRow; i++) {
                if (matrix[col-1][i] == target){
                    return true;
                }
            }
        }

        if (col < lCol){
            for (int i = 0; i < lCol; i++) {
                if (matrix[i][row-1] == target){
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean searchHorizontally(int[][] matrix, int target, int col, int row){
        for (int i = 0; i <= col; i++) {
            if (matrix[row][i] == target){
                return true;
            }
        }
        return false;
    }
    public static boolean searchVertically(int[][] matrix, int target, int col, int row) {
        for (int i = 0; i <= row; i++) {
            if (matrix[col][i] ==  target){
                return true;
            }
        }
        return false;
    }



}
