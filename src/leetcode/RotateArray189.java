package leetcode;

public class RotateArray189 {

    public void rotate(int[] nums, int k) {
        int[] arr = new int[nums.length];

        int counter = 0;
        int target = k;


        while (counter < k){
            int movable = nums[nums.length - target - 1];
            arr[counter] = movable;
            counter++;
            target--;

        }


        while (counter < nums.length){
            int item = nums[nums.length - counter - 1];
            arr[counter] = item;
            counter++;
        }
        for (int i = 0; i < arr.length; i++) {
            nums[i] = arr[i];
        }


    }

    public int countNumbersWithUniqueDigits(int n) {
        int num = (int) Math.pow(10, n);

        int sum = 0;

        return 0;
    }


    public int numSquares(int n) {

        return leastSquare(0, n, 0);
    }

   public static int leastSquare(int sum, int n, int counter){
        int sqrt = (int) Math.sqrt(n);
        int remainder = n - sqrt * sqrt;
        sum+=sqrt;
        counter++;
        if (sum >= n){
            return counter;
        }
        return leastSquare(sum, remainder, counter);
    }

}
