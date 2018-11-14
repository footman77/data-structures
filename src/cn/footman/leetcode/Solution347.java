package cn.footman.leetcode;

import cn.footman.heap.MyPriorityQueue;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/**
 * @author footman77
 * @create 2018-11-08 19:20
 */
public class Solution347 {

    private class Freq implements Comparable<Freq>{

        private int e,freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq o) {
            if(this.freq > o.freq){
                return -1;
            }else if(this.freq == o.freq){
                return 0;
            }else {
                return 1;
            }
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(Integer num : nums){
            if(map.containsKey(num)){
                map.put(num,map.get(num) + 1);
            }else {
                map.put(num,1);

            }
        }

        MyPriorityQueue<Freq> pq = new MyPriorityQueue<>();
        for(int key : map.keySet()){
            if(pq.getSize() < k){
                pq.enqueue(new Freq(key,map.get(key)));
            }else if(map.get(key) > pq.getFront().freq){
                pq.dequeue();
                pq.enqueue(new Freq(key,map.get(key)));
            }
        }

        List<Integer> list = new LinkedList<>();
//
        while (!pq.isEmpty()){
            list.add(pq.dequeue().e);

        }
        return list;
    }

    private  void printList(List<Integer> nums){
        for(Integer num: nums)
            System.out.print(num + " ");
        System.out.println();
    }

    @Test
    public  void test() {

        int[] nums = {1, 1, 1, 2, 2, 3,3,3,3,3};
        int k = 2;
        printList(topKFrequent(nums, k));
    }
}
