package leetcode;

import java.security.KeyPair;
import java.util.*;

public class TopKFrequentElements {

    public static void main(String[] args) {
        topKFrequent(new int[] {4,1,-1,2,-1,2,3}, 2);
    }


    public static int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 1) return nums;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        PriorityQueue<Holder> priorityQueue = new PriorityQueue<>(
                (a, b) -> b.occurance - a.occurance
        );

        map.forEach((number, occurrence) -> priorityQueue.add(new Holder(occurrence, number)));


        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = priorityQueue.poll().number;
        }

        return result;
    }

    public static class Holder{
        int occurance;
        int number;

        public Holder(int occurance, int number) {
            this.occurance = occurance;
            this.number = number;
        }

        @Override
        public String toString() {
            return "Holder{" +
                    "occurance=" + occurance +
                    ", number=" + number +
                    '}';
        }
    }





}
