package leetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {

    public static void main(String[] args) {
        lastStoneWeight(new int[] {2,7,4,1,8,1});
    }

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(
                Comparator.reverseOrder()
        );

        for (int stone : stones) {
            priorityQueue.add(stone);
        }
        return removeStones(priorityQueue);
    }

    public static int removeStones(PriorityQueue<Integer> priorityQueue){
        if (priorityQueue.isEmpty()){
            return 0;
        }else if (priorityQueue.size() == 1){
            return priorityQueue.poll();
        } else {

            System.out.println(priorityQueue);
            int y = priorityQueue.poll();
            int x = priorityQueue.poll();

            if (x != y) {
                priorityQueue.offer(y-x);
            }

            return removeStones(priorityQueue);
        }
    }




}
