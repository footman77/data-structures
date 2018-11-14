package cn.footman.leetcode;

import cn.footman.segmentTree.MySegmentTree;

/**
 * @author footman77
 * @create 2018-11-09 19:25
 */
public class NumArray {

    private MySegmentTree<Integer> segmentTree;

    public NumArray(int[] nums) {
        if(nums.length > 0){
            Integer[] data = new Integer[nums.length];
            for(int i = 0; i < nums.length; i++){
                data[i] = nums[i];
            }
            segmentTree = new MySegmentTree<>(data,(a,b) -> a + b);
        }
    }

    public int sumRange(int i, int j) {
        if(segmentTree == null){
            throw new IllegalArgumentException("SegmentTree is null");
        }
        return segmentTree.query(i,j);
    }
}
