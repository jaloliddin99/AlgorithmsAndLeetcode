package leetcode.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReduceArraySizeHalf {

    public static void main(String[] args) {
        minSetSize(new int[] {3,3,3,3,5,5,5,2,2,7});
    }


    public static int minSetSize(int[] arr) {
        int arraySize = 0;
        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            hashMap.put(arr[i], hashMap.getOrDefault(arr[i], 0)+1);
        }
        PriorityQueue<Holder> priorityQueue = new PriorityQueue<>(
                (a, b) -> b.occurrence - a.occurrence
        );

        hashMap.forEach((number, occurrence) -> {
            priorityQueue.add(new Holder(number, occurrence));
        });

        int counter = 0;
        System.out.println("arr size " + arraySize + " arr " + arr.length);
        while (arraySize < arr.length / 2){
            Holder h = priorityQueue.poll();

            arraySize += h.occurrence;
            counter++;
            System.out.println("arraysize " + arraySize + " counter " + counter + " holder " + h.toString());
        }

        return counter;
    }
    public static class Holder{
        int number;
        int occurrence;

        public Holder(int number, int occurrence) {
            this.number = number;
            this.occurrence = occurrence;
        }

        @Override
        public String toString() {
            return "Holder{" +
                    "number=" + number +
                    ", occurrence=" + occurrence +
                    '}';
        }
    }



}
