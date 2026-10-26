package leetcode.google;

import java.util.HashMap;
import java.util.Map;

public class ContiguousSubarray {

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int sum = 0;
        int maxLength = 0;

        // 0,1,0,1,0,0,0,0,1,1,1,1

        for (int i = 0; i < nums.length; i++) {

            sum += nums[i] == 0 ? -1 : 1;
            if (map.containsKey(sum)) {
                int length = i - map.get(sum); //1 - (-1)= 2. // 2 - 1 // 3 -
                maxLength = Math.max(maxLength, length);
            }else {
                map.put(sum, i); // -1, 0 // 0, 1 // -1, 2 //
            }
        }

        return maxLength;
    }

}
