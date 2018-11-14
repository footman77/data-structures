package cn.footman.leetcode;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author footman77
 * @create 2018-11-06 21:30
 */
public class Solution804 {
    public int uniqueMorseRepresentations(String[] words) {

        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        Set<String> mima = new TreeSet<String>();

        for(String word : words){
            StringBuilder res = new StringBuilder();
            for(int i = 0; i < word.length(); i++){
                String code = codes[word.charAt(i) - 'a'];

                res.append(code);

            }

            mima.add(res.toString());

        }
        return mima.size();

    }

}
