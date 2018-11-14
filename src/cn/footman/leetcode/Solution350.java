package cn.footman.leetcode;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * @author footman77
 * @create 2018-11-07 17:45
 */
public class Solution350 {
    public int[] intersect(int[] nums1, int[] nums2) {

        TreeMap<Integer, Integer> map = new TreeMap<>();


        for(int i = 0; i < nums1.length; i++){
            if(!map.containsKey(nums1[i])){
                map.put(nums1[i],1);
            }else {
                map.put(nums1[i],map.get(nums1[i]) + 1);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int num : nums2){
            if(map.containsKey(num)){
                list.add(num);
                map.put(num,map.get(num) - 1);
                if(map.get(num) == 0){
                    map.remove(num);
                }
            }
        }

        int[] res = new int[list.size()];
        for(int i = 0;i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;

    }
}
