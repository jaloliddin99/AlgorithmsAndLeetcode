package roadmap.datastructuresandalgorithms.arrays;

import java.util.Arrays;

public class RunningSumOf1DArray {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};

        System.out.println(Arrays.toString(runningSum(arr)));
    }

    public static int[] runningSum(int[] arr) {
        int[] result = new int[arr.length];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            result[i] = sum;
        }
        return result;
    }
}
