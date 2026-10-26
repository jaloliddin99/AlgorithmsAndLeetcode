package leetcode.google;

import java.util.*;

public class GroupAnagrams {


    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for(String str: strs){

            char[] arr = str.toCharArray();
            Arrays.sort(arr);

            String temp = new String(arr);


            map.putIfAbsent(temp, new ArrayList<>());
            map.get(temp).add(str);
        }
        List<List<String>> res = new ArrayList<>();

        map.forEach((k,v)->{
            if(!v.isEmpty()){
                res.add(v);
            }
        });

        return res;
    }

}
