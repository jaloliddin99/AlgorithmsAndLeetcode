package roadmap.datastructuresandalgorithms.arrays;


import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate_2 {

    public static boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set.size() == nums.length;



    }
}
