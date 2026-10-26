package leetcode.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0));
        }

        List<Integer>[] buckets = new ArrayList[nums.length + 1];

        for(int num : map.keySet()){
            int count = map.get(num);

            if(buckets[count] == null){
                buckets[count] = new ArrayList<>();
            }
            buckets[count].add(num);
        }

        int[] res = new int[k];
        int index = 0;
        for(int i = buckets.length - 1; i >= 0; i--){
            if(buckets[i] != null){
                for(int num : buckets[i]){
                    res[index++] = num;

                    if (index == k) {
                        return res;
                    }
                }
            }
        }

        return res;






















//        List<Integer>[] buckets = new ArrayList[nums.length + 1];
//
//        for(int num : map.keySet()){
//            int count = map.get(num);
//            if(buckets[count] == null){
//                buckets[count] = new ArrayList<>();
//            }
//            buckets[count].add(num);
//        }
//
//        int[] result = new int[k];
//        int index = 0;
//
//        for (int i = buckets.length - 1; i >= 0; i--) {
//            if (buckets[i] != null) {
//                for (int num : buckets[i]) {
//                    result[index++] = num;
//
//                    if (index == k) {
//                        return result;
//                    }
//                }
//            }
//        }
//
//        return result;


    }
}
