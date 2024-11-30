package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElementArray {

    public static void main(String[] args) {
        findKthLargest(new int[] { 34, 5, 6, 2, 3, 1, 2, 4, 0}, 4);
    }

    public static int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> integers = new PriorityQueue<>();
        for (int num : nums) {
            integers.add(num);
            if (integers.size() > k){
                integers.poll();
            }
        }

        return integers.poll();
    }



}
