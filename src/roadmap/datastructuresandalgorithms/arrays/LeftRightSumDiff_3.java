package roadmap.datastructuresandalgorithms.arrays;

public class LeftRightSumDiff_3 {

    public int[] leftRightSumDiff(int[] nums) {
        int[] differenceArray = new int[nums.length];
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int rightSum = totalSum - leftSum - nums[i];

            differenceArray[i] = Math.abs(leftSum - rightSum);

            leftSum += nums[i];
        }
        return differenceArray;

    }
}
