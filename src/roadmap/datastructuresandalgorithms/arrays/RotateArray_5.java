package roadmap.datastructuresandalgorithms.arrays;

public class RotateArray_5 {

    public int[] rotate(int[] nums, int k) {
        k %= nums.length;
        rotateArray(nums, 0, nums.length-1);
        rotateArray(nums, k, nums.length-1);
        rotateArray(nums, 0, k-1);
        return nums;
    }

    public void rotateArray(int[] nums, int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            int temp = nums[startIndex];
            nums[startIndex] = nums[endIndex];
            nums[endIndex] = temp;
            startIndex++;
            endIndex--;
        }

    }
}
