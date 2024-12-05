package leetcode.heap;

import java.util.*;

public class DiagonalTraverse {

    public static void main(String[] args) {
    }

    int counter = 0;
    public int[] findDiagonalOrder(List<List<Integer>> nums) {

        int c = 0;

        ArrayList<Integer> integers = new ArrayList<>();
        Map<Integer, ArrayList<Integer>> hashMap = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                c++;
                ArrayList<Integer> arr = hashMap.getOrDefault(i+j, new ArrayList<>());
                arr.add(nums.get(i).get(j));
                hashMap.put(i+j, arr);
            }
        }
        int[] arr = new int[c];
        int index = 0;

        for (Map.Entry<Integer, ArrayList<Integer>> entry : hashMap.entrySet()) {
            List<Integer> diagonal = entry.getValue();

            Collections.reverse(diagonal);
            for (int num : diagonal) {
                arr[index++] = num;
            }
        }
        return arr;
    }



}
