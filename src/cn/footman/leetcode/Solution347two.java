package cn.footman.leetcode;





import java.util.*;

/**
 * @author footman77
 * @create 2018-11-08 20:46
 */
public class Solution347two {
    private class Freq{

        private int e,freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }
        //由于java内置的PriorityQueue为最小堆

    }

    private class FreqComparator implements Comparator<Freq>{

        @Override
        public int compare(Freq o1, Freq o2) {
            return o1.freq - o2.freq;
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

        PriorityQueue<Freq> pq = new PriorityQueue<>(new FreqComparator()); //(a,b) -> map.get(a) - map.get(b)
        for(int key : map.keySet()){
            if(pq.size() < k){
                pq.add(new Freq(key,map.get(key)));
            }else if(map.get(key) > pq.peek().freq){
                pq.remove();
                pq.add(new Freq(key,map.get(key)));
            }
        }

        List<Integer> list = new LinkedList<>();
//
        while (!pq.isEmpty()){
            list.add(pq.remove().e);

        }
        return list;
    }

}
