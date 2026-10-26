package roadmap.datastructuresandalgorithms.matrix;

public class RowWithMaximumOnes {

    public int[] findMaxOnesRow(int[][] mat) {
        int maxOnesIdx = 0;
        int maxOnesCount = 0;

        for(int i = 0; i < mat.length; i++){
            int tempMaxOnesCount = 0;
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 1){
                    tempMaxOnesCount++;
                }
            }
            if(tempMaxOnesCount > maxOnesCount){
                maxOnesCount = tempMaxOnesCount;
                maxOnesIdx = i;
            }
        }
        return new int[]{maxOnesIdx, maxOnesCount};
    }

}
