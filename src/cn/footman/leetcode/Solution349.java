package cn.footman.leetcode;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author footman77
 * @create 2018-11-07 16:11
 */
public class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set = new TreeSet<>();
        
        for(int i = 0; i < nums1.length; i++){
           set.add(nums1[i]);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int num : nums2){
            if(set.contains(num)){
                list.add(num);
                set.remove(num);
            }
        }

        int[] res = new int[list.size()];
        for(int i = 0;i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;


    }
}
