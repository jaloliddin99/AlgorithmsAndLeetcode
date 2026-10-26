package leetcode.google.slidingWindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {


    public int lengthOfLongestSubstring(String s) {

        int left = 0;
        int maxLength = 0;

        Set<Character> set = new HashSet<>();


        for(int right = 0; right < s.length(); right++){

            char c = s.charAt(right);

            while(set.contains(c)){
                set.remove(s.charAt(left++));
                left++;
            }

            set.add(c);

            maxLength = Math.max(maxLength, right-left + 1);

        }

        return maxLength;

    }
}
