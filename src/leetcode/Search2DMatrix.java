package leetcode;

public class Search2DMatrix {

    public static void main(String[] args) {

    }

    public boolean searchMatrix(int[][] matrix, int target) {

        for (int i = 0; i < matrix.length - 1; i++) {
            int index = matrix[i][0];
            int indexF = matrix[i+1][0];

            if (target >= index && target < indexF){
                boolean isPresent = false;
                for (int j = 0; j < matrix[i].length; j++) {
                    if (target == matrix[i][j]){
                        isPresent = true;
                    }
                }
                return isPresent;
            }
        }

        boolean isPresent = false;
        for (int j = 0; j < matrix[matrix.length-1].length; j++) {
            if (target == matrix[matrix.length-1][j]){
                isPresent = true;
            }
        }
        return isPresent;
    }


}
