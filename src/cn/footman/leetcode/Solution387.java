package cn.footman.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author footman77
 * @create 2018-11-13 21:02
 */
public class Solution387 {


    public static void main(String[] args) {
        int i = test01("z");
        System.out.println(i);
    }

    public static int test01(String str) {

//        String str = "loveleetcode";
        HashMap<Character, Integer> map = new HashMap<>();
//
//
//
        char[] chars = str.toCharArray();
        for(Character c : chars){
            if(map.containsKey(c)){
                map.put(c,map.get(c) + 1);
            }else {
                map.put(c,1);
            }
        }

        for(int i = 0; i < chars.length; i++){
            if(map.get(chars[i]) == 1){
                return i;
            }
        }
        return -1;
//
//

    }


    public int firstUniqChar(String s){

        int[] freq = new int[26];
        for(int i = 0; i < s.length(); i++){
            freq[s.charAt(i) - 'a']++;
        }

        for(int i = 0; i < s.length(); i++){
            int j = freq[s.charAt(i) - 'a'];
            if(j == 1){
                return i;
            }
        }
        return -1;
    }
}
