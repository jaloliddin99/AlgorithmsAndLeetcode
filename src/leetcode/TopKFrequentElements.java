package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class TopKFrequentElements {

    public static void main(String[] args) {

    }


    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 1) return nums;

        Arrays.sort(nums);
        int counter = 0;
        ArrayList<Holder> arrayList = new ArrayList<>();


        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == nums[i+1]){
                counter++;
            }else {
                arrayList.add(new Holder(counter, nums[i]));
                counter = 0;
            }
        }

        arrayList.sort(Comparator.comparingInt(d -> d.occurance));
        int[] occuranceArray = arrayList.stream()
                .mapToInt(holder -> holder.occurance)
                .toArray();

        return Arrays.copyOfRange(occuranceArray, 0, k);
    }

    public class Holder{
        int occurance;
        int number;

        public Holder(int occurance, int number) {
            this.occurance = occurance;
            this.number = number;
        }
    }



}
