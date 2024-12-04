package leetcode.heap;


import java.util.*;

public class DistantBarcodes {

    public static void main(String[] args) {


        int number = 5;

        Integer num = 5;


        calculate(7, 9);

    }

    public static void calculate(Integer a, Integer b){
        System.out.println("result " + (a + b));
    }
    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < barcodes.length; i++) {
            map.put(barcodes[i], map.getOrDefault(barcodes[i], 0)+1);
        }
        PriorityQueue<Holder> priorityQueue = new PriorityQueue<>(
                (a, b) -> b.occurrence - a.occurrence
        );

        map.forEach((number, occurrence) -> {
            priorityQueue.add(new Holder(number, occurrence));
        });


        int[] arr = new int[barcodes.length];
        int index = 0;
        while (!priorityQueue.isEmpty()){
            Holder max = priorityQueue.poll();
            Holder secondMax = priorityQueue.poll();
            if (max != null){
                arr[index++] =  max.number;
                max.occurrence--;
            }
            if (secondMax != null){
                arr[index++] =  secondMax.number;
                secondMax.occurrence--;
            }
            if (max != null && max.occurrence > 0){
                priorityQueue.add(max);
            }

            if (secondMax != null && secondMax.occurrence > 0){
                priorityQueue.add(secondMax);
            }
        }

        return arr;
    }

    public static class Holder{
        int number;
        int occurrence;

        public Holder(int number, int occurrence) {
            this.number = number;
            this.occurrence = occurrence;
        }
    }
}
