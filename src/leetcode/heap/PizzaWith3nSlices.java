package leetcode.heap;

import java.util.Arrays;

public class PizzaWith3nSlices {

    public static void main(String[] args) {

        //incomplete
    }

    public int maxProduct(int[] nums) {
        int max = nums[0];
        int max2 = nums[1];
        for (int i = 2; i < nums.length; i++) {
            int num = Math.min(max2, max);
            if (nums[i] > num){
                if (max2 > max){
                    max = nums[i];
                }else {
                    max2 = nums[i];
                }
            }
        }
        return (max-1)*(max2-1);
    }

    public int maxSizeSlices(int[] slices) {
        int sum = 0;
        int sum2 = 0;
        int sum3 = 0;
        int index = 0;

        while (index < slices.length){
            sum+=slices[index];
            index+=3;
        }
        index = 1;
        while (index < slices.length){
            sum2+=slices[index];
            index+=3;
        }

        index = 2;
        while (index < slices.length){
            sum3+=slices[index];
            index+=3;
        }
        if (sum >= sum2 && sum >= sum3){
            return sum;
        }
        if (sum2 >= sum && sum2 >= sum3){
            return sum2;
        }
        return sum3;
    }
}
