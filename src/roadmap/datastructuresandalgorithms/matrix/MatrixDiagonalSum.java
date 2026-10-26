package roadmap.datastructuresandalgorithms.matrix;

public class MatrixDiagonalSum {

    public static int diagonalSum(int[][] mat) {
        int totalSum = 0;
        int k = mat.length;

        for (int i = 0; i < k; i++) {
            totalSum += mat[i][i] + mat[k-i-1][i];
        }

        if (k % 2 == 1) {
            totalSum -= mat[k/2][k/2];
        }
        return totalSum;
    }


}
