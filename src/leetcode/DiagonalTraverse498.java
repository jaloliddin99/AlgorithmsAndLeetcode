package leetcode;

import java.util.*;

public class DiagonalTraverse498 {

    public static void main(String[] args) {


    }

    public int[] findDiagonalOrder(int[][] nums) {
        Map<Integer, List<Integer>> hashMap = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                hashMap.putIfAbsent(i + j, new ArrayList<>());
                hashMap.get(i + j).add(nums[i][j]);
            }
        }
        int[] arr = new int[nums.length*nums[0].length];

        int index = 0;
        for (Map.Entry<Integer, List<Integer>> entry : hashMap.entrySet()) {
            List<Integer> diagonal = entry.getValue();
            if (entry.getKey() % 2 == 0) {
                for (int i = diagonal.size() - 1; i >= 0; i--) {
                    arr[index++] = diagonal.get(i);
                }
            } else {
                for (int num : diagonal) {
                    arr[index++] = num;
                }
            }
        }
        return arr;
    }


}
