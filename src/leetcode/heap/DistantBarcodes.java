package leetcode.heap;


import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

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


        return new int[]{};
    }
    public static class Holder{
        int occurrence;
        int number;

        public Holder(int occurance, int number) {
            this.occurrence = occurance;
            this.number = number;
        }

        @Override
        public String toString() {
            return "Holder{" +
                    "occurrence=" + occurrence +
                    ", number=" + number +
                    '}';
        }
    }

}
