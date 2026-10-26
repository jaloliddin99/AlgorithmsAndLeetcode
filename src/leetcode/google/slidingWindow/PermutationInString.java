package leetcode.google.slidingWindow;

import java.util.Arrays;
import java.util.HashMap;

public class PermutationInString {

//    Input: s1 = "ab", s2 = "eidbaooo"
//    Output: true
//    Explanation: s2 contains one permutation of s1 ("ba").


    public boolean checkInclusion(String s1, String s2) {


        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for(int i = 0; i < s1.length(); i++){
            count1[s1.charAt(i) - 'a']++;
        }


        int left = 0;

        for(int right = 0; right < s2.length(); right++){
            count2[s2.charAt(right) - 'a']++;

            if(right-left+1 > s1.length()){
                count2[s2.charAt(left) - 'a']--;
                left++;
            }

            if (Arrays.equals(count1, count2)) {
                return true;
            }
        }

        return false;
    }

}
