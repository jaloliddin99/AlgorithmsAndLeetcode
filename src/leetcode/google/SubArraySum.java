package leetcode.google;

import java.util.HashMap;
import java.util.Map;

public class SubArraySum {


    public int subarraySum(int[] nums, int k) {


        //1,2,3,4,0,1,2,1   k = 3
        int n = nums.length;

        int preSum = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int i = 0; i < n; i++){
            preSum += nums[i];
            count += map.getOrDefault(preSum-k, 0);
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }


}
