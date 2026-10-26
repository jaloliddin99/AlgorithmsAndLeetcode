package roadmap.datastructuresandalgorithms.matrix;

public class RichestCustomerWealth {

    public static int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        for(int i = 0; i < accounts.length; i++){
            int rowSum = 0;
            for(int j = 0; j < accounts[i].length; j++){
                rowSum += accounts[i][j];
            }
            if(rowSum > maxWealth){
                maxWealth = rowSum;
            }
        }
        return maxWealth;
    }
}
